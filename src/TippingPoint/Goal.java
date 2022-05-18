package TippingPoint;
import java.util.*;

public class Goal {
    private boolean neutral;
    private boolean alliance;
    private boolean tall;
    private String color;
    private int ringsInBase;
    private boolean stacked;
    private ArrayList<GoalBranch> branches;

    public Goal(boolean n, boolean t, char c) {
        stacked = false;
        neutral = n;
        alliance = !n;
        tall = t;
        ringsInBase = 0;
        if(neutral) {
            color = "Yellow";
            if(tall) {
                branches.add(new GoalBranch(10));
                branches.add(new GoalBranch(10));
            }
            branches.add(new GoalBranch(3));
            branches.add(new GoalBranch(3));
        } else {
            branches.add(new GoalBranch(3));
            if(c == 'R' || c == 'r') {
                color = "Red";
            }
            if(c == 'B' || c == 'b') {
                color = "Blue";
            }
        }
    }

    public void setStacked(boolean s) {
        stacked = s;
    }

    public boolean getStacked() {
        return stacked;
    }

    public int getRingsInBase() {
        return ringsInBase;
    }






}
