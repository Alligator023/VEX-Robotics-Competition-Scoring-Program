package SpinUp;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.awt.*;

public class SPINUP_Match {
    private static final SPINUP_Robot[] robots = new SPINUP_Robot[4];
    private static final SPINUP_Goal[] goals = new SPINUP_Goal[2];
    private static final SPINUP_Roller[] rollers = new SPINUP_Roller[4];
    private static final SPINUP_CornerZone[] zones = new SPINUP_CornerZone[2];
    private static char autonWin;
    public static boolean nextQuestion = false;
    public static GUI.Frame window;
    public static void main(String[] args) throws InterruptedException {
        // GUI CREATION
        window = new GUI.Frame("VEX Robotics Competition 2022-2023 Spin Up - SCORING PROGRAM");


        // Create the Robot Array, named Robots. Fill the array with two red robots and two blue robots.
        window.input.setText("Red 1");
        while(!nextQuestion) {
            TimeUnit.MILLISECONDS.sleep(1);
        }
        robots[0] = new SPINUP_Robot(window.submitText, 'R');
        nextQuestion = false;
        window.input.setText("Red 2");
        while(!nextQuestion) {
            TimeUnit.MILLISECONDS.sleep(1);
        }
        robots[1] = new SPINUP_Robot(window.submitText, 'R');
        nextQuestion = false;
        window.input.setText("Blue 1");
        while(!nextQuestion) {
            TimeUnit.MILLISECONDS.sleep(1);
        }
        robots[2] = new SPINUP_Robot(window.submitText, 'B');
        nextQuestion = false;
        window.input.setText("Blue 2");
        while(!nextQuestion) {
            TimeUnit.MILLISECONDS.sleep(1);
        }
        robots[3] = new SPINUP_Robot(window.submitText, 'B');
        nextQuestion = false;

        // Create the Goal Array, named Goals. Fill it with a red Goal and a blue Goal

        goals[0] = new SPINUP_Goal('R'); // RED GOAL
        goals[1] = new SPINUP_Goal('B'); // BLUE GOAL

        // Create the Roller Array, named Rollers. Fill it with two rollers on the red side, and two on the blue side.

        rollers[0] = new SPINUP_Roller('R'); // RED ROLLER 1
        rollers[1] = new SPINUP_Roller('r'); // RED ROLLER 2
        rollers[2] = new SPINUP_Roller('B'); // BLUE ROLLER 1
        rollers[3] = new SPINUP_Roller('b'); // BLUE ROLLER 2

        // Create a CornerZone Array, named Zones. Fill it with a red Zone and a blue Zone.

        zones[0] = new SPINUP_CornerZone('R'); // RED ZONE (under Blue Goal)
        zones[1] = new SPINUP_CornerZone('B'); // BLUE ZONE (under Red Goal)

        // Create a variable for Auton Winner
        autonWin = 0;

        // BEGIN SCORING SETUP --------------------------------------------------------------------------
        // Write commands to set up the scenario which you wish to score

        window.input.setText("Discs in RHG");
        while(!nextQuestion) {
            TimeUnit.MILLISECONDS.sleep(1);
        }
        goals[0].addDiscs(Integer.parseInt(window.submitText));
        nextQuestion = false;
        window.input.setText("Discs in BHG");
        while(!nextQuestion) {
            TimeUnit.MILLISECONDS.sleep(1);
        }
        goals[1].addDiscs(Integer.parseInt(window.submitText));
        nextQuestion = false;
        window.input.setText("Color of Roller 1");
        while(!nextQuestion) {
            TimeUnit.MILLISECONDS.sleep(1);
        }
        rollers[0].setColor(window.submitText.charAt(0));
        nextQuestion = false;
        window.input.setText("Color of Roller 2");
        while(!nextQuestion) {
            TimeUnit.MILLISECONDS.sleep(1);
        }
        rollers[1].setColor(window.submitText.charAt(0));
        nextQuestion = false;
        window.input.setText("Color of Roller 3");
        while(!nextQuestion) {
            TimeUnit.MILLISECONDS.sleep(1);
        }
        rollers[2].setColor(window.submitText.charAt(0));
        nextQuestion = false;
        window.input.setText("Color of Roller 4");
        while(!nextQuestion) {
            TimeUnit.MILLISECONDS.sleep(1);
        }
        rollers[3].setColor(window.submitText.charAt(0));
        nextQuestion = false;
        window.input.setText("Discs in RLG");
        while(!nextQuestion) {
            TimeUnit.MILLISECONDS.sleep(1);
        }
        zones[0].addDiscs(Integer.parseInt(window.submitText));
        nextQuestion = false;
        window.input.setText("Discs in BLG");
        while(!nextQuestion) {
            TimeUnit.MILLISECONDS.sleep(1);
        }
        zones[1].addDiscs(Integer.parseInt(window.submitText));
        nextQuestion = false;
        window.input.setText("Tiles covered by Red");
        while(!nextQuestion) {
            TimeUnit.MILLISECONDS.sleep(1);
        }
        robots[0].setTiles(Integer.parseInt(window.submitText));
        nextQuestion = false;
        window.input.setText("Tiles covered by Blue");
        while(!nextQuestion) {
            TimeUnit.MILLISECONDS.sleep(1);
        }
        robots[2].setTiles(Integer.parseInt(window.submitText));
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

        score += robots[0].getTiles() * 3;

        score += goals[0].getDiscs() * 5;

        for(SPINUP_Roller x : rollers) {
            if(x.getColor().equals("Red")) {
                score += 10;
            }
        }

        score += zones[0].getDiscs();

        if(autonWin == 'R' || autonWin == 'r') {
            score += 10;
        } else if(autonWin == 'T' || autonWin == 't') {
            score += 5;
        }
        return score;
    }

    public static int blueScore() {
        int score = 0;

        score += robots[2].getTiles() * 3;

        score += goals[1].getDiscs() * 5;

        for(SPINUP_Roller x : rollers) {
            if(x.getColor().equals("Blue")) {
                score += 10;
            }
        }

        score += zones[1].getDiscs();

        if(autonWin == 'B' || autonWin == 'b') {
            score += 10;
        } else if(autonWin == 'T' || autonWin == 't') {
            score += 5;
        }
        return score;
    }
}
