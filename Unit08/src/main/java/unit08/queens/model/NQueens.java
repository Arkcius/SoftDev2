package unit08.queens.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import unit08.backtracker.Configuration;

public class NQueens implements Configuration<NQueens> {
    private final Queen[] queens;
    private final int n;

    public NQueens(int n, Queen[] queens){
        this.n = n;
        this.queens = queens;
    }
    public Queen[] getQueens(){return this.queens;}
    @Override
    public String toString(){
        String[][] board = new String[n][n];
        for (int row =0;row<n;row++){
            for(int col =0;col<n;col++){
                board[row][col]="[ ]";
            }
        }
        for(Queen q : queens){
            board[q.getRow()][q.getCol()]="[Q]";
        }
        return queens.toString();}

    @Override
    public Collection<NQueens> getSuccessors() {
        List<NQueens> successors = new ArrayList<>();
        int length = queens.length;
        int row = length>0 ? queens[length-1].getRow() +1 : 0;
        if(row<n){
            for(int col =0; col<n; col++){
                Queen[] copy = Arrays.copyOf(queens, length+1);
                copy[length] = new Queen(row,col);
                successors.add(new NQueens(n, copy));
            }
        }
        return successors;
        }

    @Override
    public boolean isValid() {
        int length = queens.length;
        if(length<2){return true;}
        else{
            Queen last = queens[length-1];
            for(int i=0; i<length-1;i++){
                if(last.canAttack(queens[i])){
                    return false;
                }
            }
            return true;
        }
        }

    @Override
    public boolean isGoal() {
        return isValid() && queens.length==n;
       }

    public static void main(String[] args){
        int n =4;
        NQueens queens = new NQueens(n, new Queen[0]);
    }
    
}
