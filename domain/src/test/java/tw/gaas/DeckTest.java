package tw.gaas;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tw.gaas.Color.*;

class DeckTest {
    private final Color[] colors = values();
    private final int NUMBER_CARDS_AMOUNT = 19;
    private static final int EACH_NON_ZERO_COLOR_CARD_AMOUNT = 2;

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
    public void whenGetStandard108Cards_thenHas19RedNumberCardsShouldBeSuccess() {
        assertEquals(NUMBER_CARDS_AMOUNT, getNumberCardColorCounts(RED));
    }

    @Test
    public void whenGetStandard108Cards_thenHas19YellowNumberCardsShouldBeSuccess() {
        assertEquals(NUMBER_CARDS_AMOUNT, getNumberCardColorCounts(YELLOW));
    }

    @Test
    public void whenGetStandard108Cards_thenHas19BlueNumberCardsShouldBeSuccess() {
        assertEquals(NUMBER_CARDS_AMOUNT, getNumberCardColorCounts(BLUE));
    }
    @Test
    public void whenGetStandard108Cards_thenHas19GreenNumberCardsShouldBeSuccess() {
        assertEquals(NUMBER_CARDS_AMOUNT, getNumberCardColorCounts(GREEN));
    }
    @Test
    public void whenGetStandard108Cards_thenEachColor2SkipCardsShouldBeSuccess() {
        for (Color color : colors) {
            int counts = getColorCardsCounts(color, SkipCard.class);
            assertEquals(EACH_NON_ZERO_COLOR_CARD_AMOUNT, counts);
        }
    }

    private int getColorCardsCounts(Color color, Class<? extends ColorCard> cardClass) {
        return (int) Deck.standard108Cards().stream().filter(cardClass::isInstance)
                .map(cardClass::cast)
                .filter(colorCard -> colorCard.getColor() == color).count();
    }


    private int getNumberCardColorCounts(Color color) {
        Stream<Card> drawPileStream = Deck.standard108Cards().stream();

        return (int) drawPileStream
                .filter(NumberCard.class::isInstance)
                .map(NumberCard.class::cast)
                .filter(numberCard -> numberCard.getColor() == color)
                .count();
    }
}