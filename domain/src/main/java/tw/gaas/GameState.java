package tw.gaas;

public class GameState {
    private Direction direction;
    private boolean skip=false;
    private int drawCardsAmount=0;
    private Color color;

    public Direction getDirection() {
        return direction;
    }

    public boolean isSkip() {
        return skip;
    }

    public int getDrawCardsAmount() {
        return drawCardsAmount;
    }

    public Color getColor() {
        return color;
    }
}
