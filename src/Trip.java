public class Trip {
    int numberofStops;
    String fromwhere;
    String towhere;
    int howmuchitcost;
    String vehicle;
    int capacity;
    int lisencesplate;

    public Trip(int numberofStops, String fromwhere, String towhere, int howmuchitcost, String vehicle, int capacity, int lisencesplate) {
        this.numberofStops = numberofStops;
        this.fromwhere = fromwhere;
        this.towhere = towhere;
        this.howmuchitcost = howmuchitcost;
        this.vehicle = vehicle;
        this.capacity = capacity;
        this.lisencesplate = lisencesplate;
    }

    public Trip(int stops, String from, String to, int cost, String vehicle, int licensePlate) {
    }

    public Trip(int stops, String from, String to, int cost, String vehicle, int licensePlate, String tripName) {
    }

    public Trip(int stops, String from, String to, int cost, int capacity, int licensePlate) {
    }

    public int getNumberofStops() {
        return numberofStops;
    }

    public void setNumberofStops(int numberofStops) {
        this.numberofStops = numberofStops;
    }

    public String getFromwhere() {
        return fromwhere;
    }

    public void setFromwhere(String fromwhere) {
        this.fromwhere = fromwhere;
    }

    public String getTowhere() {
        return towhere;
    }

    public void setTowhere(String towhere) {
        this.towhere = towhere;
    }

    public int getHowmuchitcost() {
        return howmuchitcost;
    }

    public void setHowmuchitcost(int howmuchitcost) {
        this.howmuchitcost = howmuchitcost;
    }

    public String getVehcle() {
        return vehicle;
    }

    public void setVehcle(String vehcle) {
        this.vehicle = vehcle;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getLisencesplate() {
        return lisencesplate;
    }

    public void setLisencesplate(int lisencesplate) {
        this.lisencesplate = lisencesplate;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "numberofStops=" + numberofStops +
                ", fromwhere='" + fromwhere + '\'' +
                ", towhere='" + towhere + '\'' +
                ", howmuchitcost=" + howmuchitcost +
                ", vehicle='" + vehicle + '\'' +
                ", capacity=" + capacity +
                ", lisencesplate=" + lisencesplate +
                '}';
    }
}
