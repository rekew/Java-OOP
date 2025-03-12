package SIS.SIS1.calculator;
import javax.swing.*; //for the graphical interface
import java.awt.*; //AWT is basical package where it has a lot of classes for handling graphical operations
import java.awt.event.*; //handles events like clicking button and etc

public class Calculator implements ActionListener{ //creating class which implements ActionListener, so it implements events


    JFrame frame; //main window of app
    JTextField textField; //textarea to input something
    JButton[] numberButtons = new JButton[10]; //array of buttons (numbers)
    JButton[] functionButtons = new JButton[9]; //array of buttons (functions)
    JButton addButton, subButton, mulButton, divButton; //buttons of opeartions
    JButton decButton, equButton, delButton, clrButton, negButton; //buttons of basical functions
    JPanel panel; //panel where we handle our components

    Font myFont = new Font("Ink free", Font.BOLD,30); //creating font with INK FREE font and with bold of 30px font

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Calculator (){
        frame = new JFrame("Calculator"); //the title of window (app)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //setting default close operation. It means when user presses X on window top right side, then it closes the app
        frame.setSize(700, 550); //window area
        frame.setLayout(null); //we are disabling for frame to automatically put components, so we are able to put our components by our chosed coordinates
		frame.getContentPane().setBackground(Color.BLACK);

        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50); 
        textField.setFont(myFont);
        textField.setEditable(false); //making so user can't type anything

        addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("Del");
		clrButton = new JButton("Clr");
		clrButton.setBackground(Color.ORANGE);
		negButton = new JButton("(-)");

		/*
		addButton.setBackground(Color.ORANGE);
		divButton.setBackground(Color.ORANGE);
		mulButton.setBackground(Color.ORANGE);
		subButton.setBackground(Color.ORANGE);
		 */

        functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;
		functionButtons[8] = negButton;

        for(int i =0;i<9;i++) {

			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
			functionButtons[i].setBackground(Color.ORANGE);
		}

        for(int i =0;i<10;i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
		}

        negButton.setBounds(50,430,100,50);
		delButton.setBounds(150,430,100,50);
		clrButton.setBounds(250,430,100,50);

        panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4,4,10,10));

        panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equButton);
		panel.add(divButton);
		
		frame.add(panel);
		frame.add(negButton);
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(textField);


        frame.add(textField);
        frame.setVisible(true); //making the window itself visible

    }   
    public static void main(String[] args){
        Calculator calc = new Calculator();
    }

    @Override 
    public void actionPerformed(ActionEvent e){
        for(int i=0;i<10;i++) {
			if(e.getSource() == numberButtons[i]) {//e.getSource is defining which elements has been used from user
				textField.setText(textField.getText().concat(String.valueOf(i)));
			}
		}
        if(e.getSource()==decButton) { 
			textField.setText(textField.getText().concat("."));
		}
		if(e.getSource()==addButton) {
			num1 = Double.parseDouble(textField.getText());
			operator ='+';
			textField.setText("");
		}
		if(e.getSource()==subButton) {
			num1 = Double.parseDouble(textField.getText());
			operator ='-';
			textField.setText("");
		}
		if(e.getSource()==mulButton) {
			num1 = Double.parseDouble(textField.getText());
			operator ='*';
			textField.setText("");
		}
		if(e.getSource()==divButton) {
			num1 = Double.parseDouble(textField.getText());
			operator ='/';
			textField.setText("");
		}
		if(e.getSource()==equButton) {
			num2=Double.parseDouble(textField.getText());
			
			switch(operator) {
			case'+':
				result=num1+num2;
				break;
			case'-':
				result=num1-num2;
				break;
			case'*':
				result=num1*num2;
				break;
			case'/':
				result=num1/num2;
				break;
			}
			textField.setText(String.valueOf(result));
			num1=result;
		}
		if(e.getSource()==clrButton) {
			textField.setText("");
		}
		if(e.getSource()==delButton) {
			String string = textField.getText();
			textField.setText("");
			for(int i=0;i<string.length()-1;i++) {
				textField.setText(textField.getText()+string.charAt(i));
			}
		}
		if(e.getSource()==negButton) {
			double temp = Double.parseDouble(textField.getText());
			temp*=-1;
			textField.setText(String.valueOf(temp));
		}
    }
}
