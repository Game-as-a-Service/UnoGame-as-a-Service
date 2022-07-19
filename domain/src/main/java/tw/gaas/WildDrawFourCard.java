package tw.gaas;

public class WildDrawFourCard extends Card{
    public WildDrawFourCard(Color color) {
        super(color);
    }

    @Override
    public boolean validate(Card card) {
        return this.color.equals(card.color);
    }
}
