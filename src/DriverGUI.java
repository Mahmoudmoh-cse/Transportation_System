import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DriverGUI {
    private JTextArea tripDetailsTextArea;
    private JComboBox<String> tripComboBox;
    private ArrayList<String> tripList;



    public DriverGUI() {
        JFrame frame = new JFrame("Driver Details");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        placeDriverComponents(panel);
        loadTripsFromFile(); // Load trips when GUI is created
        frame.setVisible(true);
    }

    private void placeDriverComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel titleLabel = new JLabel("Enter Driver Details");
        titleLabel.setBounds(100, 20, 180, 25);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(titleLabel);

        JLabel nameLabel = new JLabel("Car color:");
        nameLabel.setBounds(50, 60, 80, 25);
        panel.add(nameLabel);

        JTextField nameText = new JTextField(20);
        nameText.setBounds(150, 60, 160, 25);
        panel.add(nameText);

        JLabel emailLabel = new JLabel("Car model:");
        emailLabel.setBounds(50, 100, 80, 25);
        panel.add(emailLabel);

        JTextField emailText = new JTextField(20);
        emailText.setBounds(150, 100, 160, 25);
        panel.add(emailText);

        JLabel passwordLabel = new JLabel("phone number:");
        passwordLabel.setBounds(50, 140, 100, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(150, 140, 160, 25);
        panel.add(passwordText);

        JLabel tripLabel = new JLabel("Select Trip:");
        tripLabel.setBounds(50, 180, 80, 25);
        panel.add(tripLabel);

        tripComboBox = new JComboBox<>();
        tripComboBox.setBounds(150, 180, 160, 25);
        panel.add(tripComboBox);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(150, 220, 100, 30);
        panel.add(submitButton);

        JLabel statusLabel = new JLabel("");
        statusLabel.setBounds(50, 260, 300, 25);
        panel.add(statusLabel);

        tripDetailsTextArea = new JTextArea();
        tripDetailsTextArea.setEditable(false);
        tripDetailsTextArea.setBounds(50, 300, 300, 100);
        panel.add(tripDetailsTextArea);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameText.getText();
                String email = emailText.getText();
                String password = new String(passwordText.getPassword());
                String selectedTrip = (String) tripComboBox.getSelectedItem();
                Driver driver = new Driver(name, email, password, "Driver");
                statusLabel.setText("Driver details submitted successfully");

                try {
                    FileWriter fileWriter = new FileWriter("driver_details.txt", true);
                    fileWriter.write(driver.toString() + "\n");
                    fileWriter.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                //    displayTripDetailsFromFile();
            }
        });
    }

  /*  private void displayTripDetailsFromFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("driver_details"));
            StringBuilder tripDetails = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                tripDetails.append(line).append("\n");
            }
            reader.close();
            tripDetailsTextArea.setText(tripDetails.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }*/

    private void loadTripsFromFile() {
        tripList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("seeDriver"));
            String line;
            while ((line = reader.readLine()) != null) {
                tripList.add(line);
            }
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        updateTripComboBox();
    }

    private void updateTripComboBox() {
        tripComboBox.removeAllItems();
        for (String trip : tripList) {
            tripComboBox.addItem(trip);
        }
    }

    public static void main(String[] args) {
        DriverGUI driverGUI = new DriverGUI();
    }
}
