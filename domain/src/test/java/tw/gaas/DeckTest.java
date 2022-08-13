package tw.gaas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tw.gaas.Color.*;

class DeckTest {


    @Test
    public void givenUnoGameInit_whenGetStandard108Cards_thenHas19RedNumberCard() {
        int counts = getColorCardsCounts(NumberCard.class, RED);
        assertEquals(19, counts);
    }

    @Test
    public void givenUnoGameInit_whenGetStandard108Cards_thenHas19GreenNumberCard() {
        int counts = getColorCardsCounts(NumberCard.class, GREEN);
        assertEquals(19, counts);
    }

    @Test
    public void givenUnoGameInit_whenGetStandard108Cards_thenHas19YellowNumberCard() {
        int counts = getColorCardsCounts(NumberCard.class, YELLOW);
        assertEquals(19, counts);
    }

    @Test
    public void givenUnoGameInit_whenGetStandard108Cards_thenHas19BlueNumberCard() {
        int counts = getColorCardsCounts(NumberCard.class, BLUE);
        assertEquals(19, counts);
    }

    @Test
    public void givenUnoGameInit_whenGetStandard108Cards_thenHas2ReverseCardsShouldBeSuccess() {
        for (Color color : values()) {
            int counts = getColorCardsCounts(ReverseCard.class, color);
            assertEquals(2, counts);
        }
    }

    @Test
    public void givenUnoGameInit_whenGetStandard108Cards_thenHas2SkipCardsShouldBeSuccess() {
        for (Color color : values()) {
            int counts = getColorCardsCounts(SkipCard.class, color);
            assertEquals(2, counts);
        }
    }


    @Test
    public void givenUnoGameInit_whenGetStandard108Cards_thenHas2DrawTwoCardsShouldBeSuccess() {
        for (Color color : values()) {
            int counts = getColorCardsCounts(DrawTwoCard.class, color);
            assertEquals(2, counts);
        }
    }

    @Test
    public void givenUnoGameInit_whenGetStandard108Cards_thenHas4WildCardsShouldBeSuccess() {
        int counts = (int) Deck.standard108Cards().stream()
                .filter(WildCard.class::isInstance)
                .map(WildCard.class::cast).count();
        assertEquals(4, counts);
    }

    @Test
    public void givenUnoGameInit_whenGetStandard108Cards_thenHas4WildDrawFourCardsShouldBeSuccess() {
        int counts = (int) Deck.standard108Cards().stream()
                .filter(WildDrawFourCard.class::isInstance)
                .map(WildDrawFourCard.class::cast).count();
        assertEquals(4, counts);
    }


    private int getColorCardsCounts(Class<? extends ColorCard> colorCardClass, Color color) {
        return (int) Deck.standard108Cards().stream()
                .filter(colorCardClass::isInstance)
                .map(colorCardClass::cast)
                .filter(colorCard -> colorCard.getColor() == color)
                .count();
    }

    @Test
    public void givenUnoGameInit_whenGetStandard108Cards_thenNumberCardsShouldBeSuccess() {
        Number[] numbers = Number.values();
        for (Color color : values()) {
            for (int i = 1; i < numbers.length; i++) {
                assertEquals(2, getNumberCardsCounts(color, numbers[i]));
            }
            assertEquals(1, getNumberCardsCounts(color, numbers[0]));
        }
    }

    private int getNumberCardsCounts(Color color, Number number) {
        return (int) Deck.standard108Cards().stream()
                .filter(NumberCard.class::isInstance)
                .map(NumberCard.class::cast)
                .filter(numberCard -> numberCard.getColor() == color)
                .filter(numberCard -> numberCard.getNumber() == number)
                .count();
    }

}