package unit06.heaps;

import java.util.Arrays;

public class ArrayHeap implements Heap {
    private int[] aray;
    private int size;

    public ArrayHeap(){
        this.size = 0;
        this.aray = new int[3];
    }

    public void add(int value){
    if(size==aray.length){
        aray = Arrays.copyOf(aray, size*2);
    }
    aray[size]=value;
    int child=size;
    int parent = (child-1)/2;
    while(aray[parent]>aray[child]){
        swap(parent, child);
        child = parent;
        parent = (child-1)/2;
    }

    size++;
    }

    private void swap(int a, int b){
        if(a!=b){
            int temp = aray[a];
            aray[a] = aray[b];
            aray[b] = temp;
        }
    }

    public int size(){return this.size;}
    
    public int remove(){
        int temp = aray[0];
        size--;
        swap(0,size);
        aray[size]=0;

        int parent =0;

        while(parent<size){
            int left = parent *2+1;
            int right = left+1;
            int dest = parent;
            if(left<size){
                dest = left;
            }
            if(right<size && aray[right]<aray[left]){
                dest=right;
            }

            if(aray[dest]<aray[parent]){
                swap(dest,parent);
                parent = dest;
            }
            else{break;}


        }


        return temp;
    }

    @Override
    public String toString(){
        return Arrays.toString(aray)+", "+size;
    }

    public static void main(String[] args){
        Heap he = new ArrayHeap();
        he.add(5);
        he.add(4);
        he.add(3);
        he.add(2);
        he.add(1);
        he.remove();
        he.remove();
        System.out.println(he);
    }
}
