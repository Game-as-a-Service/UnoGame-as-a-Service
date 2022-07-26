package tw.gaas;

public abstract class Card {
    protected final Color color;

    public Card(Color color) {
        this.color = color;
    }


    public abstract boolean validate(Card card);

    public enum Color {
        BLUE, RED, YELLOW, GREEN
    }
}
