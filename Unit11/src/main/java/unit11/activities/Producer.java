package unit11.activities;

import java.util.LinkedList;
import java.util.Random;

public class Producer implements Runnable{
    private LinkedList<String> queue;
    private int id;

    public Producer(LinkedList<String> queue, int id){
        this.queue = queue;
        this.id = id;
    }

    @Override
    public void run(){
        while(true){
            try{
            Thread.sleep(1000);
            }
            catch(InterruptedException e){}
            Random RNG = new Random();
            int r = RNG.nextInt(4)+1;
            synchronized(queue){
            for(int i =0;i<r;i++){
                String message = "String "+ id+" number "+ i;
                queue.add(message);
            }
            queue.notifyAll();}
        }
    }

    public static void main(String[] args){
        LinkedList<String> queue = new LinkedList<>();
        for(int i =0;i<5;i++){
        Thread con = new Thread(new Consumer(queue, 1));
        con.start();}
        for(int i =0; i<2;i++){
        Thread pro = new Thread(new Producer(queue, 1));
        pro.start();}
    }
}
