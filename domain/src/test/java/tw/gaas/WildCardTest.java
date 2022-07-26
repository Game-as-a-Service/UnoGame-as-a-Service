package tw.gaas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WildCardTest {

    @Test
    public void givenTopCardBlueWildCard_whenShowCardBlueWildCard_thenShouldBeSuccess(){
        Card topCard = new WildCard(Card.Color.BLUE);
        Card showCard = new WildCard(Card.Color.BLUE);
        assertTrue(showCard.validate(topCard));
    }
    @Test
    public void givenTopCardBlueWildCard_whenShowCardRedWildCard_thenShouldBeFail(){
        Card topCard = new WildCard(Card.Color.BLUE);
        Card showCard = new WildCard(Card.Color.RED);
        assertFalse(showCard.validate(topCard));
    }
}