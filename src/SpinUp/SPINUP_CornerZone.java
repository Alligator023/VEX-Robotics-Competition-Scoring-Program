package SpinUp;

public class SPINUP_CornerZone {
    private int discs;
    private String color;

    public SPINUP_CornerZone(char c) {
        switch(c) {
            case('R') :
            case('r') : color = "Red"; break;
            case('B') :
            case('b') : color = "Blue"; break;
            default : color = "";
        }
        discs = 0;
    }

    public int getDiscs() {
        return discs;
    }
    public void addDiscs(int d) {
        discs += d;
    }
    public void setDiscs(int d) {
        discs = d;
    }

    public String getColor() {
        return color;
    }
    public void setColor(char c) {
        switch(c) {
            case('R') :
            case('r') : color = "Red"; break;
            case('B') :
            case('b') : color = "Blue"; break;
            default : color = "";
        }
    }
}
