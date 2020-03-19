public class Main {
    public static void main(String[] args){
        FlightDatabase flightDatabase = new FlightDatabase();
        User user1 = new User();

        user1.displayNick();
        //flightDatabase.displayFlightDatabase();
        flightDatabase.checkIfFlightExists(user1.getRequestFromUser());

    }
}