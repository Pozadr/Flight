public class Flight {
    private String departure;
    private String arrival;
    private int price;
    private String flightTime;

    // Constructor
    public Flight(String departure, String arrival, int price, String flightTime) {
        this.arrival = arrival;
        this.departure = departure;
        this.price = price;
        this.flightTime = flightTime;
    }

    // Get
    public String getDetails() {
        return "Flight from: " + this.departure + " to: " + this.arrival +
                " cost " + this.price;
    }

    public String getDeparture() {
        return departure;
    }

    public String getArrival() {
        return arrival;
    }

    public int getPrice() {
        return price;
    }

    public String getFlightTime() {
        return flightTime;
    }
}
