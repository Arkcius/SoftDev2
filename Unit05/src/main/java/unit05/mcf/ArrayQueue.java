package unit05.mcf;

import java.util.Arrays;

public class ArrayQueue<E> implements Queue<E>{
    private Object[] elements;
    private int front;
    private int back;
    private int size;

    public ArrayQueue(){
        this.front = 0;
        this.back = 0;
        this.size = 0;
        this.elements = new Object[3];
    }

    public void enqueue(E value){
        elements[back]=value;
        back=(back+1)%elements.length;
        size +=1;
        
    }


    public int size(){return this.size;}
    @SuppressWarnings("unchecked")
    public E dequeue(){
        if(size==0){
            return null;
        }
        else{
        E ret = (E)elements[front];
        elements[front]=null;
        front = (front+1)%elements.length;
        size--;
        return ret;
        }
    }

    @Override
    public String toString(){
        return(this.size + ", "+ Arrays.toString(this.elements));
    }

    public static void main(String[] args){
        Queue<String> queue = new ArrayQueue<>();
        queue.enqueue("5");
        queue.enqueue("8");
        queue.enqueue("9");
        System.out.println(queue);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue("2");
        System.out.println(queue);
    }
}
