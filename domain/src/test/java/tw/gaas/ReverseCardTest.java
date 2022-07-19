package tw.gaas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseCardTest {

@Test
public void givenTopCardBlueReverseCard_whenShowCardBlueReverseCard_thenShouldBeSuccess(){
    ReverseCard topCard = new ReverseCard(Card.Color.blue);
    ReverseCard showCard = new ReverseCard(Card.Color.blue);
    assertTrue(showCard.validate(topCard));
}
@Test
public void givenTopCardBlueReverseCard_whenShowCardGreenReverseCard_thenShouldBeFail(){
    ReverseCard topCard = new ReverseCard(Card.Color.blue);
    ReverseCard showCard = new ReverseCard(Card.Color.green);
    assertFalse(showCard.validate(topCard));
}
}