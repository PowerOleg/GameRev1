package game.Models;

public class Player {
    private final String NAME;
    /*private final*/ String FIGURE;                            //добавил дичь v1

    public void setFIGURE(String FIGURE) {                      //добавил дичь v1
        this.FIGURE = FIGURE;
    }

    public Player(String NAME, String FIGURE) {
        this.NAME = NAME;
        this.FIGURE = FIGURE;
    }

    public String getNAME() {
        return NAME;
    }

    public String getFIGURE() {
        return FIGURE;
    }




}
