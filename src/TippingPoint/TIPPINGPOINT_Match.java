package TippingPoint;
import SpinUp.SPINUP_CornerZone;
import SpinUp.SPINUP_Goal;
import SpinUp.SPINUP_Robot;
import SpinUp.SPINUP_Roller;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.awt.*;

public class TIPPINGPOINT_Match {
    private static final TIPPINGPOINT_Robot[] robots = new TIPPINGPOINT_Robot[4];
    private static final TIPPINGPOINT_Goal[] goals = new TIPPINGPOINT_Goal[7];
    private static char autonWin;
    public static boolean nextQuestion = false;
    public static GUI.Frame window;
    public static void main(String[] args) throws InterruptedException {
        // GUI CREATION
        window = new GUI.Frame("VEX Robotics Competition 2022-2023 Tipping Point - SCORING PROGRAM");


        // Create the Robot Array, named Robots. Fill the array with two red robots and two blue robots.
        window.input.setText("Red 1");
        while(!nextQuestion) {
            TimeUnit.MILLISECONDS.sleep(1);
        }
        robots[0] = new TIPPINGPOINT_Robot(window.submitText, 'R');
        nextQuestion = false;
        window.input.setText("Red 2");
        while(!nextQuestion) {
            TimeUnit.MILLISECONDS.sleep(1);
        }
        robots[1] = new TIPPINGPOINT_Robot(window.submitText, 'B');
        nextQuestion = false;
        window.input.setText("Blue 1");
        while(!nextQuestion) {
            TimeUnit.MILLISECONDS.sleep(1);
        }
        robots[2] = new TIPPINGPOINT_Robot(window.submitText, 'B');
        nextQuestion = false;
        window.input.setText("Blue 2");
        while(!nextQuestion) {
            TimeUnit.MILLISECONDS.sleep(1);
        }
        robots[3] = new TIPPINGPOINT_Robot(window.submitText, 'B');
        nextQuestion = false;

        // Create the Goal Array, named Goals. Fill it with the correct number of goals.

        goals[0] = new TIPPINGPOINT_Goal('R'); // RED GOAL 1
        goals[1] = new TIPPINGPOINT_Goal('R'); // RED GOAL 2
        goals[2] = new TIPPINGPOINT_Goal('B'); // BLUE GOAL 1
        goals[3] = new TIPPINGPOINT_Goal('B'); // BLUE GOAL 2
        goals[4] = new TIPPINGPOINT_Goal('N'); // NEUTRAL GOAL 1
        goals[5] = new TIPPINGPOINT_Goal('N'); // NEUTRAL GOAL 2
        goals[6] = new TIPPINGPOINT_TallGoal(); // TALL GOAL

        // Create a variable for Auton Winner
        autonWin = 0;

        // BEGIN SCORING SETUP --------------------------------------------------------------------------
        // Write commands to set up the scenario which you wish to score

        window.input.setText("Red Goals owned (inc. balanced) by Red");
        while(!nextQuestion) {
            TimeUnit.MILLISECONDS.sleep(1);
        }
        for(int i = 0; i < Integer.parseInt(window.submitText); i++) {
            goals[i].setOwner('R');
        }
        nextQuestion = false;
        window.input.setText("Neutral Goals owned by Red");
        while(!nextQuestion) {
            TimeUnit.MILLISECONDS.sleep(1);
        }
        for(int i = 0; i < Integer.parseInt(window.submitText); i++) {
            goals[i+4].setOwner('R');
        }
        nextQuestion = false;
        window.input.setText("Blue Goals owned by Blue");
        while(!nextQuestion) {
            TimeUnit.MILLISECONDS.sleep(1);
        }
        for(int i = 0; i < Integer.parseInt(window.submitText); i++) {
            goals[i+2].setOwner('B');
        }
        nextQuestion = false;
        window.input.setText("Neutral Goals owned by Blue");
        while(!nextQuestion) {
            TimeUnit.MILLISECONDS.sleep(1);
        }
        int x = 6;
        for(int i = 0; i < Integer.parseInt(window.submitText); i++) {
            goals[x].setOwner('B');
            x--;
        }
        nextQuestion = false;
        window.input.setText("Red Goals balanced on Red");
        while(!nextQuestion) {
            TimeUnit.MILLISECONDS.sleep(1);
        }
        for(int i = 0; i < Integer.parseInt(window.submitText); i++) {
            goals[i].setBalanced(true);
        }
        nextQuestion = false;
        window.input.setText("Blue Goals balanced on Blue");
        while(!nextQuestion) {
            TimeUnit.MILLISECONDS.sleep(1);
        }
        for(int i = 0; i < Integer.parseInt(window.submitText); i++) {
            goals[i+2].setBalanced(true);
        }
        nextQuestion = false;
        window.input.setText("Neutral Goals balanced on Red");
        while(!nextQuestion) {
            TimeUnit.MILLISECONDS.sleep(1);
        }
        for(int i = 0; i < Integer.parseInt(window.submitText); i++) {
            goals[i+4].setBalanced(true);
        }
        nextQuestion = false;
        window.input.setText("Neutral Goals balanced on Blue");
        while(!nextQuestion) {
            TimeUnit.MILLISECONDS.sleep(1);
        }
        x = 6;
        for(int i = 0; i < Integer.parseInt(window.submitText); i++) {
            goals[x].setBalanced(true);
            x--;
        }
        nextQuestion = false;
        window.input.setText("Rings in bases that count for Red");
        while(!nextQuestion) {
            TimeUnit.MILLISECONDS.sleep(1);
        }
        goals[0].addRingsBase(Integer.parseInt(window.submitText));
        nextQuestion = false;
        window.input.setText("Rings on branches that count for Red");
        while(!nextQuestion) {
            TimeUnit.MILLISECONDS.sleep(1);
        }
        goals[0].addRingsBranch(Integer.parseInt(window.submitText));
        nextQuestion = false;
        window.input.setText("Rings on high branches that count for Red");
        while(!nextQuestion) {
            TimeUnit.MILLISECONDS.sleep(1);
        }
        ((TIPPINGPOINT_TallGoal)goals[6]).addRingsTall(Integer.parseInt(window.submitText));
        nextQuestion = false;
        window.input.setText("Rings in bases that count for Blue");
        while(!nextQuestion) {
            TimeUnit.MILLISECONDS.sleep(1);
        }
        goals[2].addRingsBase(Integer.parseInt(window.submitText));
        nextQuestion = false;
        window.input.setText("Rings on branches that count for Blue");
        while(!nextQuestion) {
            TimeUnit.MILLISECONDS.sleep(1);
        }
        goals[2].addRingsBranch(Integer.parseInt(window.submitText));
        nextQuestion = false;
        window.input.setText("Rings on high branches that count for Blue");
        while(!nextQuestion) {
            TimeUnit.MILLISECONDS.sleep(1);
        }
        ((TIPPINGPOINT_TallGoal)goals[6]).addRingsTall(Integer.parseInt(window.submitText));
        nextQuestion = false;
        window.input.setText("Red robots parked");
        while(!nextQuestion) {
            TimeUnit.MILLISECONDS.sleep(1);
        }
        for(int i = 0; i < Integer.parseInt(window.submitText); i++) {
            robots[i].setParked(true);
        }
        nextQuestion = false;
        window.input.setText("Blue robots parked");
        while(!nextQuestion) {
            TimeUnit.MILLISECONDS.sleep(1);
        }
        for(int i = 0; i < Integer.parseInt(window.submitText); i++) {
            robots[i+2].setParked(true);
        }
        nextQuestion = false;

        window.input.setText("Auton Winner");
        while(!nextQuestion) {
            TimeUnit.MILLISECONDS.sleep(1);
        }
        autonWin = window.submitText.charAt(0);
        nextQuestion = false;

        window.redScore.setText(redScore() + "");
        window.blueScore.setText(blueScore() + "");
        window.input.setText(score());
        window.matchDone = true;
        // END SCORING ----------------------------------------------------------------------------
    }

    public static String score() {
        String ret = "";
        ret += "Red had a score of " + redScore() + ". " + "Blue had a score of " + blueScore() + ". ";
        if(redScore() > blueScore()) {
            ret += "Red (" + robots[0].getTeam() + " and " + robots[1].getTeam() + ") Wins!";
            window.input.setBackground(Color.RED);
        } else if(blueScore() > redScore()){
            ret += "Blue (" + robots[2].getTeam() + " and " + robots[3].getTeam() + ") Wins!";
            window.input.setBackground(Color.BLUE);
            window.input.setForeground(Color.WHITE);
        } else {
            ret += "It's a Tie!";
            window.input.setBackground(Color.YELLOW);
        }
        return ret;
    }

    public static int redScore() {
        int score = 0;

        for(int i = 0; i < goals.length; i++) {
            if(goals[i].getOwner() == 'R') {
                score += 20;
                if(goals[i].getBalanced()) {
                    score += 20;
                }
            }
        }

        for(int i = 0; i < 2; i++) {
            if(robots[i].getParked()) {
                score += 30;
            }
        }

        score += goals[0].getRingsBase() + goals[0].getRingsBranch() * 3;
        if(goals[6].getOwner() == 'R') {
            score += ((TIPPINGPOINT_TallGoal)goals[6]).getRingsTall() * 10;
        }

        if(autonWin == 'R' || autonWin == 'r') {
            score += 6;
        } else if(autonWin == 'T' || autonWin == 't') {
            score += 3;
        }
        return score;
    }

    public static int blueScore() {
        int score = 0;

        for(int i = 0; i < goals.length; i++) {
            if(goals[i].getOwner() == 'B') {
                score += 20;
                if(goals[i].getBalanced()) {
                    score += 20;
                }
            }
        }

        for(int i = 0; i < 2; i++) {
            if(robots[i+2].getParked()) {
                score += 30;
            }
        }

        score += goals[2].getRingsBase() + goals[2].getRingsBranch() * 3;
        if(goals[6].getOwner() == 'B') {
            score += ((TIPPINGPOINT_TallGoal)goals[6]).getRingsTall() * 10;
        }

        if(autonWin == 'B' || autonWin == 'b') {
            score += 6;
        } else if(autonWin == 'T' || autonWin == 't') {
            score += 3;
        }
        return score;
    }
}