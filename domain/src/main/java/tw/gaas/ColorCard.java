package tw.gaas;

public class ColorCard extends Card {
    private final Color color;

    public ColorCard(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}

enum Color {
    RED
}