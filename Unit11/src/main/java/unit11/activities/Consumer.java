package unit11.activities;

import java.util.LinkedList;

public class Consumer implements Runnable{
    private LinkedList<String> queue;
    private int id;

    public Consumer(LinkedList<String> queue, int id){
        this.queue = queue;
        this.id = id;
    }

    @Override
    public void run(){
        synchronized(queue){
        while(true){
            while(!queue.isEmpty()){
                String cur = queue.removeFirst();
                System.out.println(id+": "+cur);
            }
            try{
                
                System.out.println("waiting");
                queue.wait();
            }
            catch(InterruptedException e ){}
    
        }}
    }



    public static void main(String[] args){
        LinkedList<String> queue = new LinkedList<>();
        queue.add("Hello");
        queue.add("Goodbye");
        Thread t = new Thread(new Consumer(queue, 125));
        t.start();
    }
}
