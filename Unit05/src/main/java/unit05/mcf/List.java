package unit05.mcf;

import java.util.Iterator;

public interface List<E> extends Iterable<E>{
    void append(E value);
    E get(int Index);
    void set(int Index, E value);
    int size();

    default Iterator<E> iterator() throws UnsupportedOperationException{
        throw new UnsupportedOperationException("iterator not supported");
    }
}
