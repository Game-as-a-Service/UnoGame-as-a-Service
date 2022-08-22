package tw.gaas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tw.gaas.Color.*;

class DeckTest {

    private static final int EACH_NON_ZERO_COLOR_CARDS_AMOUNT = 2;
    private static final int EACH_WILD_CARDS_AND_WILD_DRAW_FOUR_CARDS_AMOUNT = 4;
    private  Deck deck;

    @BeforeEach
    void init() {
        deck = Deck.standard108Cards();
    }

    @Test
    public void whenGetStandard108Cards_thenEachColorShouldHave19NumberCards() {
        int EACH_COLOR_NUMBER_CARDS_AMOUNT = 19;
        assertEquals(EACH_COLOR_NUMBER_CARDS_AMOUNT, getNumberCardColorCounts(RED));
        assertEquals(EACH_COLOR_NUMBER_CARDS_AMOUNT, getNumberCardColorCounts(YELLOW));
        assertEquals(EACH_COLOR_NUMBER_CARDS_AMOUNT, getNumberCardColorCounts(BLUE));
        assertEquals(EACH_COLOR_NUMBER_CARDS_AMOUNT, getNumberCardColorCounts(GREEN));
    }

    @Test
    public void whenGetStandard108Cards_thenEachColorShouldHave2SkipCards() {
        for (Color color : values()) {
            assertEquals(EACH_NON_ZERO_COLOR_CARDS_AMOUNT, getColorCardsCounts(color, SkipCard.class));
        }
    }

    @Test
    public void whenGetStandard108Cards_thenEachColorShouldHave2ReVerseCards() {
        for (Color color : values()) {
            assertEquals(EACH_NON_ZERO_COLOR_CARDS_AMOUNT, getColorCardsCounts(color, ReverseCard.class));
        }
    }

    @Test
    public void whenGetStandard108Cards_thenEachColorShouldHave2DrawTwoCards() {
        for (Color color : values()) {
            assertEquals(EACH_NON_ZERO_COLOR_CARDS_AMOUNT, getColorCardsCounts(color, DrawTwoCard.class));
        }
    }


    @Test
    public void whenGetStandard108Cards_thenShouldHave4WildCards() {
        assertEquals(EACH_WILD_CARDS_AND_WILD_DRAW_FOUR_CARDS_AMOUNT, getWildCardsOrWildDrawFourCardsCounts(WildCard.class));
    }

    @Test
    public void whenGetStandard108Cards_thenShouldHave4WildDrawFourCards() {
        assertEquals(EACH_WILD_CARDS_AND_WILD_DRAW_FOUR_CARDS_AMOUNT, getWildCardsOrWildDrawFourCardsCounts(WildDrawFourCard.class));
    }

    private Long getWildCardsOrWildDrawFourCardsCounts(Class cardClass) {
        return deck.stream()
                .filter(cardClass::isInstance)
                .map(cardClass::cast).count();
    }


    private long getColorCardsCounts(Color color, Class<? extends ColorCard> cardClass) {
        return deck.stream()
                .filter(cardClass::isInstance)
                .map(cardClass::cast)
                .filter(colorCard -> colorCard.getColor() == color).count();
    }


    private long getNumberCardColorCounts(Color color) {
        return deck.stream()
                .filter(NumberCard.class::isInstance)
                .map(NumberCard.class::cast)
                .filter(numberCard -> numberCard.getColor() == color)
                .count();
    }


}