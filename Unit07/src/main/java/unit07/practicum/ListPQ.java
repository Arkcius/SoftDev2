package unit07.practicum;

import java.util.LinkedList;

public class ListPQ<E> implements Queue<Integer> {
    private LinkedList<Integer> list;

    public ListPQ(){
        this.list = new LinkedList<>();
    }

    public void enqueue(Integer value){
        list.add(value);
    }

    public int size(){return list.size();}

    public Integer dequeue(){
        int current = 0;
        for(int i =0;i<list.size();i++){
            if(list.get(i)<list.get(current)){
                current=i;
            }
        }
        return list.remove(current);
    }
}
