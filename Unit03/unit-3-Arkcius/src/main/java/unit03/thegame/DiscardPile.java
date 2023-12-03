package unit03.thegame;

public abstract class DiscardPile{
    protected int topCard;
    private int cardCount;

    public DiscardPile(int topcard){
        this.topCard = topcard;
        this.cardCount = 98;
    }
    public int getTopCard(){return this.topCard;}
    public int getCardCount(){return this.cardCount;}

    public abstract boolean discard(int card);
    public abstract String getRules();
}
