import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        MainGUIFINALPROJECT();
    }
    private static void MainGUIFINALPROJECT() {
        JFrame frame = new JFrame("Login/Signup");
        frame.setSize(1000,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        frame.add(panel);


        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.green);
        JLabel titleLabel = new JLabel("Login/Signup Form");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        topPanel.add(titleLabel);
        panel.add(topPanel, BorderLayout.NORTH);


        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel optionLabel = new JLabel("Choose an option:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        centerPanel.add(optionLabel, gbc);

        String[] options = {"Login", "Signup"};
        JComboBox<String> optionDropdown = new JComboBox<>(options);
        gbc.gridx = 1;
        gbc.gridy = 0;
        centerPanel.add(optionDropdown, gbc);

        JLabel emailLabel = new JLabel("Email:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        centerPanel.add(emailLabel, gbc);

        JTextField emailText = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        centerPanel.add(emailText, gbc);

        JLabel passwordLabel = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        centerPanel.add(passwordLabel, gbc);

        JPasswordField passwordText = new JPasswordField(20);
        gbc.gridx = 1; 
        gbc.gridy = 2;
        centerPanel.add(passwordText, gbc);

        JButton submitButton = new JButton("Submit");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        centerPanel.add(submitButton, gbc);

        JLabel statusLabel = new JLabel("");
        statusLabel.setForeground(Color.RED);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        centerPanel.add(statusLabel, gbc);

        panel.add(centerPanel, BorderLayout.CENTER);

        frame.setVisible(true);

        submitButton.addActionListener(e -> {
            int selectedIndex = optionDropdown.getSelectedIndex();
            String email = emailText.getText();
            String password = new String(passwordText.getPassword());

            if (selectedIndex == 0) {
                // Login option selected
                if (User.login(email, password)) {
                    statusLabel.setText("Login successful");
                    String[] roleOptions = {"Passenger", "Manager", "Driver"};
                    int roleChoice = JOptionPane.showOptionDialog(frame, "Choose your role:", "Role Selection", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, roleOptions, roleOptions[0]);

                    switch (roleChoice) {
                        case 0:
                            // Open Passenger GUI
                            PassengerGUI passengerGUI = new PassengerGUI();
                            break;
                        case 1:
                            // Open Manager GUI
                            ManagerGUI managerGUI = new ManagerGUI();
                            break;
                        case 2:
                            // Open Driver GUI
                            DriverGUI driverGUI = new DriverGUI();
                            break;
                        default:
                            // Handle the default case
                            break;
                    }
                } else {
                    statusLabel.setText("Login failed");
                }
            } else if (selectedIndex == 1) {
                // Signup option selected
                String name = JOptionPane.showInputDialog(frame, "Enter name:");

                if (name != null && !name.isEmpty()) {
                    User.signup(name, email, password);
                    statusLabel.setText("Signup successful");
                } else {
                    statusLabel.setText("Signup cancelled or invalid input");
                }
            }
        });
    }
}