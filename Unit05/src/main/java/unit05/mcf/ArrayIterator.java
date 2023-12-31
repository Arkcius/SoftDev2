package unit05.mcf;

import java.util.Iterator;

public class ArrayIterator<E> implements Iterator<E>{
    private Object[] elements;
    private int index;
    private int size;

    public ArrayIterator(Object[] elements, int size){
        this.elements = elements;
        this.size = size;
    }
    @Override
    public boolean hasNext(){return index<size;}

    @Override
    @SuppressWarnings("unchecked")
    public E next(){
        E ret = (E) elements[index];
        index++;
        return ret;
    }
}
