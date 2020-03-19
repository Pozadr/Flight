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

    public boolean checkIfFlightExists(String departure, String arrival){
        for(int i=0; i<this.flights.size(); i++){
            Flight flight;
            flight = flights.get(i);
            if(flight.getDeparture() == departure && flight.getArrival() == arrival){
                return true;
            }
        }
        return false;
    }


}
