import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FlightDatabaseFactory {
    ArrayList<Flight> flights = new ArrayList<Flight>();

    public FlightDatabaseFactory(String path) {

        File file = new File(path);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String[] line = scanner.nextLine().split(",");
                String departure = line[0].trim();
                String arrival = line[1].trim();
                int price = Integer.parseInt(line[2].trim());
                String flightTime = line[3].trim();
                flights.add(new Flight(departure, arrival, price, flightTime));
            }
        } catch (FileNotFoundException  e) {
            System.out.println("No file found: " + path);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Flight flight : flights) {
            sb.append(flight.getDetails()).append("\n");
        }
        return sb.toString();
    }
}
