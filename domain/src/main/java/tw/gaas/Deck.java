package tw.gaas;

import java.util.Stack;
import java.util.stream.Stream;

public class Deck {
    private static final int EACH_NON_ZERO_COLOR_CARD_AMOUNT = 2;
    private static final int EACH_WILD_CARD_AND_WILD_DRAW_FOUR_CARD_AMOUNT = 4;
    private final Stack<Card> drawPile = new Stack<>();

    public static Deck standard108Cards() {
        Deck deck = new Deck();
        createColorCards(deck);
        createWildCardsAndWildDrawFourCards(deck);
        return deck;
    }

    private static void createWildCardsAndWildDrawFourCards(Deck deck) {
        for (int i = 0; i < EACH_WILD_CARD_AND_WILD_DRAW_FOUR_CARD_AMOUNT; i++) {
            deck.push(new WildCard());
            deck.push(new WildDrawFourCard());
        }
    }

    private static void createColorCards(Deck deck) {
        for (Color color : Color.values()) {
            createNonZeroColorCards(deck, color);
            deck.push(new NumberCard(color, Number.ZERO));
        }
    }

    private static void createNonZeroColorCards(Deck deck, Color color) {
        for (int j = 0; j < EACH_NON_ZERO_COLOR_CARD_AMOUNT; j++) {
            createNumber1To9Cards(deck, color);
            deck.push(new SkipCard(color));
            deck.push(new ReverseCard(color));
            deck.push(new DrawTwoCard(color));
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
