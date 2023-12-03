package unit07.gvt;

public class Cell {
    private int row;
    private int col;
    private boolean troll;

    public Cell(int row, int col, boolean troll){
        this.row = row;
        this.col=col;
        this.troll=troll;
    }

    public boolean isTroll(){
        return this.troll;
    }

    @Override
    public String toString(){
        return "("+row+", "+col+")";
    }
}
