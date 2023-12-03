package unit03;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import unit03.thegame.*;

public class TheGameTest{

    @Test
    public void drawTest(){
        Deck deck = new Deck();
        int actual = deck.drawCard();
        int expected = 2;
        assertEquals(expected, actual);
    }
    
    @Test
    public void drawremaining(){
        Deck deck = new Deck();
        deck.drawCard();
        int actual = deck.remainingCardCount();
        int expected = 97;
        assertEquals(expected,actual);
    }

    @Test
    public void discardt(){
        Deck deck = new Deck();
        AscendingPile pile = new AscendingPile(1);
        pile.discard(deck.drawCard());
        int actual = pile.getTopCard();
        int expected = 2;
        assertEquals(expected,actual);
    }
    @Test
    public void discardf(){
        Deck deck = new Deck();
        DescendingPile pile = new DescendingPile(1);
        boolean actual = pile.discard(deck.drawCard());
        boolean expected = false;
        assertEquals(expected,actual);
    }
    @Test
    public void discard10(){
        Deck deck = new Deck();
        DescendingPile pile = new DescendingPile(12);
        boolean actual = pile.discard(deck.drawCard());
        boolean expected = true;
        assertEquals(expected,actual);
    }
}