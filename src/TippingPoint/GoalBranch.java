package TippingPoint;

public class GoalBranch {
    private int numRings;
    private int ringValue;

    public GoalBranch(int val) {
        numRings = 0;
        ringValue = val;
    }

    public void addRings(int num) {
        numRings += num;
    }
}
