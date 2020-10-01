import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FlightDatabaseFactory {
    ArrayList<Flight> flights = new ArrayList<Flight>();

    public FlightDatabaseFactory() {
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

    }

    public FlightDatabaseFactory(String path) {

        File file = new File(path);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine() + " ");
            }
        } catch (FileNotFoundException  e) {
            System.out.println("No file found: " + path);
        }
    }
}
