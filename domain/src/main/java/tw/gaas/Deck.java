package tw.gaas;

import java.util.Stack;
import java.util.stream.Stream;

import static tw.gaas.Number.*;

public class Deck {
    private static final int EACH_NON_ZERO_COLOR_CARDS_AMOUNT = 2;
    private final Stack<Card> drawPile = new Stack<>();
    private static final int WILD_CARDS_AND_WILD_DRAW_FOUR_CARDS_AMOUNT = 4;

    public static Deck standard108Cards() {
        Deck deck = new Deck();
        createColorCard(deck);
        createQuadrupleCards(deck);
        return deck;
    }

    private static void createQuadrupleCards(Deck deck) {
        for (int i = 0; i < WILD_CARDS_AND_WILD_DRAW_FOUR_CARDS_AMOUNT; i++) {
            deck.push(new WildCard());
            deck.push(new WildDrawFourCard());
        }
    }

    private static void createColorCard(Deck deck) {
        Color[] colors = Color.values();
        for (Color color : colors) {
            createDoubleCards(deck, color);
            createNumberZeroCard(deck, color);
        }
    }

    private static void createNumberZeroCard(Deck deck, Color color) {
        deck.push(new NumberCard(color, ZERO));
    }

    private static void createDoubleCards(Deck deck, Color color) {
        for (int i = 0; i < EACH_NON_ZERO_COLOR_CARDS_AMOUNT; i++) {
            createNumber1To9Cards(deck, color);
            deck.push(new ReverseCard(color));
            deck.push(new SkipCard(color));
            deck.push(new DrawTwoCard(color));
        }
    }

    private static void createNumber1To9Cards(Deck deck, Color color) {
        Number[] numbers = Number.values();
        for (int i = 1; i < numbers.length; i++) {
            deck.push(new NumberCard(color, numbers[i]));
        }
    }

    public Stream<Card> stream() {
        return drawPile.stream();
    }

    private void push(Card card) {
        drawPile.push(card);
    }
}
