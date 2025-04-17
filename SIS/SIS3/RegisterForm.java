import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class RegisterForm extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton registerButton;
    private JButton backButton;

    public RegisterForm() {
        setTitle("Register");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // center the window
        setLayout(new GridLayout(4, 2));

        add(new JLabel("Username:"));
        usernameField = new JTextField();
        add(usernameField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        registerButton = new JButton("Register");
        backButton = new JButton("Back to Login");

        add(registerButton);
        add(backButton);

        // Register button action
        registerButton.addActionListener(e -> registerUser());

        // Back button action
        backButton.addActionListener(e -> {
            dispose(); // Close current window
            new LoginForm(); // Open login form
        });

        setVisible(true);
    }

    private void registerUser() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            return;
        }

        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO users (username, password) VALUES (?, ?)");
            ps.setString(1, username);
            ps.setString(2, password); // TODO: hash password in production
            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Registration successful! Please log in.");
            dispose();
            new LoginForm();

        } catch (SQLException e) {
            if (e.getMessage().contains("duplicate key")) {
                JOptionPane.showMessageDialog(this, "Username already exists.");
            } else {
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            }
        }
    }
}
