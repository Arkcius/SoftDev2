package unit03.thegame;
import java.util.Random;


public class Deck{
    private int[] cards;
    private int top;
    private final int DECKTOT=98;
    Random RNG = new Random();


    public Deck(){
        cards = new int[DECKTOT]; 
        for(int i =0;i<this.cards.length;i++){
            this.cards[i] = i+2;
        }
        this.top = 0;
    }

    public void Shuffle(){
        for(int i = 0;i<this.cards.length;i++){
            int rand = RNG.nextInt(0, i);
            int temp = cards[i];
            cards[i]=cards[rand];
            cards[rand] =temp;
        }
    }
    public int drawCard(){
        try{
            this.top += 1;
            return cards[top-1];
        }
        catch (ArrayIndexOutOfBoundsException e){
            return 0;
        }
    }
    public int remainingCardCount(){
        return DECKTOT - this.top;
    }

    @Override
    public String toString(){
        return "["+remainingCardCount()+"]";
    }
}
