package unit05.iterators;

import java.util.ArrayList;
import java.util.Iterator;

public class IterableFibonacci implements Iterable<Long> {
    private ArrayList<Long> fib;
    
    public IterableFibonacci(long a, long b){
        fib = new ArrayList<>();
        fib.add(a);
        fib.add(b);
    }

    public int length(){return fib.size();}

    public long get(int i){
        return fib.get(i);
    }

    public void add(){
        long a = fib.get(length()-2);
        long b = fib.get(length()-1);
        fib.add(a+b);
    }

    @Override
    public String toString(){
        String ret = "[";
        for(long elements: fib){
            ret += elements;
            if(elements!=fib.get(fib.size()-1)){
            ret+=", ";}
        }
        ret+="]";
        return ret;
    }

    @Override
    public Iterator<Long> iterator(){
        return new FibonacciIterator(fib);
    }

    public static void main(String[] args){
        IterableFibonacci fib = new IterableFibonacci(2, 5);
        fib.add();
        fib.add();
        System.out.println(fib);
    }

}
