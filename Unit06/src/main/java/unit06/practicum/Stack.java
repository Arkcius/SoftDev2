package unit06.practicum;


public interface Stack<E> extends Iterable<E>{
    public int size();
    public E top();
    public void push(E val);
    public E pop();

}