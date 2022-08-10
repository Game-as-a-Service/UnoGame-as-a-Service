package tw.gaas;

import java.util.Stack;

public class Deck {
    Stack<Card> cards = new Stack<>();

    public static Deck standard108Cards() {
        Deck deck = new Deck();
        Number[] numbers = Number.values();
        for (int j = 0; j < 2; j++) {
            for (int i = 1; i < numbers.length; i++) {
                deck.cards.push(new NumberCard(Color.RED, numbers[i]));
            }
        }
        deck.cards.push(new NumberCard(Color.RED, Number.ZERO));
        return deck;
    }

    public Stack<Card> getCards() {
        return cards;
    }
}
