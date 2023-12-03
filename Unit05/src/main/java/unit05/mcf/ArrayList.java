package unit05.mcf;
import java.util.Arrays;
import java.util.Iterator;

public class ArrayList<E> implements List<E> {
    private Object[] elements;
    private int size;

    public ArrayList(){
        this.size = 0;
        this.elements = new Object[2];
    }

    public ArrayList(List<E> list){
        this.size =0;
        Object[] ob = new Object[1];
        for(E elem: list){
            ob[size]=(elem);
            size++;
        }
        this.elements = ob;
    }

    @Override
    public void append(E value){
        if(size==elements.length){
            elements = Arrays.copyOf(elements, size+5);
        }
        elements[size]=value;
        size++;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E get(int index){
        return (E) elements[index];
    }
    @Override
    public void set(int index, E value){
        elements[index]=value;
    }
    @Override
    public int size(){
        return this.size;
    }

    @Override
    public String toString(){
        return(this.size + ", "+ Arrays.toString(this.elements));
    }

    @Override
    @SuppressWarnings("unchecked")
        public boolean equals(Object obj){
            ArrayList<E> other = (ArrayList<E>) (obj);
            if(obj instanceof ArrayList){
                if(this.size==other.size){
                    int i=0;
                    for(E elem : this){
                        if(elem!=other.get(i)){
                            return false;
                        }
                        i++;
                    }
                    return true;
                }
                else{return false;}
            }
            else{ 
                return false;
            }
        } 

    @Override
    public Iterator<E> iterator(){
        return new ArrayIterator<E>(elements, size);
    }

    public static void main(String[] args){
        ArrayList<String> listo = new ArrayList<>();
        listo.append("6");
        listo.append("9");
        System.out.println(listo);
        listo.append("7");
        listo.append("2");
        System.out.println(listo);
    }
}
