package TippingPoint;

public class TIPPINGPOINT_Robot {
    private String team;
    private char color;
    private boolean parked;

    public TIPPINGPOINT_Robot(String t, char c) {
        switch(c) {
            case('R') :
            case('r') : color = 'R'; break;
            case('B') :
            case('b') : color = 'B'; break;
            default : color = 'N';
        }
        team = t;
        parked = false;
    }

    public String getTeam() {
        return team;
    }
    public char getColor() {
        return color;
    }
    public boolean getParked() {
        return parked;
    }
    public void setParked(boolean p) {
        parked = p;
    }
}
