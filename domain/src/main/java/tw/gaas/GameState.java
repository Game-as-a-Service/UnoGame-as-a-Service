package tw.gaas;

public class GameState {
    private Direction direction;
    private final boolean skip = false;
    private final int drawCardsAmount = 0;
    private Color topCardColor;

    public Direction getDirection() {
        return direction;
    }

    public boolean isSkip() {
        return skip;
    }

    public int getDrawCardsAmount() {
        return drawCardsAmount;
    }

    public Color getTopCardColor() {
        return topCardColor;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
