import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        FlightDatabaseFactory flightDatabase = new FlightDatabaseFactory("FlightDB.txt");
        FlightDatabaseManagement manageFlightDatabase = new FlightDatabaseManagement();

        //User user1 = new User();

        //user1.displayNick();

        /*System.out.println("Welcome in flight search browser.");
        System.out.println("Please type request.");
        System.out.println("Flight from: ");
        String flightFrom = scanner.next().trim();
        System.out.println("Flight to: ");
        String flightTo = scanner.next().trim();
        manageFlightDatabase.manageRequest(flightFrom, flightTo, flightDatabase.flights);

         */


    }
}