package unit05.mcf;

import java.util.Iterator;

public interface Queue<E> extends Iterable<E>{
    void enqueue(E value);
    E dequeue();
    int size();

    default Iterator<E> iterator() throws UnsupportedOperationException{
        throw new UnsupportedOperationException("Unsupport");
    }
}
