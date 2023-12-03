package unit03.thegame;

public class Hand{
    private int[] cards;
    private int last;

    public Hand(int capacity){
        int[] hando = new int[capacity];
        this.cards = hando;
        this.last = -1;
    }

    public boolean deal(int card){
        if(last<=cards.length-1){
            last+=1;
            cards[last]=card;
            return true;
        }
        else{return false;}
    }

    public boolean isFull(){
        return last<=cards.length-1;
    }
    public boolean isEmpty(){
        return last==-1;
    }

    public void remove(int card){
        int i = 0;
        boolean removed = false;
        while(removed==false || i<=last){
            if(cards[i]==card){
                cards[i]=cards[last];
                last--;
                removed =true;
            }
            i++;
        }
    }

    @Override
    public String toString(){
        String returnal = "[";
        for(int i=0;i<=last;i++){
            returnal += cards[i];
            if(i!=last){
                returnal+= ", ";
            }
        }
        returnal += "]";
        return returnal;
    }

}