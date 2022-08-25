package tw.gaas;

import java.util.List;

public class Hand {
    private List<Card> cards;

    public List<Card> getCards() {
        return cards;
    }

    public void addCards(Card card){
        cards.add(card);
    }
}
