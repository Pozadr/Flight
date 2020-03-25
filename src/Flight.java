public class Flight {
    private String departure;
    private String arrival;
    private int price;

    // Constructor
    public Flight(String departure, String arrival, int price) {
        this.arrival = arrival;
        this.departure = departure;
        this.price = price;
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
}
