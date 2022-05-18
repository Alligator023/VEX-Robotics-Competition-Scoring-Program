package SpinUp;

public class SPINUP_Goal {
    private String color;
    private int discsIn;

    public SPINUP_Goal(char c) {
        switch(c) {
            case('R') :
            case('r') : color = "Red"; break;
            case('B') :
            case('b') : color = "Blue"; break;
            default : color = "";
        }
        discsIn = 0;
    }

    public int getDiscs() {
        return discsIn;
    }
    public void addDiscs(int d) {
        discsIn += d;
    }
    public void setDiscs(int d) {
        discsIn = d;
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
