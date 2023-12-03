package unit07.practicum;

public class HeapPQ<E> implements Queue<Integer> {
    private ArrayHeap aray;

    public HeapPQ(){
        this.aray = new ArrayHeap();
    }

    public void enqueue(Integer value){
        aray.add(value);
    }

    public Integer dequeue(){
        return aray.remove();
    }

    public int size(){
        return aray.size();
    }
}
