package interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import domainLayer.Controller;
import domainLayer.Validation;

public class LoginInterface {

    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JCheckBox showPasswordCheckBox;
    private JButton loginButton;
    private JLabel errorMessageLabel;

    public LoginInterface() {
        // Create JFrame
        frame = new JFrame("Customized Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Customizing UIManager properties
        customizeUI();

        // Initialize UI components
        initUIComponents();

        // Set up UI layout
        setupLayout();

        // Pack and center the frame on the screen
        frame.pack();
        frame.setLocationRelativeTo(null);

        // Set frame visibility
        frame.setVisible(true);
    }

    private void customizeUI() {
        UIManager.put("TextField.foreground", Color.BLACK);
        UIManager.put("Button.background", Color.BITMASK);
        UIManager.put("Button.foreground", Color.BLACK);
    }

    private void initUIComponents() {
        // Create JLabels
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");

        // Create JTextFields
        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        showPasswordCheckBox = new JCheckBox("Show Password");

        // Create JButton
        loginButton = new JButton("Login");
        loginButton.setBorderPainted(false);

        // Create JLabel for error message
        errorMessageLabel = new JLabel("Username and password are required");
        errorMessageLabel.setForeground(Color.RED);

        // Add ActionListener to the loginButton
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Notify the controller class about the login button click
                // Validation.handleLogin(usernameField.getText(), passwordField.getPassword());
                Controller.handleShowPassword(true);
            }
        });

        // Add ItemListener to showPasswordCheckBox
        showPasswordCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Notify the controller class about the show password checkbox state change
                Controller.handleShowPassword(showPasswordCheckBox.isSelected());

                // Update the password field text based on the show password checkbox
                updatePasswordFieldText(showPasswordCheckBox.isSelected());
            }
        });
    }

    private void setupLayout() {
        // Create JPanel for login form
        JPanel loginFormPanel = new JPanel();
        loginFormPanel.setLayout(new GridBagLayout());
        loginFormPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        // Create GridBagConstraints for login form
        GridBagConstraints gbcLoginForm = new GridBagConstraints();

        // Set constraints for usernameLabel
        gbcLoginForm.gridx = 0;
        gbcLoginForm.gridy = 0;
        gbcLoginForm.insets = new Insets(7, 5, 7, 5);
        loginFormPanel.add(new JLabel("Username:"), gbcLoginForm);

        // Set constraints for usernameField
        gbcLoginForm.gridx = 1;
        loginFormPanel.add(usernameField, gbcLoginForm);

        // Set constraints for passwordLabel
        gbcLoginForm.gridx = 0;
        gbcLoginForm.gridy = 1;
        loginFormPanel.add(new JLabel("Password:"), gbcLoginForm);

        // Set constraints for passwordField
        gbcLoginForm.gridx = 1;
        loginFormPanel.add(passwordField, gbcLoginForm);

        // Set constraints for showPasswordCheckBox
        gbcLoginForm.gridx = 2;
        loginFormPanel.add(showPasswordCheckBox, gbcLoginForm);

        // Set constraints for loginButton
        gbcLoginForm.gridx = 0;
        gbcLoginForm.gridy = 2;
        gbcLoginForm.gridwidth = 3; // Span across three columns
        loginFormPanel.add(loginButton, gbcLoginForm);

        // Create JPanel for alert message
        JPanel alertPanel = new JPanel();
        alertPanel.setLayout(new GridBagLayout());
        alertPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        // Create GridBagConstraints for alert message
        GridBagConstraints gbcAlert = new GridBagConstraints();

        // Set constraints for errorMessageLabel
        gbcAlert.gridx = 0;
        gbcAlert.gridy = 0;
        alertPanel.add(errorMessageLabel, gbcAlert);

        // Create a surrounding panel
        JPanel surroundingPanel = new JPanel();
        surroundingPanel.setLayout(new BoxLayout(surroundingPanel, BoxLayout.Y_AXIS));
        surroundingPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Set maximum size for login form and alert panels
        Dimension maxPanelSize = new Dimension(400, 160);
        loginFormPanel.setMaximumSize(maxPanelSize);
        alertPanel.setMaximumSize(maxPanelSize);

        // Add the login form panel to the surrounding panel
        surroundingPanel.add(loginFormPanel);

        // Add an explicit line (using JLabel with border) to the surrounding panel
        JLabel lineLabel = new JLabel();
        lineLabel.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.LIGHT_GRAY));
        surroundingPanel.add(lineLabel);

        // Add the alert panel to the surrounding panel
        surroundingPanel.add(alertPanel);

        // Add the surrounding panel to the frame content pane
        frame.getContentPane().add(surroundingPanel);
    }

    // Update the password field text based on the show password checkbox
    public void updatePasswordFieldText(boolean showPassword) {
        if (showPassword) {
            // If selected, show the actual text
            passwordField.setEchoChar((char) 0);
        } else {
            // If not selected, hide the password
            passwordField.setEchoChar('*');
        }
    }

    public void showError(String errorMessage) {
        errorMessageLabel.setText(errorMessage);
        usernameField.setText("");
        passwordField.setText("");
    }

    public void showSuccessMessage(String message) {
        JOptionPane.showMessageDialog(frame, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        new LoginInterface();
    }
}
