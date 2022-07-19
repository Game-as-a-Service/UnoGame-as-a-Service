package tw.gaas;

public class ReverseCard extends Card {
    public ReverseCard(Color color) {
        super(color);
    }

    @Override
    public boolean validate(Card card) {
        return this.color.equals(card.color);
    }
}
