package unit07.gvt;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import unit07.graphs.Graph;
import unit07.graphs.Vertex;

public class AdjacencyGraph<E> implements Graph<E>{
    protected HashMap<E,Vertex<E>> vertices;
    
    public AdjacencyGraph(){
        this.vertices = new HashMap<>();
    }

    public void add(E value){
        Vertex<E> vert = new Vertex<>(value);
        vertices.put(value, vert);
    }

    public boolean contains(E value){
        return vertices.containsKey(value);
    }

    public int size(){
        return vertices.size();
    }

    public void connectDirected(E a,E b){
        vertices.get(a).connect(vertices.get(b));

    }

    public void connectUndirected(E a,E b){
        vertices.get(a).connect(vertices.get(b));
        vertices.get(b).connect(vertices.get(a));
    }

    public Vertex<E> getVertex(E value){
        Vertex<E> ret = vertices.get(value);
        return ret;
    }

    public boolean connected(E a,E b){
        return vertices.get(a).connected(vertices.get(b));
    }

    @Override
    public boolean bfSearch(E start, E end){
        Vertex<E> st = vertices.get(start);
        Vertex<E> en = vertices.get(end);

        Queue<Vertex<E>> queue = new LinkedList<>();
        Set<Vertex<E>> set = new HashSet<>();

        queue.add(st);
        set.add(st);

        while(queue.size()!=0){
            Vertex<E> v = queue.poll();
            if(v==en){
                return true;
            }
            else{
                    for (Vertex<E> n : v.getNeighbors()) {
                        if(!set.contains(n)){
                            set.add(n);
                            queue.add(n);
                        }
                    }
            }
        }

        return false;
    }

    @Override
    public List<E> bfPath(E start, E end){
        Vertex<E> st = vertices.get(start);
        Vertex<E> en = vertices.get(end);

        Queue<Vertex<E>> queue = new LinkedList<>();
        Map<Vertex<E>,Vertex<E>> pred = new HashMap<>();

        queue.add(st);
        pred.put(st,null);

        while(!queue.isEmpty()){
            Vertex<E> v = queue.poll();
            if(v==en){
                break;
            }
            else{
                for (Vertex<E> n : v.getNeighbors()) {
                    if(!pred.containsKey(n)){
                        queue.add(n);
                        pred.put(n, v);
                    }
                }
                
            }
        }
        return makePath(pred, en);
    }

    private List<E> makePath(Map<Vertex<E>,Vertex<E>> pred, Vertex<E> end){
        if(pred.containsKey(end)){
            List<E> path = new LinkedList<>();
            Vertex<E> cur = end;
            while(cur!=null){
                path.add(0,cur.getValue());
                cur = pred.get(cur);
            }
            return path;
        }
        else{
            return null;
        }
    }

    @Override
    public boolean dfSearch(E start, E end){
        Vertex<E> st = vertices.get(start);
        Vertex<E> ed = vertices.get(end);
        Set<Vertex<E>> visited = new HashSet<>();
        visited.add(st);
        visitDFS(st, visited);
        return visited.contains(ed);

    }

    private void visitDFS(Vertex<E> S, Set<Vertex<E>> visited){
        for(Vertex<E> N : S.getNeighbors()){
            if(!visited.contains(N)){
            visited.add(N);
            visitDFS(N, visited);}
        }
    }

    @Override public List<E> dfPath(E start, E end){
        Vertex<E> st = vertices.get(start);
        Vertex<E> ed = vertices.get(end);
        Set<Vertex<E>> visited = new HashSet<>();
        visited.add(st);
        return visitDFPath(st, ed, visited);
    }

    protected List<E> visitDFPath(Vertex<E> V, Vertex<E> E, Set<Vertex<E>> visited){
        if(V==E){
            List<E> lister = new LinkedList<>();
            lister.add(E.getValue());
            return lister;
        }
        else{
            for(Vertex<E> N : V.getNeighbors()){
                if(!visited.contains(N)){
                    visited.add(N);
                    List<E> lister = visitDFPath(N, E, visited);
                    if(lister!=null){
                        lister.add(0, V.getValue());
                        return lister;
                             }}
                }
            }
        return null;
        }
    }

