import java.util.ArrayList;

public class FlightDatabase {
    ArrayList<Flight> flights = new ArrayList<Flight>();

    public FlightDatabase(){
        this.flights.add(new Flight("Berlin", "Tokyo",
                1800, "12h 50min"));
        this.flights.add(new Flight("Berlin", "Warsaw",
                77, "00h 50min"));
        this.flights.add(new Flight("Paris", "Berlin",
                79, "01h 10min"));
        this.flights.add(new Flight("Paris", "Madrid",
                180, "01h 20min"));
        this.flights.add(new Flight("Paris", "Warsaw",
                130, "02h 40min"));
        this.flights.add(new Flight("Madrid", "Berlin",
                200, "01h 10min"));
        this.flights.add(new Flight("Madrid", "Porto",
                102, "02h 10min"));
        this.flights.add(new Flight("Porto", "Warsaw",
                412, "04h 20min"));
        this.flights.add(new Flight("Barcelona", "Berlin",
                30, "02h 30min"));
        this.flights.add(new Flight("Tokyo", "Warsaw",
                2000, "10h 20min"));
        this.flights.add(new Flight("Warsaw", "Paris",
                120, "02h 45min"));
        this.flights.add(new Flight("Warsaw", "Paris",
                190, "01h 20min"));
        this.flights.add(new Flight("Warsaw", "Paris",
                300, "01h 20min"));
        this.flights.add(new Flight("Warsaw", "Berlin",
                100, "01h 20min"));
        this.flights.add(new Flight("Warsaw", "Madrid",
                380, "03h 10min"));
        this.flights.add(new Flight("Warsaw", "Barcelona",
                160, "03h 20min"));
    }
    // ------------------------------------------------------------------------------

    //Display
    public void displayDirectFlights(String start, String end){
        ArrayList<Flight> results = getDirectFlights(start, end);
        if(results.isEmpty()){
            System.out.println("Flight not found.");
        }
        for(Flight result : results){
            System.out.println(result.getDetails());
        }
    }

    public void displayJourneyFlights(String start, String end){
        ArrayList<Journey> results = getJourneyFlights(start, end);
        if(results.isEmpty()){
            System.out.println("Flight not found.");
        }
        for(Journey result : results){
            System.out.println(result.getDetails());
        }
    }

    public void displayAllFlights(){
        if(this.flights.isEmpty()){
            System.out.println("Flight not found.");
        }
        for(Flight flight : this.flights){
            System.out.println(flight.getDetails());
        }
    }

    public void displayFlightsFromCity(String city){
        ArrayList<Flight> results = getFlightsFromCity(city);
        if(results.isEmpty()){
            System.out.println("Flight form " + city + " not found.");
        }
        for(Flight flight : results){
            System.out.println(flight.getDetails());
        }
    }

    public void displayFlightsToCity(String city){
        ArrayList<Flight> results = getFlightsToCity(city);
        if(results.isEmpty()){
            System.out.println("Flight to " + city + " not found.");
        }
        for(Flight flight : results){
            System.out.println(flight.getDetails());
        }
    }

    // Display cheapest flight from all flights in data base.
    public void displayCheapestFlight(){
        Flight results = getCheapestFlight();
        System.out.println("Cheapest flight:\n" + results.getDetails());
    }

    public void displayCheapestFlightFromCity(String city){
        Flight cheapestFlightFromCity = getCheapestFlightFromCity(city);
        System.out.println("Cheapest flight from " + city + ":\n" +
                cheapestFlightFromCity.getDetails());
    }

    public void displayCheapestFlightToCity(String city){
        Flight cheapestFlightToCity = getCheapestFlightToCity(city);
        System.out.println("Cheapest flight to " + city + ":\n" +
                cheapestFlightToCity.getDetails());
    }

    public void displayCheapestDirectFlight(String start, String end){
        Flight results = getCheapestDirectFlight(start, end);
        System.out.println("Cheapest direct flight:\n" + results.getDetails());
    }

    public void displayCheapestJourney(String start, String end){
        Journey result = getCheapestJourney(start, end);
        if(result == null){
            System.out.println("Journey from " + start +
                    " to " + end + " not found.");
        }
        else{
            System.out.println("Cheapest journey is:");
            System.out.println(result.getDetails());
        }
    }

    public void displayShortestDirectFlight(String start, String end){
        Flight shortestDirectFlight = getShortestDirectFlight(start, end);
        System.out.println("Shortest flight from " + start + " to " + end +
                ":\n" + shortestDirectFlight.getDetails());
    }
    // ------------------------------------------------------------------------------

    // Get
    public ArrayList<Flight> getDirectFlights(String start, String end){
        ArrayList<Flight> result = new ArrayList<>();
        for (Flight flight : this.flights) {
            if (flight.getDeparture().equals(start) &&
                    flight.getArrival().equals(end)) {
                //System.out.println("Direct flight exists.");
                result.add(flight);
            }
        }
        //System.out.println("Flight not exists.");
        return result;
    }

    public ArrayList<Journey> getJourneyFlights(String start, String end) {
        ArrayList<Flight> startList = getFlightsFromCity(start);
        ArrayList<Flight> endList = getFlightsToCity(end);
        ArrayList<Journey> results = new ArrayList<>();
        for (Flight first : startList) {
            for (Flight second : endList) {
                if (first.getArrival() ==
                        second.getDeparture()) {
                    results.add(new Journey(first, second));
                }
            }
        }
        return results;
    }

    public ArrayList<Flight> getFlightsFromCity(String city){
        ArrayList<Flight> results = new ArrayList<>();
        for(Flight flight : this.flights){
            if(flight.getDeparture().equals(city)){
                results.add(flight);
            }
        }
        return results;
    }

    public ArrayList<Flight> getFlightsToCity(String city){
        ArrayList<Flight> results = new ArrayList<>();
        for(Flight flight : this.flights){
            if(flight.getArrival().equals(city)){
                results.add(flight);
            }
        }
        return results;
    }

    // Get all cities from database.
    public ArrayList<String> getCities(){
        ArrayList<String> cities = new ArrayList<>();
        for(Flight flight : this.flights){
            if(!cities.contains(flight.getDeparture())){
                cities.add(flight.getDeparture());
            }
            if(!cities.contains(flight.getArrival())){
                cities.add(flight.getArrival());
            }
        }
        return cities;
    }

    // Get cheapest flight from all flights in database.
    public Flight getCheapestFlight(){
        Flight cheapestFlight = null;
        for(Flight flight : this.flights){
            if(cheapestFlight == null || flight.getPrice() <
                    cheapestFlight.getPrice()){
                cheapestFlight = flight;
            }
        }
        return cheapestFlight;
    }

    public Flight getCheapestFlightFromCity(String city){
        ArrayList<Flight> flights = getFlightsFromCity(city);
        Flight cheapestFlight = null;
        for(Flight flight : flights){
            if(cheapestFlight == null || flight.getPrice() <
                    cheapestFlight.getPrice()){
                cheapestFlight = flight;
            }
        }
        return cheapestFlight;
    }

    public Flight getCheapestFlightToCity(String city){
        ArrayList<Flight> flights = getFlightsToCity(city);
        Flight cheapestFlight = null;
        for(Flight flight : flights){
            if(cheapestFlight == null || flight.getPrice() <
                    cheapestFlight.getPrice()){
                cheapestFlight = flight;
            }
        }
        return cheapestFlight;
    }

    public Flight getCheapestDirectFlight(String start, String end){
        ArrayList<Flight> flights = getDirectFlights(start, end);
        Flight cheapestDirectFlight = null;
        for(Flight flight : flights){
            if(cheapestDirectFlight == null || flight.getPrice() <
                    cheapestDirectFlight.getPrice()){
                cheapestDirectFlight = flight;
            }
        }
        return cheapestDirectFlight;
    }

    public Journey getCheapestJourney(String start, String end) {
        ArrayList<Journey> journeys = getJourneyFlights(start, end);
        Journey cheapestJourney = null;
        for (Journey journey : journeys) {
            if (cheapestJourney == null || journey.getJourneyPrice() <
                    cheapestJourney.getJourneyPrice()) {
                cheapestJourney = journey;
            }
        }
        return cheapestJourney;
    }

    public Flight getShortestDirectFlight(String start, String end){
        ArrayList<Flight> flights = getDirectFlights(start, end);
        Flight shortestFlight = null;
        for(Flight flight : flights){
            if(shortestFlight == null || flight.getFlightTimeInInt() <
                    shortestFlight.getFlightTimeInInt()){
                shortestFlight = flight;
            }
        }
        return shortestFlight;
    }
    // ------------------------------------------------------------------------------

    // Others
    public boolean checkIfFlightExists(String departure, String arrival){
        for (Flight flight : this.flights) {
            if (flight.getDeparture().equals(departure) && flight.getArrival().equals(arrival)) {
                //System.out.println("Direct flight exists.");
                return true;
            }
        }
        //System.out.println("Flight not exists.");
        return false;
    }

    public void manageRequest(String start, String end){
        if (checkIfFlightExists(start, end)) {
            displayCheapestDirectFlight(start, end);
            displayShortestDirectFlight(start, end);
        }
        else{
            System.out.println("There is no direct flight from " +
            start + " to " + end + ".");
            displayCheapestJourney(start, end);
        }
    }
    // ------------------------------------------------------------------------------

}
