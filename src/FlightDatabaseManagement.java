import java.util.ArrayList;

public class FlightDatabaseManagement {

    //Display
    public void displayDirectFlights(String start, String end, ArrayList<Flight> flights){
        ArrayList<Flight> results = getDirectFlights(start, end, flights);
        if(results.isEmpty()){
            System.out.println("Flight not found.");
        }
        System.out.println("Direct flights: ");
        for(Flight result : results){
            System.out.println(result.getDetails());
        }
    }

    public void displayCheapestDirectFlight(String start, String end, ArrayList<Flight> flights){
        Flight results = getCheapestDirectFlight(start, end, flights);
        System.out.println("Cheapest direct flight:\n" + results.getDetails());
    }

    public void displayShortestDirectFlight(String start, String end, ArrayList<Flight> flights){
        Flight shortestDirectFlight = getShortestDirectFlight(start, end, flights);
        System.out.println("Shortest flight from " + start + " to " + end +
                ":\n" + shortestDirectFlight.getDetails());
    }

    public void displayJourneyFlights(String start, String end, ArrayList<Flight> flights){
        ArrayList<Journey> results = getJourneyFlights(start, end, flights);
        if(results.isEmpty()){
            System.out.println("Flight not found.");
        }
        System.out.println("Journey flights: ");
        for(Journey result : results){
            System.out.println(result.getDetails());
        }
    }

    public void displayCheapestJourney(String start, String end, ArrayList<Flight> flights){
        Journey result = getCheapestJourney(start, end, flights);
        if(result == null){
            System.out.println("Journey from " + start +
                    " to " + end + " not found.");
        }
        else{
            System.out.println("Cheapest journey is:");
            System.out.println(result.getDetails());
        }
    }

    public void displayShortestJourney(String start, String end, ArrayList<Flight> flights){
        Journey result = getShortestJourney(start, end, flights);
        if(result == null){
            System.out.println("Journey from " + start +
                    " to " + end + " not found.");
        }
        else{
            System.out.println("Shortest journey is:");
            System.out.println(result.getDetails());
        }
    }

    public void displayAllFlights(ArrayList<Flight> flights){
        if(flights.isEmpty()){
            System.out.println("Flight not found.");
        }
        for(Flight flight : flights){
            System.out.println(flight.getDetails());
        }
    }

    public void displayFlightsFromCity(String city, ArrayList<Flight> flights){
        ArrayList<Flight> results = getFlightsFromCity(city, flights);
        if(results.isEmpty()){
            System.out.println("Flight form " + city + " not found.");
        }
        for(Flight flight : results){
            System.out.println(flight.getDetails());
        }
    }

    public void displayFlightsToCity(String city, ArrayList<Flight> flights){
        ArrayList<Flight> results = getFlightsToCity(city, flights);
        if(results.isEmpty()){
            System.out.println("Flight to " + city + " not found.");
        }
        for(Flight flight : results){
            System.out.println(flight.getDetails());
        }
    }

    // Display cheapest flight from all flights in data base.
    public void displayCheapestFlight(ArrayList<Flight> flights){
        Flight results = getCheapestFlight(flights);
        System.out.println("Cheapest flight:\n" + results.getDetails());
    }

    public void displayCheapestFlightFromCity(String city, ArrayList<Flight> flights){
        Flight cheapestFlightFromCity = getCheapestFlightFromCity(city, flights);
        System.out.println("Cheapest flight from " + city + ":\n" +
                cheapestFlightFromCity.getDetails());
    }

    public void displayCheapestFlightToCity(String city, ArrayList<Flight> flights){
        Flight cheapestFlightToCity = getCheapestFlightToCity(city, flights);
        System.out.println("Cheapest flight to " + city + ":\n" +
                cheapestFlightToCity.getDetails());
    }


    // ------------------------------------------------------------------------------

    // Get
    public ArrayList<Flight> getDirectFlights(String start, String end, ArrayList<Flight> flights){
        ArrayList<Flight> result = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.getDeparture().equals(start) &&
                    flight.getArrival().equals(end)) {
                //System.out.println("Direct flight exists.");
                result.add(flight);
            }
        }
        //System.out.println("Flight not exists.");
        return result;
    }

    public ArrayList<Journey> getJourneyFlights(String start, String end, ArrayList<Flight> flights) {
        ArrayList<Flight> startList = getFlightsFromCity(start, flights);
        ArrayList<Flight> endList = getFlightsToCity(end, flights);
        ArrayList<Journey> results = new ArrayList<>();
        for (Flight first : startList) {
            for (Flight second : endList) {
                if (first.getArrival().equals(second.getDeparture())) {
                    results.add(new Journey(first, second));
                }
            }
        }
        return results;
    }

    public ArrayList<Flight> getFlightsFromCity(String city, ArrayList<Flight> flights){
        ArrayList<Flight> results = new ArrayList<>();
        for(Flight flight : flights){
            if(flight.getDeparture().equals(city)){
                results.add(flight);
            }
        }
        return results;
    }

    public ArrayList<Flight> getFlightsToCity(String city, ArrayList<Flight> flights){
        ArrayList<Flight> results = new ArrayList<>();
        for(Flight flight : flights){
            if(flight.getArrival().equals(city)){
                results.add(flight);
            }
        }
        return results;
    }

    // Get all cities from database.
    public ArrayList<String> getCities(ArrayList<Flight> flights){
        ArrayList<String> cities = new ArrayList<>();
        for(Flight flight : flights){
            if(!cities.contains(flight.getDeparture())){
                cities.add(flight.getDeparture());
            }
            if(!cities.contains(flight.getArrival())){
                cities.add(flight.getArrival());
            }
        }
        return cities;
    }

    /**
     * Get cheapest flight from all flights in database.
     * @return cheapest Flight as Flight object
     */
    public Flight getCheapestFlight(ArrayList<Flight> flights){
        Flight cheapestFlight = null;
        for(Flight flight : flights){
            if(cheapestFlight == null || flight.getPrice() <
                    cheapestFlight.getPrice()){
                cheapestFlight = flight;
            }
        }
        return cheapestFlight;
    }

    public Flight getCheapestFlightFromCity(String city, ArrayList<Flight> flights){
        ArrayList<Flight> flightsFromCity = getFlightsFromCity(city, flights);
        Flight cheapestFlight = null;
        for(Flight flight : flightsFromCity){
            if(cheapestFlight == null || flight.getPrice() <
                    cheapestFlight.getPrice()){
                cheapestFlight = flight;
            }
        }
        return cheapestFlight;
    }

    public Flight getCheapestFlightToCity(String city, ArrayList<Flight> flights){
        ArrayList<Flight> flightsToCity = getFlightsToCity(city, flights);
        Flight cheapestFlight = null;
        for(Flight flight : flightsToCity){
            if(cheapestFlight == null || flight.getPrice() <
                    cheapestFlight.getPrice()){
                cheapestFlight = flight;
            }
        }
        return cheapestFlight;
    }

    public Flight getCheapestDirectFlight(String start, String end, ArrayList<Flight> flights){
        ArrayList<Flight> directFlights = getDirectFlights(start, end, flights);
        Flight cheapestDirectFlight = null;
        for(Flight flight : directFlights){
            if(cheapestDirectFlight == null || flight.getPrice() <
                    cheapestDirectFlight.getPrice()){
                cheapestDirectFlight = flight;
            }
        }
        return cheapestDirectFlight;
    }

    public Journey getCheapestJourney(String start, String end, ArrayList<Flight> flights) {
        ArrayList<Journey> journeyFlights = getJourneyFlights(start, end, flights);
        Journey cheapestJourney = null;
        for (Journey journey : journeyFlights) {
            if (cheapestJourney == null || journey.getJourneyPrice() <
                    cheapestJourney.getJourneyPrice()) {
                cheapestJourney = journey;
            }
        }
        return cheapestJourney;
    }

    public Flight getShortestDirectFlight(String start, String end, ArrayList<Flight> flights){
        ArrayList<Flight> directFlights = getDirectFlights(start, end, flights);
        Flight shortestFlight = null;
        for(Flight flight : directFlights){
            if(shortestFlight == null || flight.getFlightTimeInMinutes() <
                    shortestFlight.getFlightTimeInMinutes()){
                shortestFlight = flight;
            }
        }
        return shortestFlight;
    }

    public Journey getShortestJourney(String start, String end, ArrayList<Flight> flights){
        ArrayList<Journey> journeyFlights = getJourneyFlights(start, end, flights);
        Journey shortestJourney = null;
        for (Journey journey : journeyFlights) {
            if(shortestJourney == null || journey.getJourneyTimeInMinutes() <
                    shortestJourney.getJourneyTimeInMinutes()){
                shortestJourney = journey;
            }
        }
        return shortestJourney;
    }
    // ------------------------------------------------------------------------------

    // Others
    public boolean checkIfDirectFlightExists(String departure, String arrival, ArrayList<Flight> flights){
        for (Flight flight : flights) {
            if (flight.getDeparture().equals(departure) && flight.getArrival().equals(arrival)) {
                //System.out.println("Direct flight exists.");
                return true;
            }
        }
        //System.out.println("Flight not exists.");
        return false;
    }

    public void manageRequest(String start, String end, ArrayList<Flight> flights){
        if (checkIfDirectFlightExists(start, end, flights)) {
            displayDirectFlights(start, end, flights);
            displayCheapestDirectFlight(start, end, flights);
            displayShortestDirectFlight(start, end, flights);
        }
        else{
            System.out.println("There is no direct flight from " +
            start + " to " + end + ".");
            displayJourneyFlights(start, end, flights);
            displayCheapestJourney(start, end, flights);
            displayShortestJourney(start, end, flights);
        }
    }
    // ------------------------------------------------------------------------------

}
