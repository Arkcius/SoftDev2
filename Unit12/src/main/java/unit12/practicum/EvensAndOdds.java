package unit12.practicum;

public class EvensAndOdds implements Runnable{
    public int start;
    public int end;
    public String lock;
    
    public EvensAndOdds(int start, int end,String lock){
        this.start = start;
        this.end = end;
        this.lock=lock;
    }

    public void run(){
        while(start<=end){
            synchronized(lock){
                System.out.println(start);
                start+=2;
                lock.notifyAll();
                try{lock.wait();}
            catch(InterruptedException e){}
            }
        }
        System.exit(0);
    }

    public static void main(String[] args){
        String lock = "lock";
        Thread t1 = new Thread (new EvensAndOdds(1, 99, lock));
        t1.start();
        Thread t2 = new Thread(new EvensAndOdds(2, 100, lock));
        t2.start();
    }
}
