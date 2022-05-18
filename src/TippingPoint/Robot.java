package TippingPoint;

public class Robot {
    private boolean parked;

    public Robot() {
        parked = false;
    }

    public void setPark(boolean p) {
        parked = p;
    }

    public boolean getPark() {
        return parked;
    }
}
