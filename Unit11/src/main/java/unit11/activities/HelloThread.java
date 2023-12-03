package unit11.activities;

import java.util.ArrayList;
import java.util.List;

public class HelloThread implements Runnable{
    @Override
    public void run(){
        System.out.println("Hello World");
    }

    public static void main(String[] args) throws InterruptedException{
        List<Thread> threads = new ArrayList<>();
        for(int i =0; i<5;i++){
            Thread st = new Thread(new HelloThread());
            st.start();
            threads.add(st);
        }

        for(Thread th : threads){
            th.join();
        }  
        

    }
}
