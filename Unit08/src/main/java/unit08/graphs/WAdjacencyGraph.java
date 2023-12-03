package unit08.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WAdjacencyGraph<E> implements WGraph<E>{
    private final Map<E, WVertex<E>> vertices;

    public WAdjacencyGraph(){
        vertices = new HashMap<>();
    }
    
    @Override
    public void add(E value){
        WVertex<E> vertex = new WVertex<E>(value);
        vertices.put(value,vertex);
    }

    @Override
    public boolean contains(E value){
        return vertices.containsKey(value);
    }

    @Override
    public int size(){
        return vertices.size();
    }

    @Override
    public void connect(E a, E b, double weight){
        WVertex<E> vertexA = vertices.get(a);
        WVertex<E> vertexB = vertices.get(b);
        vertexA.connect(vertexB, weight);
        vertexB.connect(vertexA, weight);

    
    }

    @Override
    public boolean connected(E a, E b){
        WVertex<E> vertexA = vertices.get(a);
        WVertex<E> vertexB = vertices.get(b);
        return vertexA.edge(vertexB)!=null;
    }

    @Override
    public double weight(E a, E b){
        WVertex<E> vertexA = vertices.get(a);
        WVertex<E> vertexB = vertices.get(b);
        return vertexA.edge(vertexB).getWeight();
    }
    @Override
    public WPath<E> nearestNeighbors(E start, E end) {
        WVertex<E> s = vertices.get(start);
        WVertex<E> e = vertices.get(end);

        Set<WVertex<E>> visited = new HashSet<>();
        visited.add(s);

        return visitNearestNeighbor(s, e, visited);
    }

    private WPath<E> visitNearestNeighbor(WVertex<E> v, WVertex<E> e, 
        Set<WVertex<E>> visited) {
        if(v == e) {
            WPath<E> path = new WPath<>(e.getValue());
            return path;
        } else {
            for(Edge<E> edge : v.edges()) {
                WVertex<E> neighbor = edge.getTo();
                if(!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    WPath<E> path = visitNearestNeighbor(neighbor, e, visited);
                    if(path != null) {
                        path.append(v.getValue(),edge.getWeight());
                        return path;
                    }
                }
            }
            return null;
        }
    }

    @Override
    public WPath<E> dijkstrasPath(E start, E end){
        WVertex<E> s = vertices.get(start);
        WVertex<E> e = vertices.get(end);
        Map<WVertex<E>,PathTuple<E>> map = new HashMap<>();
        TupleQueue<E> queue = new TupleQueue<>();
        for(E val : vertices.keySet()){
            WVertex<E> vertex = vertices.get(val);
            PathTuple<E> vert = new PathTuple<>(vertex);
            map.put(vertex, vert);
            queue.enqueue(vert);
        }
        map.get(s).update(s, 0);
        while(queue.size()>0){
            PathTuple<E> cur = queue.dequeue();
            if(cur.getDistance()==Double.POSITIVE_INFINITY){
                break;
            }
            else{
            WVertex<E> curv = cur.getVertex();
            for(Edge<E> edge: curv.edges()){
                WVertex<E> neighbor = edge.getTo();
                double dv = cur.getDistance()+curv.edge(neighbor).getWeight();
                PathTuple<E> neigh = map.get(neighbor);
                if(dv<neigh.getDistance()){
                    neigh.update(curv, dv);
                }
            }
        }
    }
    PathTuple<E> tuple = map.get(e);
    double distance = tuple.getDistance();
    if(distance==Double.POSITIVE_INFINITY){return null;}
    else{
        WPath<E> path = new WPath<E>(e.getValue());
        WVertex<E> v = tuple.getPredecessor();
        while(v!=null){
            path.prepend(v.getValue(), distance);
            distance = 0;
            tuple = map.get(v);
            v=tuple.getPredecessor();
        }
        return path;
    }
    }

    }


