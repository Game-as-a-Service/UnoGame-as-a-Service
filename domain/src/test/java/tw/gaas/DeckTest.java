package tw.gaas;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tw.gaas.Color.*;

class DeckTest {
    @Test
    public void givenUnoGameInit_whenGetStandard108Cards_thenHas19RedNumberCard() {
        Stack<Card> cards = Deck.standard108Cards().getCards();

        int size = (int) cards.stream()
                .filter(NumberCard.class::isInstance)
                .map(NumberCard.class::cast)
                .filter(colorCard -> colorCard.getColor() == RED)
                .count();
        assertEquals(19, size);
    }
}