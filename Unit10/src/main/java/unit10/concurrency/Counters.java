package unit10.concurrency;

import java.util.Scanner;

public class Counters {
    public static void main(String[] args) throws InterruptedException{
        System.out.println("Enter int");
        Scanner scan = new Scanner(System.in);
        int in = scan.nextInt();
        scan.close();

        Thread[] counters = new Thread[in];
        for(int i=0;i<in;i++){
            Runnable counter = new RunnableCounter("Counter"+i);
            counters[i] = new Thread(counter);
            counters[i].start();
            counters[i].join();
        }
        /*for(int i=0;i<in;i++){
            counters[i].join();
        }*/
    }
}
