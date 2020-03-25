import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        FlightDatabase flightDatabase = new FlightDatabase();
        //User user1 = new User();

        //user1.displayNick();
        //flightDatabase.displayAllFlights();

        //flightDatabase.displayFlightsFromCity("Warsaw");
        //flightDatabase.displayFlightsToCity("Paris");

        //flightDatabase.checkIfFlightExists(user1.getRequestFromUser());

        //ArrayList<String> cities = flightDatabase.getCities();
        //System.out.println(cities);

        //Flight cheapestFlight = flightDatabase.getCheapestFlight();
        //System.out.println("Cheapest flight:\n" + cheapestFlight.getDetails());

        /*String fromCity = "Warsaw";
        Flight cheapestFlightFromCity = flightDatabase.getCheapestFlightFromCity(fromCity);
        System.out.println("Cheapest flight from " + fromCity + ":\n" +
                cheapestFlightFromCity.getDetails());

        String toCity = "Warsaw";
        Flight cheapestFlightToCity = flightDatabase.getCheapestFlightToCity(toCity);
        System.out.println("Cheapest flight to " + toCity + ":\n" +
                cheapestFlightToCity.getDetails());
        */
        flightDatabase.displayFlights("Paris", "Porto");
    }
}