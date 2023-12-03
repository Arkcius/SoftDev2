package unit11.practicum;

import java.util.Scanner;

public class SequentialCount implements Runnable{
    private int end;
    private int cur;

    public SequentialCount(int end){
        this.end = end;
        this.cur = 1;
    }

    @Override
    public void run(){
        Thread[] count = new Thread[end];
        for(int i = 1;i<=end;i++){
            count[i-1]= new Thread(new Runnable() {
                @Override
                public void run(){
                System.out.println(cur);}
            });
            try {
                count[i-1].start();
                count[i-1].join();
            } catch (InterruptedException e) {
            }
            cur+=1;
        }
    }

    public static void main(String[] args){
        System.out.print("Enter int: ");
        Scanner scan = new Scanner(System.in);
        int endo = scan.nextInt();
        scan.close();
        Thread testo = new Thread(new SequentialCount(endo));
        testo.start();
    }
}
