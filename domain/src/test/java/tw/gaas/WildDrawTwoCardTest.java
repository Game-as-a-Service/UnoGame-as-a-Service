package tw.gaas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WildDrawTwoCardTest {


    @Test
    public void givenTopCardBlueWildDrawTwoCard_whenShowCardBlueWildDrawTwoCard_thenShouldBeSuccess(){
        Card topCard = new WildDrawTwoCard(Card.Color.blue);
        Card showCard = new WildDrawTwoCard(Card.Color.blue);
        assertTrue(showCard.validate(topCard));
    }
    @Test
    public void givenTopCardBlueWildDrawTwoCard_whenShowCardRedWildDrawTwoCard_thenShouldBeFail(){
        Card topCard = new WildDrawTwoCard(Card.Color.blue);
        Card showCard = new WildDrawTwoCard(Card.Color.red);
        assertFalse(showCard.validate(topCard));
    }
}