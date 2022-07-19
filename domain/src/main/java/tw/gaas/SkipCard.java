package tw.gaas;

public class SkipCard extends Card{
    public SkipCard(Color color) {
        super(color);
    }

    @Override
    public boolean validate(Card card) {
        return this.color.equals(card.color);
    }
}
