package tw.gaas;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tw.gaas.Color.*;

class DeckTest {
    private final Color[] colors = values();
    private static final int EACH_NON_ZERO_COLOR_CARD_AMOUNT = 2;
    private Stream<Card> getDrawPileStream() {
        return Deck.standard108Cards().stream();
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
        int EACH_COLOR_NUMBER_CARDS_AMOUNT = 19;
        assertEquals(EACH_COLOR_NUMBER_CARDS_AMOUNT, getNumberCardColorCounts(RED,getDrawPileStream()));
        assertEquals(EACH_COLOR_NUMBER_CARDS_AMOUNT, getNumberCardColorCounts(YELLOW,getDrawPileStream()));
        assertEquals(EACH_COLOR_NUMBER_CARDS_AMOUNT, getNumberCardColorCounts(BLUE,getDrawPileStream()));
        assertEquals(EACH_COLOR_NUMBER_CARDS_AMOUNT, getNumberCardColorCounts(GREEN,getDrawPileStream()));
    }

    @Test
    public void whenGetStandard108Cards_thenEachColorShouldHave2SkipCards() {
        for (Color color : colors) {
            long counts = getColorCardsCounts(color, SkipCard.class,getDrawPileStream());
            assertEquals(EACH_NON_ZERO_COLOR_CARD_AMOUNT, counts);
        }
    }

    private long getColorCardsCounts(Color color, Class<? extends ColorCard> cardClass,Stream<Card> drawPileStream) {
        return drawPileStream
                .filter(cardClass::isInstance)
                .map(cardClass::cast)
                .filter(colorCard -> colorCard.getColor() == color).count();
    }


    private long getNumberCardColorCounts(Color color,Stream<Card> drawPileStream) {

        return drawPileStream
                .filter(NumberCard.class::isInstance)
                .map(NumberCard.class::cast)
                .filter(numberCard -> numberCard.getColor() == color)
                .count();
    }
}