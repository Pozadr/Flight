
public class Main {
    public static void main(String[] args){
        FlightDatabase flightDatabase = new FlightDatabase();
        //User user1 = new User();

        //user1.displayNick();
        //flightDatabase.displayAllFlights();

        //flightDatabase.displayFlightsFromCity("Warsaw");
        //flightDatabase.displayFlightsToCity("Paris");

        //flightDatabase.checkIfFlightExists("Warsaw", "Paris"); // true
        //flightDatabase.checkIfFlightExists("Warsaw", "Berlin"); // false

        //ArrayList<String> cities = flightDatabase.getCities();
        //System.out.println(cities);

        //flightDatabase.displayCheapestFlight();

        //flightDatabase.displayCheapestFlightFromCity("Warsaw");

        //flightDatabase.displayCheapestFlightToCity("Warsaw");

        //flightDatabase.displayFlights("Warsaw", "Berlin");
        //flightDatabase.displayCheapestJourney("Warsaw", "Berlin");

        //flightDatabase.displayDirectFlights("Warsaw", "Paris");

        flightDatabase.manageRequest("Berlin", "Porto");


    }
}