import java.util.ArrayList;

public class FlightDatabase {
    ArrayList<Flight> flights = new ArrayList<Flight>();

    public FlightDatabase(){
        this.flights.add(new Flight("Berlin", "Tokyo"));
        this.flights.add(new Flight("Paris", "Berlin"));
        this.flights.add(new Flight("Warsaw", "Paris"));
        this.flights.add(new Flight("Madrid", "Berlin"));
        this.flights.add(new Flight("Berlin", "Warsaw"));
        this.flights.add(new Flight("Paris", "Madrid"));
        this.flights.add(new Flight("Porto", "Warsaw"));
        this.flights.add(new Flight("Madrid", "Porto"));
        this.flights.add(new Flight("Warsaw", "Madrid"));
    }

    public void displayFlightDatabase(){
        for(int i=0; i<this.flights.size(); i++){
            System.out.print(i+1 + ". ");
            flights.get(i).getDetails();
        }
    }

    public boolean checkIfFlightExists(String[] request){
        for (Flight flight : this.flights) {
            if (flight.getDeparture().equals(request[0]) && flight.getArrival().equals(request[1])) {
                System.out.println("Flight exists.");
                return true;
            }
        }
        System.out.println("Flight not exists.");
        return false;
    }


}
