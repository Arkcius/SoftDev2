package unit05.mcf;

import java.util.Iterator;

public class NodeQueue<E> implements Queue<E> {
    private Node<E> front;
    private Node<E> back;
    private int size;

    public NodeQueue(){
        this.front = null;
        this.back = null;
        this.size = 0;
    }

    public void enqueue(E value){
        Node<E> neww = new Node<E>(value);
        if(front==null){
            front = neww;
            back = neww;
        }
        else{
        back.setNext(neww);
        back = neww;
    }
        size+=1;
    }

    public int size(){return this.size;}

    public E dequeue(){
        E ret = front.getValue();
        front = front.getNext();
        if(front==null){
            back=null;
        }
        size-=1;
        return ret;
    }

    @Override
    public String toString(){
        try{
        String ret = front.getValue()+"--> ";
        Node<E> next = front.getNext();
        while(next.getNext()!=null){
            ret+= next.getValue()+"--> ";
            next = next.getNext();
        }
        ret+=back.getValue();
        return ret;
    }
    catch (NullPointerException e){
        return "Queue is Empty";
    }
    }

    @Override
    public Iterator<E> iterator(){
        return new NodeIterator<>(front);
    }

    public static void main(String[] args){
        NodeQueue<String> queue = new NodeQueue<>();
        queue.enqueue("5");
        queue.enqueue("4");
        queue.enqueue("6");
        queue.enqueue("8");
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
        System.out.println(queue.size());
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue);
        System.out.println(queue.front);

    }

}
