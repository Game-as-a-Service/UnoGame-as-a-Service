package tw.gaas;

import java.util.Stack;
import java.util.stream.Stream;

public class Deck {
    private Stack<Card> drawPile = new Stack<>();

    public static Deck standard108Cards() {
        Deck deck = new Deck();
        Number[] numbers = Number.values();
        for (int j = 0; j < 2; j++) {
            for (int i = 1; i < numbers.length; i++) {
                deck.drawPile.push(new NumberCard(Color.RED, numbers[i]));
            }
        }
        deck.drawPile.push(new NumberCard(Color.RED, Number.ZERO));
        return deck;
    }

    public Stream<Card> stream() {
        return drawPile.stream();
    }
}
