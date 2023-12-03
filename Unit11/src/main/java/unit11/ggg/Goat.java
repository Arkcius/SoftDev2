package unit11.ggg;

public class Goat implements Runnable{
    private Color color;
    private Trough trough;
    private int turnipsEaten;

    public Goat(Color color, Trough trough){
        this.color = color;
        this.trough = trough;
        this.turnipsEaten = 0;
    }

    public int getTurnipsEaten(){return this.turnipsEaten;}
    @Override
    public String toString(){
        return "The "+color+" goat";
    }

    protected boolean keepEating(){
        if(!trough.atLimit()){
            return true;
        }
        else if(!trough.isEmpty()){return true;}
        else{return false;}
    }

    protected void tryToEat(){
        synchronized(trough){
            if(trough.eat()){turnipsEaten++;}
            System.out.println(this.color + " Eats a turnip");
        }
    }

    protected void waitForTurnips() throws InterruptedException{
        synchronized(trough){
            //uncomment below line if you want it to print whenever its waiting I thought that made it look cluttered so i commented it out
            //System.out.println(color + " is Waiting");
            trough.wait();
        }
    }

    @Override
    public void run(){
        while(keepEating()){
            synchronized(trough){
                if(!trough.isEmpty()){
                    tryToEat();
                    trough.notifyAll();
                }}
                try {
                    waitForTurnips();
                } catch (InterruptedException e) {}
                
        }
    }
}
