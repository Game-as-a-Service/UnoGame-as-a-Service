package tw.gaas;

public class NumberCard extends ColorCard {
    private final Number number;

    public NumberCard(Color color, Number number) {
        super(color);
        this.number = number;
    }

    public Number getNumber() {
        return number;
    }
}

enum Number {
    ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE
}