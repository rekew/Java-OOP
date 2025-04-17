import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class EditUserForm extends JFrame {
    private JComboBox<String> userDropdown;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton updateButton;
    private JButton backButton;
    private Dashboard dashboard;  // reference to main menu

    public EditUserForm(Dashboard dashboardRef) {
        this.dashboard = dashboardRef;

        setTitle("Edit User");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        add(new JLabel("Select User:"));
        userDropdown = new JComboBox<>();
        add(userDropdown);

        add(new JLabel("New Username:"));
        usernameField = new JTextField();
        add(usernameField);

        add(new JLabel("New Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        updateButton = new JButton("Update");
        backButton = new JButton("Back to Dashboard");

        add(updateButton);
        add(backButton);

        loadUsers();

        userDropdown.addActionListener(e ->
            loadUserDetails((String) userDropdown.getSelectedItem()));

        updateButton.addActionListener(e -> updateUser());

        backButton.addActionListener(e -> {
            dispose();
            dashboard.setVisible(true);
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void loadUsers() {
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT username FROM users")) {

            while (rs.next()) {
                userDropdown.addItem(rs.getString("username"));
            }
            if (userDropdown.getItemCount() > 0) {
                userDropdown.setSelectedIndex(0);
                loadUserDetails((String) userDropdown.getSelectedItem());
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading users: " + e.getMessage());
        }
    }

    private void loadUserDetails(String username) {
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE username = ?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                usernameField.setText(rs.getString("username"));
                passwordField.setText(rs.getString("password"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading user details: " + e.getMessage());
        }
    }

    private void updateUser() {
        String selectedUsername = (String) userDropdown.getSelectedItem();
        String newUsername = usernameField.getText();
        String newPassword = new String(passwordField.getPassword());

        if (newUsername.isEmpty() || newPassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Fields cannot be empty.");
            return;
        }

        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                "UPDATE users SET username = ?, password = ? WHERE username = ?");
            ps.setString(1, newUsername);
            ps.setString(2, newPassword);
            ps.setString(3, selectedUsername);

            int updated = ps.executeUpdate();
            if (updated > 0) {
                JOptionPane.showMessageDialog(this, "User updated successfully.");
                userDropdown.removeAllItems();
                loadUsers();
            } else {
                JOptionPane.showMessageDialog(this, "Update failed.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error updating user: " + e.getMessage());
        }
    }
}
