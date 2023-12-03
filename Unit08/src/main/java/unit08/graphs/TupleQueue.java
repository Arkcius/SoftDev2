package unit08.graphs;

import java.util.ArrayList;

import unit08.ds.Queue;

public class TupleQueue<E> implements Queue<PathTuple<E>> {
    private ArrayList<PathTuple<E>> queue;

    public TupleQueue(){
        this.queue = new ArrayList<>();
    }

    public void enqueue(PathTuple<E> element){
        queue.add(element);
    }
    public int size(){return queue.size();}
    public PathTuple<E> dequeue(){
        PathTuple<E> ret = null;
        for(PathTuple<E> low : queue){
            if(ret==null){ret=low;}
            if(low.getDistance()<ret.getDistance()){
                ret = low;
            }
        }
        queue.remove(ret);
        return ret;
    }
}
