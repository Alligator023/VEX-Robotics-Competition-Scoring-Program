package SpinUp;

public class SPINUP_Robot {
    private String team;
    private String color;
    private int tiles;

    public SPINUP_Robot(String t, char c) {
        switch(c) {
            case('R') :
            case('r') : color = "Red"; break;
            case('B') :
            case('b') : color = "Blue"; break;
            default : color = "";
        }
        team = t;
        tiles = 1;
    }

    public String getTeam() {
        return team;
    }
    public String getColor() {
        return color;
    }
    public int getTiles() {
        return tiles;
    }
    public void setTiles(int t) {
        tiles = t;
    }
}
