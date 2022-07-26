package tw.gaas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static tw.gaas.Card.Color;

class NumberCardTest {

    //givenTopCardBlue7_whenShowCardBlue1_shouldBeSuccess()
    @Test
    public void givenTopCardBlue7_whenShowCardBlue1_shouldBeSuccess() {
        NumberCard topCard = givenCard(Color.BLUE, 7);
        NumberCard showCard = givenCard(Color.BLUE, 1);
        assertTrue(showCard.validate(topCard));
    }



    @Test
    public void givenTopCardBlue7_whenShowCardRed1_shouldFail() {
        NumberCard topCard = givenCard(Color.BLUE, 7);
        NumberCard showCard = givenCard(Color.RED, 1);
        assertFalse(showCard.validate(topCard));
    }

    @Test
    public void givenTopCardBlue7_whenShowCardRed7_shouldBeSuccess() {
        NumberCard topCard = givenCard(Color.BLUE, 7);
        NumberCard showCard = givenCard(Color.RED, 7);
        assertTrue(showCard.validate(topCard));
    }

    private NumberCard givenCard(Color color, int number) {
        return new NumberCard(color, number);
    }
}