package unit05.mcf;

public class LinkedList<E> implements List<E>{
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public LinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int size(){return this.size;}
    
    public void append(E value){
        Node<E> neww = new Node<E>(value);
        if(size==0){
            head = neww;
            tail=neww;
            size++;
        }
        else{
            tail.setNext(neww);
            tail=neww;
            size++;
        }
    }

    public E get(int index){
        Node<E> nod = null;
        for(int i=0;i==index;i++){
            if(i==0){
            nod =head;}
            else{
                nod = nod.getNext();
            } 
        }
        return nod.getValue();
    }

    public void set(int index, E value){
        Node<E> nod = head;
        for(int i=0;i<=index;i++){
            if(i==0){
            nod =head;}
            else{
                nod = nod.getNext();
            } 
        }
        nod.setValue(value);
    }

    @Override
    public String toString(){
        String ret = head.getValue()+"--> ";
        Node<E> next = head.getNext();
        while(next.getNext()!=null){
            ret+= next.getValue()+"--> ";
            next = next.getNext();
        }
        ret+=tail.getValue();
        return ret;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj){
        LinkedList<E> other = (LinkedList<E>) (obj);
        if(obj instanceof LinkedList){
            if(this.size==other.size){
                Node<E> nod = other.head;
                Node<E> no = this.head;
                while(no!=this.tail){
                    if(nod.getValue()!=no.getValue()){
                        return false;
                    }
                    nod = nod.getNext();
                    no = no.getNext();
                }
                return true;
            }
            else{return false;}
        }
        else{ 
            return false;
        }
    } 

    public static void main(String[] args){
        LinkedList<String> lis = new LinkedList<>();
        lis.append("8");
        lis.append("10");
        lis.append("10");
        System.out.println(lis);

        LinkedList<String> li = new LinkedList<>();
        li.append("8");
        li.append("10");
        li.append("10");
        System.out.println(lis.equals(li));

        LinkedList<String> li2 = new LinkedList<>();
        li2.append("8");
        li2.append("9");
        li2.append("10");
        System.out.println(lis.equals(li2));

        lis.set(1, "9");
        System.out.println(lis);
        
    }

}
