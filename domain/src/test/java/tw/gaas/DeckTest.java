package tw.gaas;

import org.junit.jupiter.api.Test;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tw.gaas.Color.RED;

class DeckTest {
    @Test
    public void givenUnoGameInit_whenGetStandard108Cards_thenHas19RedNumberCard() {
        Stream<Card> drawPile= Deck.standard108Cards().stream();

        int size = (int) drawPile
                .filter(NumberCard.class::isInstance)
                .map(NumberCard.class::cast)
                .filter(numberCard -> numberCard.getColor() == RED)
                .count();
        assertEquals(19, size);
    }
}