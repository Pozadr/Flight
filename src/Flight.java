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
                " cost " + this.price + ". Flight time: " + flightTime;
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

    public String getFlightTimeString() {
        return flightTime;
    }

    public int getFlightTimeInInt(){
        int h = Integer.parseInt(this.flightTime.substring(0,2));
        int min = Integer.parseInt(this.flightTime.substring(4,6));
        return h * 60 + min;
    }
}
