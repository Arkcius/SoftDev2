package unit03.thegame;

public class DescendingPile extends DiscardPile{
        private final String RULES = "Cards must be discarded in descending  order unless the card is exactly 10 greater than the top card.";

    public DescendingPile(int topcard){
        super(topcard);
    }

    public String getRules(){return this.RULES;}
    public boolean discard(int card){
        if(card<this.getTopCard()){
            this.topCard = card;
            return true;
        }
        else if(card == this.getTopCard()+10){
            this.topCard = card;
            return true;
        }
        else{
            return false;
        }
    }
    @Override
    public String toString(){
        return "-{"+getTopCard()+"}";
    }
}