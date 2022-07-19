package tw.gaas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WildDrawFourCardTest {

    @Test
    public void givenTopCardBlueWildDrawFourCard_whenShowCardBlueWildDrawFourCard_thenShouldBeSuccess(){
        Card topCard = new WildDrawFourCard(Card.Color.blue);
        Card showCard = new WildDrawFourCard(Card.Color.blue);
        assertTrue(showCard.validate(topCard));
    }
    @Test
    public void givenTopCardBlueWildDrawFourCard_whenShowCardRedWildDrawFourCard_thenShouldBeFail(){
        Card topCard = new WildDrawFourCard(Card.Color.blue);
        Card showCard = new WildDrawFourCard(Card.Color.red);
        assertFalse(showCard.validate(topCard));
    }
}