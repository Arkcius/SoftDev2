package unit10.concurrency;

import java.util.ArrayList;
import java.util.List;

public class ListAdder implements Runnable {
    private List<Integer> sharedList;
    private int num;

    public ListAdder(List<Integer> shared, int num){
        this.sharedList=shared;
        this.num = num;
    }

    @Override
    public void run(){
        for(int i =0; i<num;i++){
            sharedList.add(i);
        }
    }

    public static void main(String[] args){
        List<Integer> li = new ArrayList<>();
        Thread[] threads = new Thread[100];
        for(int i =0; i<100; i++){
            threads[i] = new Thread(new ListAdder(li, 50));
            threads[i].start();
        }
    }
}
