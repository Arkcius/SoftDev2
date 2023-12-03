package unit10.concurrency;

import java.util.Scanner;

public class AnonymousCounters {
    public static void counter(String name){
        for(int i=1;i<101;i++){
            System.out.println(name +":"+i);
        }
    }

    public static void main(String[] args){
        System.out.println("Enter int");
        Scanner scan = new Scanner(System.in);
        int in = scan.nextInt();
        scan.close();

        for(int i=0; i<in;i++){
            Thread counThread = null;
            String name = "Counter "+i;
            if(i%2==0){
                counThread = new Thread(new Runnable(){
                    public void run(){
                        counter(name);
                    }
                });
            }
        }
    }
}
