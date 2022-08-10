package tw.gaas;

import java.util.Stack;

public class Deck {
    private static final int DOUBLE_CARDS = 2;
    private final Stack<Card> cards = new Stack<>();
    private static final Number[] numbers = Number.values();
    private static final Color[] colors = Color.values();

    public static Deck standard108Cards() {
        Deck deck = new Deck();
        createColorCard(deck);
        return deck;
    }

    private static void createColorCard(Deck deck) {
        for (Color color : colors) {
            createDoubleCards(deck, color);
            createNumber0Card(deck, color);
        }
    }

    private static void createNumber0Card(Deck deck, Color color) {
        deck.cards.push(new NumberCard(color, Number.ZERO));
    }

    private static void createDoubleCards(Deck deck, Color color) {
        for (int i = 0; i < DOUBLE_CARDS; i++) {
            createNumber1To9Cards(deck, color);
        }
    }

    private static void createNumber1To9Cards(Deck deck, Color color) {
        for (int i = 1; i < Deck.numbers.length; i++) {
            deck.cards.push(new NumberCard(color, Deck.numbers[i]));
        }
    }


    public Stack<Card> getCards() {
        return cards;
    }
}
