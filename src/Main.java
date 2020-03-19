public class Main {
    public static void main(String[] args){
        FlightDatabase flightDatabase = new FlightDatabase();
        flightDatabase.displayFlightDatabase();
        if(flightDatabase.checkIfFlightExists("Paris", "Berlin")){
            System.out.println("Flight exists.");
        }
        else {
            System.out.println("Flight not exists.");
        }
    }
}