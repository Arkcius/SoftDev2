package unit03.thegame;
import java.util.Scanner;

public class Human implements Player{
    private Hand hand;
    private Scanner scanner;

    public Human(Hand hand){
        this.hand = hand;
    }

    @Override
    public MoveType nextMove(){
        String move="";
        scanner = new Scanner(System.in);
        boolean chosen = false;
        while(chosen == false){
            System.out.print("Discard or Pass ");
            move = scanner.nextLine();
            if((!move.equals("p"))&&(!move.equals("d"))){
                System.out.println("Try again typing either d or p");
                System.out.println(move);
            }
            else{
                chosen = true;
            }
            }
            
        
        if(move.equals("p")){
            return MoveType.PASS;
        }
        else{
            return MoveType.DISCARD;
        }
    }
    @Override
    public DiscardMove discard() {
        scanner = new Scanner(System.in);
        String card="";
        String pile ="";
        int pileo = 0;
        int cardo = 0;
        boolean right = false;
        while(right == false){
            System.out.print("Card Number ");
            card = scanner.nextLine();
            try{
                cardo = Integer.parseInt(card);
                right = true;
            }
            catch (NumberFormatException e){
                System.out.println("Please Enter Integer");
            }
        }
        right = false;
        while(right == false){
            System.out.print("Pile Number ");
            pile = scanner.nextLine();
            try{
                pileo = Integer.parseInt(pile);
                right = true;
            }
            catch (NumberFormatException e){
                System.out.println("Please Enter Integer");
            }
        }
        DiscardMove discardia = new DiscardMove(cardo, pileo-1);
        hand.remove(cardo);
        return discardia;

    }
    @Override
    public boolean deal(int card){
        return hand.deal(card);
    }
    @Override
    public boolean handIsFull(){
        return hand.isFull();
    }
    @Override
    public boolean handIsEmpty(){
        return hand.isEmpty();
    }
    @Override
    public boolean confirmGameOver(){
        scanner = new Scanner(System.in);
        String confirm="";
        System.out.print("Confirm Game Over with 'y' ");
        if(scanner.hasNextLine()){
        confirm = scanner.nextLine();}
        if(confirm.equals("y")){
            scanner.close();
            return true;
        }
        else{
            return false;
        }
    }
    @Override
    public String toString(){
        return "Human: "+hand;
    }
}