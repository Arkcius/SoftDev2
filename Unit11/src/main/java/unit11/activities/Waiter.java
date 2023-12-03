package unit11.activities;

public class Waiter implements Runnable{
    private Object lock;

    public Waiter(Object lock){
        this.lock = lock;
    }

    public void run(){
        synchronized(lock){
            try{
                lock.wait();
                System.out.println("Running");
            }
            catch(InterruptedException e){};
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Object l = new Object();
        for(int i =0;i<10;i++){
        Waiter lock = new Waiter(l);
        Thread t = new Thread(lock);
        t.start();}
        Thread.sleep(1000);
        synchronized(l){
            l.notifyAll();
        }
        System.out.println("Start");
        
    }
}
