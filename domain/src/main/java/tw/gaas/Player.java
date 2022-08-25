package tw.gaas;

import java.util.List;

public class Player {
    private final String id;
    private final String name;
    private Hand hand;

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
}
