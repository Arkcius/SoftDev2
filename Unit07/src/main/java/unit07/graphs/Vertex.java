package unit07.graphs;

import java.util.HashSet;

public class Vertex<E> {
    private E value;
    private HashSet<Vertex<E>> neighbors;
    
    public Vertex(E value){
        this.value = value;
        this.neighbors = new HashSet<>();
    }

    public E getValue(){return this.value;}

    public void connect(Vertex<E> n){
        neighbors.add(n);
    }

    public boolean connected(Vertex<E> n){
        return neighbors.contains(n);
    }

    public HashSet<Vertex<E>> getNeighbors(){
        return this.neighbors;
    }
}
