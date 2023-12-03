package unit07.graphs;

import java.util.List;

public interface Graph<E> {
    void add(E value);
    boolean contains(E value);
    int size();
    void connectDirected(E a, E b);
    void connectUndirected(E a, E b);
    boolean connected(E a, E b);

    public default boolean bfSearch(E start, E end){
        throw new UnsupportedOperationException("BFS Not Implemented");
    }

    public default List<E> bfPath(E start, E end){
        throw new UnsupportedOperationException("BFP Not Implemented");
    }

    public default boolean dfSearch(E start, E end){
        throw new UnsupportedOperationException("BFS Not Implemented");
    }

    public default List<E> dfPath(E start, E end){
        throw new UnsupportedOperationException("BFP Not Implemented");
    }
}
