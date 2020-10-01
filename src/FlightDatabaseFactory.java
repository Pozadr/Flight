import java.util.ArrayList;

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
        this.flights.add(new Flight("Warsaw", "Porto",
                120, "02h 45min"));
        this.flights.add(new Flight("Warsaw", "Porto",
                190, "01h 20min"));
        this.flights.add(new Flight("Warsaw", "Porto",
                300, "01h 20min"));
        this.flights.add(new Flight("Warsaw", "Berlin",
                100, "01h 20min"));
        this.flights.add(new Flight("Warsaw", "Porto",
                380, "03h 10min"));
        this.flights.add(new Flight("Warsaw", "Barcelona",
                160, "03h 20min"));
    }

    public FlightDatabaseFactory(String path) {
        System.out.println();
    }
}
