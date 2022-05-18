package TippingPoint;

public class TIPPINGPOINT_Goal {
    private int ringsBranch;
    private int ringsBase;
    private char color;
    private boolean balanced;
    private char owner;

    public TIPPINGPOINT_Goal(char c) {
        switch(c) {
            case('R') :
            case('r') : color = 'R'; break;
            case('B') :
            case('b') : color = 'B'; break;
            default : color = 'N';
        }
        ringsBase = 0;
        ringsBranch = 0;
        balanced = false;
        owner = color;
    }

    public int getRingsBranch() {
        return ringsBranch;
    }
    public int getRingsBase() {
        return ringsBase;
    }
    public void addRingsBranch(int d) {
        ringsBranch += d;
    }
    public void addRingsBase(int d) {
        ringsBase += d;
    }
    public void setRingsBranch(int d) {
        ringsBranch = d;
    }
    public void setRingsBase(int d) {
        ringsBase = d;
    }
    public boolean getBalanced() {
        return balanced;
    }
    public void setBalanced(boolean b) {
        balanced = b;
    }
    public char getOwner() {
        if(color == 'R' || color == 'B') {
            if(owner == color) {
                return owner;
            } else {
                return 'N';
            }
        } else {
            return owner;
        }
    }
    public void setOwner(char o) {
        owner = o;
    }
}
