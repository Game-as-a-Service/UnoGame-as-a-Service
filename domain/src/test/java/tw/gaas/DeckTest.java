package tw.gaas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tw.gaas.Color.*;

class DeckTest {
    private static final int EACH_NON_ZERO_COLOR_CARD_AMOUNT = 2;
    private static final int EACH_WILD_CARD_AND_WILD_DRAW_FOUR_CARD_AMOUNT = 4;

    private Deck deck;

    @BeforeEach
    void init() {
        deck = Deck.standard108Cards();
    }

//    數字卡 (NumberCard)
//    牌數 : 每個顏色各有19張牌
//    數字1-9各有 2張 、數字0只有 1 張

//    暫停卡 (SkipCard) :
//    牌數 : 每個顏色 各有2張

//    迴轉卡 (ReverseCard) :
//    牌數 : 每個顏色 各有2張

//    +2卡 (DrawTwoCard)
//    牌數 : 每個顏色 各有2張

//    萬用牌 WildCard
//    牌數: 一共四張牌

//    +4卡 (WildDrawFourCard )
//    牌數: 一共四張牌

    @Test
    public void whenGetStandard108Cards_thenEachColorShouldHave19NumberCards() {
        int eachColorNumberCardsAmount = 19;
        assertEquals(eachColorNumberCardsAmount, getNumberCardColorCounts(RED));
        assertEquals(eachColorNumberCardsAmount, getNumberCardColorCounts(YELLOW));
        assertEquals(eachColorNumberCardsAmount, getNumberCardColorCounts(BLUE));
        assertEquals(eachColorNumberCardsAmount, getNumberCardColorCounts(GREEN));
    }

    @Test
    public void whenGetStandard108Cards_thenEachColorShouldHave2SkipCards() {
        for (Color color : Color.values()) {
            assertEquals(EACH_NON_ZERO_COLOR_CARD_AMOUNT, getColorCardsCounts(color, SkipCard.class));
        }
    }

    @Test
    public void whenGetStandard108Cards_thenEachColorShouldHave2ReverseCards() {
        for (Color color : Color.values()) {
            assertEquals(EACH_NON_ZERO_COLOR_CARD_AMOUNT, getColorCardsCounts(color, ReverseCard.class));
        }
    }

    @Test
    public void whenGetStandard108Cards_thenEachColorShouldHave2DrawTwoCards() {
        for (Color color : Color.values()) {
            assertEquals(EACH_NON_ZERO_COLOR_CARD_AMOUNT, getColorCardsCounts(color, DrawTwoCard.class));
        }
    }

    @Test
    public void whenGetStandard108Cards_thenShouldHave4WildCards() {
        assertEquals(EACH_WILD_CARD_AND_WILD_DRAW_FOUR_CARD_AMOUNT, getWildCardsOrWildDrawFourCardsCounts(WildCard.class));
    }

    @Test
    public void whenGetStandard108Cards_thenShouldHave4WildDrawFourCards() {
        assertEquals(EACH_WILD_CARD_AND_WILD_DRAW_FOUR_CARD_AMOUNT, getWildCardsOrWildDrawFourCardsCounts(WildDrawFourCard.class));
    }

    private long getWildCardsOrWildDrawFourCardsCounts(Class<? extends Card> cardClass) {
        return deck.stream()
                .filter(cardClass::isInstance)
                .map(cardClass::cast)
                .count();
    }

    private long getColorCardsCounts(Color color, Class<? extends ColorCard> cardClass) {
        return deck.stream()
                .filter(cardClass::isInstance)
                .map(cardClass::cast)
                .filter(colorCard -> colorCard.getColor() == color)
                .count();
    }

    private long getNumberCardColorCounts(Color color) {
        return deck.stream()
                .filter(NumberCard.class::isInstance)
                .map(NumberCard.class::cast)
                .filter(numberCard -> numberCard.getColor() == color)
                .count();
    }
}