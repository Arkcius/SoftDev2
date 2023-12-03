package unit07;

import java.util.List;

import unit07.graphs.*;

public class AdjacencyGraphSTv2<E> {
    private AdjacencyGraph<E> graph;
    private E s;
    private E t;

    @SuppressWarnings("unchecked")
    public AdjacencyGraphSTv2(AdjacencyGraph<E> graph, E[] S, E[] T){
        this.graph = graph;
        this.s = (E) "s";
        this.t = (E) "t";
        graph.add(s);
        graph.add(t);
        for(E ele : S){
            if(ele==null){break;}
            graph.connectDirected(s, ele);
        }
        for(E ele : T){
            if(ele==null){break;}
            graph.connectDirected(ele, t);
        }
    }

    public boolean bfSearch(){
        boolean ret = false;
        try{ret = graph.bfSearch(s, t);}
        catch(NullPointerException e){}
        return ret;
    }
    public List<E> bfPath(){
        List<E> ret = graph.bfPath(s, t);
        if(ret!=null){
        ret.remove(0);
        ret.remove(ret.size()-1);}
        return ret;
    }
}
