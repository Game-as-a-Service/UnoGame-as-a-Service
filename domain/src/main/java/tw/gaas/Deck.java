package tw.gaas;

import java.util.Collections;
import java.util.Stack;
import java.util.stream.Stream;

import static tw.gaas.Number.ZERO;

public class Deck {
    private static final int EACH_NON_ZERO_COLOR_CARDS_AMOUNT = 2;
    private static final int EACH_WILD_CARDS_AND_WILD_DRAW_FOUR_CARDS_AMOUNT = 4;
    private final Stack<Card> drawPile = new Stack<>();

    public static Deck standard108Cards() {
        Deck deck = new Deck();
        createColorCards(deck);
        createFourWildCardsAndWildDrawFourCards(deck);
        return deck;
    }

    private static void createFourWildCardsAndWildDrawFourCards(Deck deck) {
        for (int i = 0; i < EACH_WILD_CARDS_AND_WILD_DRAW_FOUR_CARDS_AMOUNT; i++) {
            deck.push(new WildCard());
            deck.push(new WildDrawFourCard());
        }
    }

    private static void createColorCards(Deck deck) {
        Color[] colors = Color.values();
        for (Color color : colors) {
            createEachNonZeroColorCards(deck, color);
            deck.push(new NumberCard(color, ZERO));
        }
    }

    private static void createEachNonZeroColorCards(Deck deck, Color color) {
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

    public static Deck RedNumber0To9Cards() {
        Deck deck = new Deck();
        Color color = Color.RED;
        createNumber1To9Cards(deck, color);
        deck.push(new NumberCard(color, ZERO));
        return deck;
    }

    public Stream<Card> stream() {
        return drawPile.stream();
    }

    public void push(Card card) {
        drawPile.push(card);
    }

    public Card dealCard() {
        return drawPile.pop();
    }

    public void shuffle() {
        Collections.shuffle(this.drawPile);
    }
}
