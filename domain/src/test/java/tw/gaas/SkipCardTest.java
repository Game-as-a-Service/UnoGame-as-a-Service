package tw.gaas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SkipCardTest {

    @Test
    public void givenTopCardBlueSkipCard_whenShowCardBlueSkipCard_thenShouldBeSuccess(){
        Card topCard = new SkipCard(Card.Color.blue);
        Card showCard = new SkipCard(Card.Color.blue);
        assertTrue(showCard.validate(topCard));
    }
    @Test
    public void givenTopCardBlueSkipCard_whenShowCardRedSkipCard_thenShouldBeFail(){
        Card topCard = new SkipCard(Card.Color.blue);
        Card showCard = new SkipCard(Card.Color.red);
        assertFalse(showCard.validate(topCard));
    }
}