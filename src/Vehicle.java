public class Vehicle {
    int capacety,lisencesplate;
    String type;

    public Vehicle(int capacety, int lisencesplate, String type) {
        this.capacety = capacety;
        this.lisencesplate = lisencesplate;
        this.type = type;
    }

    public int getCapacety() {
        return capacety;
    }

    public void setCapacety(int capacety) {
        this.capacety = capacety;
    }

    public int getLisencesplate() {
        return lisencesplate;
    }
    public void setLisencesplate(int lisencesplate) {
        this.lisencesplate = lisencesplate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "capacety=" + capacety +
                ", lisencesplate=" + lisencesplate +
                ", type='" + type + '\'' +
                '}';
    }
}
