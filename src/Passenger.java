
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Iterator;
import java.util.Scanner;

public class Passenger extends User {
    static String type = null;
    static String Veichle = null;
    static String selectedTrip = null;
    static String type1=null;

    public Passenger(String name, String email, String password, String role) {
        super(name, email, password, role);
    }

    public Passenger() {
    }

    public void selecttickettype() {
        Scanner console = new Scanner(System.in);
        System.out.println("Choose ticket type (one way || round trip)");
        type = console.next();
    }

    public void vehicleType() {
        System.out.println("Choose veichle");
        Scanner console = new Scanner(System.in);
        Veichle = console.next();
    }

    public String SelectTrip() {
        System.out.println("trips to select from: ");
        Iterator var1 = Manager.trips.iterator();

        while(var1.hasNext()) {
            Trip trip = (Trip)var1.next();
            System.out.println(trip);
            System.out.println();
        }

        Scanner console = new Scanner(System.in);
        selectedTrip = console.next();
        return selectedTrip;
    }
    public String selectTrip() {
        Scanner console = new Scanner(System.in);
        System.out.println("Choose ticket Internal or External");
        type1 = console.next();
        return type1;
    }

    public String reservations() {

        return type + "," + Veichle + "," +","+type1;
    }



}
