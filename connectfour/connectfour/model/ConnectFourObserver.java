package unit04.connectfour.model;

public interface ConnectFourObserver {
    // public abstract void checkerPlayed(ConnectFour connectFour);
    public abstract void checkerPlayed(Checker checker, int col, int row);
}
