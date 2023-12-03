package unit06.practicum;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayStack<E> implements Stack<E>{
    private Object[] elements;
    private int size;

    public ArrayStack(){
        this.elements = new Object[0];
        this.size=0;
    }

    public int size(){return this.size;}

    @SuppressWarnings("unchecked")
    public E top(){
        return (E) elements[0];
    }
    public void push(E value){
        size++;
        Object[] ele = new Object[size];
        ele[0]=value;
        int index = 1;
        for(Object el: elements){
            ele[index]=el;
            index++;
        }
        elements = ele;
    }
    @SuppressWarnings("unchecked")
    public E pop(){
        E ret = (E)elements[0];
        elements = Arrays.copyOfRange(elements,1,size);
        size--;
        return ret;

    }
    @Override
    public String toString(){
        return Arrays.toString(elements);
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<>(elements, size);
    }

    public static void main(String[] args){
        ArrayStack<String> ele = new ArrayStack<>();
        ele.push("1");
        ele.push("2");
        System.out.println(ele);
        ele.pop();
        System.out.println(ele);
        ele.push("3");
        ele.push("8");
        System.out.println(ele);
        for(String l: ele){
            System.out.println(l);
        }
    }

}
