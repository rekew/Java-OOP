package SIS.SIS2.Login;

import java.awt.*;
import javax.swing.*;

public class WelcomePage {

	JFrame frame = new JFrame();
	JLabel welcomeLabel = new JLabel("Hello!");
	
	WelcomePage(String userID, String password){
		
		welcomeLabel.setBounds(0,0,400,35);
		welcomeLabel.setFont(new Font(null,Font.PLAIN, 30));
		welcomeLabel.setText("Hello "+userID + password);
		
		
		frame.add(welcomeLabel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setLayout(null);
		frame.setVisible(true);
	}
}