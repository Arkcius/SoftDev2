package unit03.thegame;

public interface Player{
    MoveType nextMove();
    DiscardMove discard();
    boolean deal(int card);
    boolean handIsFull();
    boolean handIsEmpty();
    boolean confirmGameOver();
}