package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.*;


public class ButtonListenerEx extends JFrame{

	final int WIDTH = 700;
	final int HEIGHT = 300;
	
	JPanel mainPanel;
	
	// Buttons
	JButton b1, b2, b3;
	
	// JTextField
	JTextField name;
	
	// submit button
	JButton submit;
	
	public ButtonListenerEx()
	{
		
		setSize(WIDTH, HEIGHT);
		setTitle("Test for JFrames");
		
		this.setIconImage(new ImageIcon(getClass().getResource("dogboneicon.png")).getImage());
		
		mainPanel = new JPanel();
		add(mainPanel);
		mainPanel.setBackground(Color.ORANGE);
		
		
		name = new JTextField();
		name.setText("name?");
		
		JLabel title = new JLabel("Click buttons to change colors: ");
		b1 = new JButton("Blue");
		b2 = new JButton("Red");
		b3 = new JButton("Pink");
		submit = new JButton("Submit");
		
		ColorChangeListener act = new ColorChangeListener();
		
		name.addActionListener(act);
		b1.addActionListener(act);
		b2.addActionListener(act);
		b3.addActionListener(act);
		
		// Anonymous class
		submit.addActionListener(   new ActionListener() 
									{ 
										public void actionPerformed(ActionEvent e) 
										{ 	
											mainPanel.add(new JLabel("Done"));
											mainPanel.validate();
										}
									}
								);
		
		mainPanel.add(name);
		mainPanel.add(title);
		mainPanel.add(b1);
		mainPanel.add(b2);
		mainPanel.add(b3);
		mainPanel.add(submit);
		
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ButtonListenerEx();
		
	}
	// private nested class
	private class ColorChangeListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{ 	
			String setname = name.getText();		// get data from the text field
			
			mainPanel.add(new JLabel(setname + " color choices"));
			mainPanel.validate();
			
			if (e.getSource() == b1)
				mainPanel.setBackground(Color.BLUE);
			if (e.getSource() == b2)
				mainPanel.setBackground(Color.RED);
			if (e.getSource() == b3)
				mainPanel.setBackground(Color.PINK);
			
		
			
			
		}
	}

}
