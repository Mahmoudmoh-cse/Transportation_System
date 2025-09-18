import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver extends Employee{
    public Driver(String name, String email, String password, String role) {
        super(name, email, password, role);
    }

    public Driver() {
    }

    public String seetrips(){
        String data=null;
        try {
            File file = new File("seeDriver");
            Scanner read = new Scanner(file);

            while (read.hasNextLine()) {
                 data = read.nextLine();

            }
         read.close();
    } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
   return data;
    }
}