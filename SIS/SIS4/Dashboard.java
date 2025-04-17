import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {
    private JButton editUserButton;
    private JButton logoutButton;

    public Dashboard(String loggedInUsername) {
        setTitle("Welcome, " + loggedInUsername);
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel welcomeLabel = new JLabel("Welcome, " + loggedInUsername + "!");
        editUserButton = new JButton("Edit Users");
        logoutButton = new JButton("Logout");

        add(welcomeLabel);
        add(editUserButton);
        add(logoutButton);

        editUserButton.addActionListener(e -> {
            new EditUserForm(this);  // pass reference to go back
            setVisible(false); // hide dashboard while editing
        });

        logoutButton.addActionListener(e -> {
            dispose();
            new LoginForm();
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
