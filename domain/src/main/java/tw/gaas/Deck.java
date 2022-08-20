package tw.gaas;

import java.util.Stack;
import java.util.stream.Stream;

public class Deck {
    private static final int EACH_NON_ZERO_COLOR_CARD_AMOUNT = 2;
    private final Stack<Card> drawPile = new Stack<>();

    public static Deck standard108Cards() {
        Deck deck = new Deck();
        createColorCards(deck);
        return deck;
    }

    private static void createColorCards(Deck deck) {
        Color[] colors = Color.values();
        for (Color color : colors) {
            createNonZeroColorCards(deck, color);
            deck.push(new NumberCard(color, Number.ZERO));
        }
    }

    private static void createNonZeroColorCards(Deck deck, Color color) {
        for (int j = 0; j < EACH_NON_ZERO_COLOR_CARD_AMOUNT; j++) {
            deck.push(new SkipCard(color));
            createNumber1To9Cards(deck, color);
        }
    }

    private static void createNumber1To9Cards(Deck deck, Color color) {
        Number[] numbers = Number.values();
        for (int i = 1; i < numbers.length; i++) {
            deck.push(new NumberCard(color, numbers[i]));
        }
    }

    private void push(Card card) {
        drawPile.push(card);
    }

    public Stream<Card> stream() {
        return drawPile.stream();
    }
}
