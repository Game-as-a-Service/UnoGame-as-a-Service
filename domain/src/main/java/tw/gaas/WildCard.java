package tw.gaas;

public class WildCard extends Card{
    public WildCard(Color color) {
        super(color);
    }

    @Override
    public boolean validate(Card card) {
        return this.color.equals(card.color);
    }
}
