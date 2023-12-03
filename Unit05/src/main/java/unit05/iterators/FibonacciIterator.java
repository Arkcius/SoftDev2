package unit05.iterators;

import java.util.ArrayList;
import java.util.Iterator;

public class FibonacciIterator implements Iterator<Long> {

    private ArrayList<Long> fibe;
    private int index;

    public FibonacciIterator(ArrayList<Long> fib){
        this.fibe = fib;
        this.index = 0;
    }
    @Override
    public boolean hasNext(){return index<fibe.size();}

    @Override
    public Long next(){
        Long ret = fibe.get(index);
        index++;
        return ret;
    }
}

