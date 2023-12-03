package unit05.mcf;

public class Node<E> {
    private E value;
    private Node<E> next;

    public Node(E value){
        this.value = value;
        this.next=null;
    }
    public Node(E value,Node<E> next){
        this.value = value;
        this.next = next;
    }

    public E getValue(){return this.value;}
    public void setValue(E value){this.value=value;}
    public void setNext(Node<E> next){this.next=next;}
    public Node<E> getNext(){return this.next;}

}
