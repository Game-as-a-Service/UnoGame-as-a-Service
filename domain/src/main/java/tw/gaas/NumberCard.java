package tw.gaas;

public class NumberCard extends Card{
    private final int  number;

    public NumberCard(Color color, int number) {
        super(color);
        this.number = number;
    }
    public boolean validate(Card topCard) {
        if(topCard instanceof NumberCard){
            return this.color.equals(topCard.color)||this.number==((NumberCard) topCard).number;
        }
       return false;
    }

    public int getNumber() {
        return number;
    }
}
