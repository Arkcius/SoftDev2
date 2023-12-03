package unit03.thegame;

public class Table{
    private DiscardPile[] piles;
    private Deck deck;

    public Table(DiscardPile[] piles, Deck deck){
        this.piles = piles;
        this.deck = deck;
    }

    public int draw(){
        return deck.drawCard();
    }
    public boolean discard(int card, int pileNumber){
        try{
            return piles[pileNumber].discard(card);
        }
        catch (ArrayIndexOutOfBoundsException e){
            return false;
        }
    }


    public int numberOfPiles(){
        int inter = piles.length;
        return inter;
    }
    public int getTopCard(int pileNum){
        return piles[pileNum].getTopCard();
    }

    public boolean deckIsEmpty(){
        return this.deck.remainingCardCount()==0;
    }

    @Override
    public String toString(){
        String stringer = deck+"\n";
        for(int i = 0;i<piles.length;i++){
            stringer += (i+1)+":"+" "+piles[i]+"\n";
        }
        return stringer;

    }
}
