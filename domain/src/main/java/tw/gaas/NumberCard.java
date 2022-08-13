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
    ZERO(0), ONE(1), TWO(2), THREE(3), FOUR(4),
    FIVE(5) , SIX(6), SEVEN(7), EIGHT(8), NINE(9);

    private final int value;

    Number(int value) {
        this.value = value;
    }
}
