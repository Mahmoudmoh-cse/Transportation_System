import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class PassengerGUI extends JFrame {
    private String type;
    private String vehicle;
    private String selectedTrip;
    private String tripLocation;

    private int seatsRemaining = 4; // Number of seats remaining
    private JButton selectButton; // Declare selectButton here for access in ActionListener

    public PassengerGUI() {
        setTitle("Passenger GUI");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ArrayList<String> tripNames = readTripNamesFromFile("seeDriver");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2));

        JLabel typeLabel = new JLabel("Choose ticket type (one way || round trip):");
        JComboBox<String> typeComboBox = new JComboBox<>(new String[]{"One way", "Round trip"});
        panel.add(typeLabel);
        panel.add(typeComboBox);

        JLabel vehicleLabel = new JLabel("Choose vehicle:");
        JComboBox<String> vehicleComboBox = new JComboBox<>(new String[]{"Bus", "Minibus", "Limousine"});
        panel.add(vehicleLabel);
        panel.add(vehicleComboBox);

        JLabel tripLabel = new JLabel("Trips to select from:");
        JComboBox<String> tripComboBox = new JComboBox<>(tripNames.toArray(new String[0])); // Populate combo box with trip names
        panel.add(tripLabel);
        panel.add(tripComboBox);

        JLabel locationLabel = new JLabel("Select trip location:");
        JComboBox<String> locationComboBox = new JComboBox<>(new String[]{"Internal", "External"});
        panel.add(locationLabel);
        panel.add(locationComboBox);

        JLabel seatsLabel = new JLabel("Number of seats remaining: " + seatsRemaining);
        panel.add(seatsLabel);

        selectButton = new JButton("Select");
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (seatsRemaining > 0) {
                    type = (String) typeComboBox.getSelectedItem();
                    vehicle = (String) vehicleComboBox.getSelectedItem();
                    selectedTrip = (String) tripComboBox.getSelectedItem();
                    tripLocation = (String) locationComboBox.getSelectedItem();

                    String reservationDetails = reservations();
                    JOptionPane.showMessageDialog(null, "Reservation details: " + reservationDetails);

                    // Update seats remaining
                    seatsRemaining--;
                    seatsLabel.setText("Number of seats remaining: " + seatsRemaining);

                    // Save passenger details to a file
                    try (FileWriter writer = new FileWriter("passenger_profiler", true);
                         BufferedWriter bufferedWriter = new BufferedWriter(writer);
                         PrintWriter out = new PrintWriter(bufferedWriter)) {

                        out.println("Type: " + type);
                        out.println("Vehicle: " + vehicle);
                        out.println("Selected Trip: " + selectedTrip);
                        out.println("Trip Location: " + tripLocation);
                        out.println();

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                } else {   //lw zero y2fl elzrar
                    selectButton.setEnabled(false); // Disable the button
                    JOptionPane.showMessageDialog(null, "All seats are taken!");

                }
            }
        });
        panel.add(selectButton);

        add(panel);
        setVisible(true);
    }

    public String reservations() {
        return type + "," + vehicle + "," + selectedTrip + "," + tripLocation;
    }
    // accsess files
    public ArrayList<String> readTripNamesFromFile(String filename) {
        ArrayList<String> tripNames = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {

                tripNames.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tripNames;
    }

    public static void main(String[] args) {
        new PassengerGUI();
    }
}