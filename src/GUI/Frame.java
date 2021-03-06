package GUI;
import SpinUp.SPINUP_Match;
import TippingPoint.TIPPINGPOINT_Match;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame {
    JFrame frame;
    public String submitText = "";
    public boolean matchDone;

    public JTextField input = new JTextField("TestingTestingTestingTesting", 50);
    JButton submitButton = new JButton("Submit");
    public JPanel inputPanel = new JPanel();
    JPanel redScorePanel = new JPanel();
    public JTextField redScore = new JTextField("", 3);
    JPanel blueScorePanel = new JPanel();
    public JTextField blueScore = new JTextField("", 3);
    public Frame(String name, String s) {
        matchDone = false;
        frame = new JFrame(name);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(input);
        redScorePanel.add(redScore);
        redScore.setBackground(Color.RED);
        blueScore.setBackground(Color.BLUE);
        blueScore.setForeground(Color.WHITE);
        redScorePanel.setBackground(Color.RED);
        blueScorePanel.setBackground(Color.BLUE);
        blueScorePanel.add(blueScore);
        inputPanel.add(redScorePanel, BorderLayout.WEST);
        inputPanel.add(blueScorePanel, BorderLayout.EAST);
        input.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                input.setText("");
            }
        });
        input.addActionListener(e -> submitButton.doClick());
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(submitButton, BorderLayout.SOUTH);
        submitButton.addActionListener(e -> {
            if(matchDone) {
                frame.dispose();
            } else {
                submitText = input.getText();
                switch (s) {
                    case ("TP") -> TIPPINGPOINT_Match.nextQuestion = true;
                    case ("SU") -> SPINUP_Match.nextQuestion = true;
                }
            }
        });
        frame.pack();
        frame.setVisible(true);
    }



}
