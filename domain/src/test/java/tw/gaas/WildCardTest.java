package tw.gaas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WildCardTest {

    @Test
    public void givenTopCardBlueWildCard_whenShowCardBlueWildCard_thenShouldBeSuccess(){
        Card topCard = new WildCard(Card.Color.blue);
        Card showCard = new WildCard(Card.Color.blue);
        assertTrue(showCard.validate(topCard));
    }
    @Test
    public void givenTopCardBlueWildCard_whenShowCardRedWildCard_thenShouldBeFail(){
        Card topCard = new WildCard(Card.Color.blue);
        Card showCard = new WildCard(Card.Color.red);
        assertFalse(showCard.validate(topCard));
    }
}