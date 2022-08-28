package tw.gaas;

import java.util.List;

public class Player {
    private final String id;
    private final String name;
    private final Hand hand = new Hand();

    public Player(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Hand getHand() {
        return hand;
    }

    public List<Card> getHandCards() {
        return hand.getCards();
    }

    public void drawCard(Card card) {
        hand.addCards(card);
    }

    public String getName() {
        return name;
    }
}
