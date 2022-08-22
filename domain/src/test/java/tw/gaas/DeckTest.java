package tw.gaas;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tw.gaas.Color.*;

class DeckTest {

    private static final int EACH_NON_ZERO_COLOR_CARDS_AMOUNT = 2;
    private static final int EACH_WILD_CARDS_AND_WILD_DRAW_FOUR_CARDS_AMOUNT = 4;

    private Stream<Card> getDrawPileStream() {
        return Deck.standard108Cards().stream();
    }


    @Test
    public void whenGetStandard108Cards_thenEachColorShouldHave19NumberCards() {
        int EACH_COLOR_NUMBER_CARDS_AMOUNT = 19;
        assertEquals(EACH_COLOR_NUMBER_CARDS_AMOUNT, getNumberCardColorCounts(RED, getDrawPileStream()));
        assertEquals(EACH_COLOR_NUMBER_CARDS_AMOUNT, getNumberCardColorCounts(YELLOW, getDrawPileStream()));
        assertEquals(EACH_COLOR_NUMBER_CARDS_AMOUNT, getNumberCardColorCounts(BLUE, getDrawPileStream()));
        assertEquals(EACH_COLOR_NUMBER_CARDS_AMOUNT, getNumberCardColorCounts(GREEN, getDrawPileStream()));
    }

    @Test
    public void whenGetStandard108Cards_thenEachColorShouldHave2SkipCards() {
        for (Color color : values()) {
            assertEquals(EACH_NON_ZERO_COLOR_CARDS_AMOUNT, getColorCardsCounts(color, SkipCard.class, getDrawPileStream()));
        }
    }

    @Test
    public void whenGetStandard108Cards_thenEachColorShouldHave2ReVerseCards() {
        for (Color color : values()) {
            assertEquals(EACH_NON_ZERO_COLOR_CARDS_AMOUNT, getColorCardsCounts(color, ReverseCard.class, getDrawPileStream()));
        }
    }

    @Test
    public void whenGetStandard108Cards_thenEachColorShouldHave2DrawTwoCards() {
        for (Color color : values()) {
            assertEquals(EACH_NON_ZERO_COLOR_CARDS_AMOUNT, getColorCardsCounts(color, DrawTwoCard.class, getDrawPileStream()));
        }
    }


    @Test
    public void whenGetStandard108Cards_thenShouldHave4WildCards() {
        assertEquals(EACH_WILD_CARDS_AND_WILD_DRAW_FOUR_CARDS_AMOUNT, getWildCardsOrWildDrawFourCardsCounts(WildCard.class, getDrawPileStream()));
    }

    @Test
    public void whenGetStandard108Cards_thenShouldHave4WildDrawFourCards() {
        assertEquals(EACH_WILD_CARDS_AND_WILD_DRAW_FOUR_CARDS_AMOUNT, getWildCardsOrWildDrawFourCardsCounts(WildDrawFourCard.class, getDrawPileStream()));
    }

    private Long getWildCardsOrWildDrawFourCardsCounts(Class cardClass, Stream<Card> drawPileStream) {
        return drawPileStream
                .filter(cardClass::isInstance)
                .map(cardClass::cast).count();
    }


    private long getColorCardsCounts(Color color, Class<? extends ColorCard> cardClass, Stream<Card> drawPileStream) {
        return drawPileStream
                .filter(cardClass::isInstance)
                .map(cardClass::cast)
                .filter(colorCard -> colorCard.getColor() == color).count();
    }


    private long getNumberCardColorCounts(Color color, Stream<Card> drawPileStream) {
        return drawPileStream
                .filter(NumberCard.class::isInstance)
                .map(NumberCard.class::cast)
                .filter(numberCard -> numberCard.getColor() == color)
                .count();
    }


}