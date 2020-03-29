public class Journey {
    private Flight first;
    private Flight second;

    public Journey(Flight first, Flight second){
        this.first = first;
        this.second = second;
    }

    // get
    public Flight getFirst() {

        return first;
    }

    public Flight getSecond() {

        return second;
    }

    public String getDetails() {
        return "Flight from " + first.getDeparture() + " to "
                + second.getArrival() + " with stop at " + first.getArrival() +
                " costs " + getJourneyPrice() + ". Flight time: " + getJourneyTimeInString();
    }

    public int getJourneyPrice(){
        return first.getPrice() + second.getPrice();
    }

    public int getJourneyTimeInMinutes(){
        return first.getFlightTimeInMinutes() + second.getFlightTimeInMinutes();
    }

    public String getJourneyTimeInString(){
        int journeyTimeInMinutes = getJourneyTimeInMinutes();
        int h = journeyTimeInMinutes / 60;
        int min = journeyTimeInMinutes % 60;
        String hours = Integer.toString(h);
        if(hours.length() == 1){
            hours = "0" + hours;
        }
        String minutes = Integer.toString(min);
        if(minutes.length() == 1){
            minutes = "0" + minutes;
        }

        return hours + ":" + minutes;
    }

    @Override
    public String toString() {
        return "Flight from " + first.getDeparture() + " to "
                + second.getArrival() + " with stop at " + first.getArrival() +
                " costs " + (first.getPrice() + second.getPrice());
    }
}
