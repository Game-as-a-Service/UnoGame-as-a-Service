package tw.gaas;

public class WildDrawTwoCard extends Card{
    public WildDrawTwoCard(Color color) {
        super(color);
    }

    @Override
    public boolean validate(Card card) {
        return this.color.equals(card.color);
    }
}
