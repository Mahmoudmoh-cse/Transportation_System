import java.io.*;
import java.util.ArrayList;

public class Manager extends Employee{
    protected String tripname;
   static ArrayList<Trip> trips;

    ArrayList<Vehicle>vehicles;
    ArrayList<Driver>drivers;

    public Manager(String name, String email, String password, String role, ArrayList<Trip> trips, ArrayList<Vehicle> vehicles, ArrayList<Driver> drivers) {
        super(name, email, password, role);
        this.trips = new ArrayList<>();
        this.vehicles = new ArrayList<>();
        this.drivers = new ArrayList<>();
    }

    public Manager(String tripname,ArrayList<Trip> trips, ArrayList<Vehicle> vehicles, ArrayList<Driver> drivers) {
        this.tripname=tripname;
        this.trips = new ArrayList<>();
        this.vehicles = new ArrayList<>();
        this.drivers = new ArrayList<>();
    }

    public Manager(String name, String email, String password, String role) {
        super(name, email, password, role);
    }

    public Manager() {
    }


    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public ArrayList<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(ArrayList<Driver> drivers) {
        this.drivers = drivers;
    }

    public static ArrayList<Trip> getTrips() {
        return trips;
    }

    public static void setTrips(ArrayList<Trip> trips) {
        Manager.trips = trips;
    }

    public void addtrip(Trip trip){
        trips.add(trip);
        String info= String.valueOf(trip);
        try {
            FileWriter fileWriter=new FileWriter("seeDriver");
            fileWriter.write(info);
            fileWriter.close();
        }catch (IOException E){
            E.printStackTrace();
        }
    }public void canceltrip(Trip trip){
        trips.remove(trip);
        String filePath = "seeDriver";
        String stringToDelete = "seeDriver";

        try {
            File file = new File("seeDriver");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {

                if (!line.contains(stringToDelete)) {
                    stringBuilder.append(line).append("\n");
                }
            }
           reader.close();
    } catch (IOException e) {
            throw new RuntimeException(e);
        }} public boolean searchtrip(Trip trip){
         return trips.contains(trip);
    }
    public void addvehicle(Vehicle vehicle){
        vehicles.add(vehicle);
    }public void removevehicle(Vehicle vehicle){
        vehicles.remove(vehicle);
    }public boolean searchvehicle(Vehicle vehicle){
        return vehicles.contains(vehicle);
    }
    public void adddriver(Driver driver){
        drivers.add(driver);
    }public void removeddriver(Driver driver){
        drivers.remove(driver);
    }public boolean searchdriver(Driver driver){
       return drivers.contains(driver);
    }
    public void conductreport(){
        for (Trip trip:trips) {
            System.out.println(trip);
        }
        for (Vehicle vehicle:vehicles) {
            System.out.println(vehicle);
        }
        for (Driver driver:drivers) {
            System.out.println(driver);
        }
    }
}