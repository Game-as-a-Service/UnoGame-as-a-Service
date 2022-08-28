package tw.gaas;

public class TurnMove {
    private final Player player;
    private Card card;

    public TurnMove(Player player, Card card) {
        this.player = player;
        this.card = card;
    }

    public Player getPlayer() {
        return player;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public NumberCard getNumberCard() {
        return (NumberCard) card;
    }
}
