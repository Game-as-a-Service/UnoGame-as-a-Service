package tw.gaas;

import java.util.Stack;
import java.util.stream.Stream;

public class Deck {
    private final Stack<Card> drawPile = new Stack<>();

    public static Deck standard108Cards() {
        Deck deck = new Deck();
        Number[] numbers = Number.values();
        for (int j = 0; j < 2; j++) {
            for (int i = 1; i < numbers.length; i++) {
                deck.push(new NumberCard(Color.RED, numbers[i]));
            }
        }
        deck.push(new NumberCard(Color.RED, Number.ZERO));
        return deck;
    }

    private void push(Card card) {
        drawPile.push(card);
    }

    public Stream<Card> stream() {
        return drawPile.stream();
    }
}
