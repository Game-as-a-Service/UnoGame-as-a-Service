package tw.gaas;

import java.util.Stack;
import java.util.stream.Stream;

public class Deck {
    private static final int DOUBLE_CARDS = 2;
    private final Stack<Card> drawPile = new Stack<>();

    public static Deck standard108Cards() {
        Deck deck = new Deck();
        createColorCard(deck);
        return deck;
    }

    private static void createColorCard(Deck deck) {
        Color[] colors = Color.values();
        for (Color color : colors) {
            createDoubleCards(deck, color);
            deck.drawPile.push(new NumberCard(color, Number.ZERO));
        }
    }

    private static void createDoubleCards(Deck deck, Color color) {
        for (int i = 0; i < DOUBLE_CARDS; i++) {
            createNumber1To9Cards(deck, color);
        }
    }

    private static void createNumber1To9Cards(Deck deck, Color color) {
            Number[] numbers = Number.values();
        for (int i = 1; i < numbers.length; i++) {
            deck.drawPile.push(new NumberCard(color, numbers[i]));
        }
    }

    public Stream<Card> stream(){
        return drawPile.stream();
    }
}
