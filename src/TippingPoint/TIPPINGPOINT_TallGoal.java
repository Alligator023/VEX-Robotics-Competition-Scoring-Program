package TippingPoint;

public class TIPPINGPOINT_TallGoal extends TIPPINGPOINT_Goal{
    private int ringsTallBranch;

    public TIPPINGPOINT_TallGoal() {
        super('N');
        ringsTallBranch = 0;
    }

    public int getRingsTall() {
        return ringsTallBranch;
    }
    public void addRingsTall(int d) {
        ringsTallBranch += d;
    }
    public void setRingsTall(int d) {
        ringsTallBranch = d;
    }
}
