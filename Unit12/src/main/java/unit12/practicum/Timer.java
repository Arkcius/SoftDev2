package unit12.practicum;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Timer implements Runnable{
    private String name;
    private List<Integer> li;
    private int numov;

public Timer(String name, List<Integer> li, int numov){
    this.name = name;
    this.li = li;
    this.numov = numov;
   }

public void run(){
 long cur = System.nanoTime();
    for(int i = 0; i<numov;i++){
        li.add(i);
    }
    long end = System.nanoTime();

    System.out.println("Filled "+name+" with "+numov+" in "+(end-cur)+" nanoseconds");

}
//The vector runs faster atleast with the smaller numbers
//whereas the arraylist runs faster with larger numbers
//this may have to do with when arraylist runs out of space it increments
//only 50% or also because arraylist isnt syncronized it can run faster
//when multiple threads are going such as here whereas 
//vector is synchronized and also is not multi thread safe
public static void main(String[] args) throws InterruptedException{
    Thread t1 = new Thread(new Timer("Array", new ArrayList<>(), 1000000));
    t1.start();
    Thread t2 = new Thread(new Timer("Vector",new Vector<>(),1000000));
    t2.start();
    t2.join();
}

}