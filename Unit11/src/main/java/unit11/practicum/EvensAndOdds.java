package unit11.practicum;

public class EvensAndOdds implements Runnable{
    private int start;

    public EvensAndOdds(int start){
        this.start = start;
    }

    @Override
    public void run(){
        for(int i = start;i<=100;i+=2){
            try{
                Thread.sleep(500);}
                catch(InterruptedException e){}
            System.out.println(i);
        }
    }
    public static void main(String[] args){
        Thread odd = new Thread(new EvensAndOdds(1));
        odd.start();
        Thread even = new Thread(new EvensAndOdds(2));
        even.start();
    }

}