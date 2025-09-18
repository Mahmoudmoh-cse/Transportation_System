import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class ManagerGUI extends JFrame {
    private ArrayList<Trip> trips;

    public ManagerGUI() {
        super("Manager");
        trips = new ArrayList<>();

        // Create GUI components
        JLabel titleLabel = new JLabel("Add Trip");
        JLabel stopsLabel = new JLabel("Number of Stops:");
        JTextField stopsField = new JTextField();
        JLabel fromLabel = new JLabel("From Where:");
        JTextField fromField = new JTextField();
        JLabel toLabel = new JLabel("To Where:");
        JTextField toField = new JTextField();
        JLabel costLabel = new JLabel("Cost:");
        JTextField costField = new JTextField();
        JLabel capacityLabel = new JLabel("Capacity:");
        JTextField capacityField = new JTextField();
        JLabel licenseLabel = new JLabel("License Plate:");
        JTextField licenseField = new JTextField();
        JButton addTripButton = new JButton("Add Trip");
        JButton removeLastTripButton = new JButton("cancel Trip");

        // Layout GUI components
        setLayout(new GridLayout(10, 2));
        add(titleLabel);
        add(new JLabel());
        add(stopsLabel);
        add(stopsField);
        add(fromLabel);
        add(fromField);
        add(toLabel);
        add(toField);
        add(costLabel);
        add(costField);
        add(capacityLabel);
        add(capacityField);
        add(licenseLabel);
        add(licenseField);
        add(addTripButton);
        add(removeLastTripButton);

        // Add ActionListener for addTripButton
        addTripButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int stops = Integer.parseInt(stopsField.getText());
                String from = fromField.getText();
                String to = toField.getText();
                int cost = Integer.parseInt(costField.getText());
                int capacity = Integer.parseInt(capacityField.getText());
                int licensePlate = Integer.parseInt(licenseField.getText());

                // Create
                Trip trip = new Trip(stops, from, to, cost, capacity, licensePlate);
                trips.add(trip);

                // Save trip to file
                try {
                    FileWriter fileWriter = new FileWriter("seeDriver", true);
                    fileWriter.write(trip.toString() + "\n");
                    fileWriter.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                JOptionPane.showMessageDialog(null, "Trip added successfully!");
            }
        });

        // Add ActionListener for removeLastTripButton
        removeLastTripButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelTrip();
            }
        });

        // Set frame size
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Method to remove the last trip signed in the "seeDriver" file
    private void cancelTrip() {
        // Check if there are trips in the list
        if (!trips.isEmpty()) {
            // Remove the last trip from the list
            Trip removedTrip = trips.remove(trips.size() - 1);

            // Remove the last tip from the "seeDriver" filesss
            try {

                ArrayList<String> lines = new ArrayList<>();
                BufferedReader reader = new BufferedReader(new FileReader("seeDriver"));
                String line;
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
                reader.close();

                // Remove the last line (which corresponds to the removed trip)
                if (!lines.isEmpty()) {
                    lines.remove(lines.size() - 1);

                    // Write the updated content back to the file
                    FileWriter writer = new FileWriter("seeDriver");
                    for (String newLine : lines) {
                        writer.write(newLine + "\n");
                    }
                    writer.close();
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            }

            JOptionPane.showMessageDialog(null, "trip removed successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "No trips to remove!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ManagerGUI();
            }
        });
    }
}
