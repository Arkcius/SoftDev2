package unit04.reversi.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MoveMaker implements EventHandler<ActionEvent>{
    private int row;
    private int col;
    private final ReversiGUI rev;

    public MoveMaker(int row, int col, ReversiGUI rev){
        this.row =row;
        this.col = col;
        this.rev = rev;
    }
    
    
    @Override
    public void handle(ActionEvent event){
        rev.makeMove(row,col);
    }
}
