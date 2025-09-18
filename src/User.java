import java.io.*;

public class User {
    protected String name;
    protected String email;
    protected String password;
    protected String role;

    public User(String name, String email, String password, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User() {
    }




    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public static boolean login(String email, String password) {
        try (BufferedReader br = new BufferedReader(new FileReader("seeDriver"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 3 && parts[1].equals(email) && parts[2].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {

            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {

            System.err.println("Error: Malformed data in file 'seeDriver'.");
            e.printStackTrace();
        }
        return false;
    }

    public static boolean signup(String name, String email, String password) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("seeDriver", true))) {
            writer.println(name + "," + email + "," + password);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }}

    public String toString() {
        return "User{name='" + this.name + "', email='" + this.email + "', password='" + this.password + "', role='" + this.role + "'}";
    }
}