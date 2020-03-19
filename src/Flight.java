public class Flight {
    private String departure;
    private String arrival;

    // Constructor
    public Flight(String departure, String arrival) {
        this.arrival = arrival;
        this.departure = departure;
    }

    // Getters
    public void getDetails() {
        System.out.println("Flight from: " + this.departure
                + " to: " + this.arrival);
    }

    public String getDeparture() {
        return departure;
    }

    public String getArrival() {
        return arrival;
    }
}
