package SpinUp;

public class SPINUP_Roller {
    private boolean neutral;
    private String color;
    private String sideFormatColor;

    public SPINUP_Roller(char s) {
        switch(s) {
            case('R') :
            case('r') : sideFormatColor = "Red"; break;
            case('B') :
            case('b') : sideFormatColor = "Blue"; break;
            default : sideFormatColor = "";
        }
        neutral = true;
        color = "";
    }

    public boolean getNeutral() {
        return neutral;
    }
    public void setNeutral(boolean n) {
        neutral = n;
    }

    public String getColor() {
        if(!neutral) {
            return color;
        } else {
            return "Neutral";
        }
    }
    public void setColor(char c) {
        switch(c) {
            case('R') :
            case('r') : color = "Red"; neutral = false; break;
            case('B') :
            case('b') : color = "Blue"; neutral = false; break;
            case('N') :
            case('n') : neutral = true;
            default : color = "";
        }
    }

    public String getSide() {
        return sideFormatColor;
    }
    public void setSide(char s) {
        switch(s) {
            case('R') :
            case('r') : sideFormatColor = "Red"; break;
            case('B') :
            case('b') : sideFormatColor = "Blue"; break;
            default : sideFormatColor = "";
        }
    }
}
