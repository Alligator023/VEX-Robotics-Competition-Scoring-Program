package GUI;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.FlowLayout;

public class JFrameExample extends JFrame{

	final int WIDTH = 500;
	final int HEIGHT = 300;
	
	// all input fields
	JTextField fn = new JTextField("First Name", 30);
	JTextField ln = new JTextField("Last Name", 30);
	JTextField em = new JTextField("email address", 40);
	JTextField pw = new JTextField("password", 30);
	JTextField cpw = new JTextField("confirm password", 30);
	
	// radio buttons and button group -- Gender
	JRadioButton maleRB, femaleRB;
	ButtonGroup genderBG;
	
	// checkbox
	JCheckBox specialsNotifyCB;
	
	// buttons
	JButton b1 = new JButton("Submit");
	
	public JFrameExample() {
		setSize(WIDTH, HEIGHT);
		setTitle("Project or Company name goes here");
		
		this.setIconImage(new ImageIcon("dogboneicon.png").getImage());
		
		JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 20)); 
		
	//	mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 20));
		this.add(mainPanel);
		
		fn = new JTextField("First Name", 30);
		ln = new JTextField("Last Name", 30);
		em = new JTextField("email address", 40);
		pw = new JTextField("password", 30);
		cpw = new JTextField("confirm password", 30);
		
		// Gender choice (radio buttons)
		maleRB = new JRadioButton("male");
		femaleRB = new JRadioButton("female");
		genderBG = new ButtonGroup();
		genderBG.add(maleRB);
		genderBG.add(femaleRB);
		JPanel genderPanel = new JPanel();
		genderPanel.add(maleRB);
		genderPanel.add(femaleRB);
		
		// add all components
		mainPanel.add(fn);
		mainPanel.add(ln);
		mainPanel.add(em);
		mainPanel.add(pw);
		mainPanel.add(cpw);
		mainPanel.add(genderPanel);
		mainPanel.add(b1);
			
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		
		new JFrameExample();
		
	}

}
