package unit11.ggg;

import java.util.Random;

public class TurnipDropper implements Runnable{
    private Trough trough;

    public TurnipDropper(Trough trough){
        this.trough = trough;
    }

    protected boolean keepDropping(){
        synchronized(trough){
            return(!trough.atLimit());
        }
    }

    protected void dropTurnips(){
        Random RNG = new Random();
        int num = RNG.nextInt(1,4);
        synchronized(trough){
            for(int i =0; i<num;i++){
                trough.drop();
                System.out.println("Drop Turnip");
            }
            trough.notifyAll();
        }
    }

    @Override
    public void run(){
        while(keepDropping()){
            dropTurnips();
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {}
        }
    }
}
