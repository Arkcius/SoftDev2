package unit07;
import java.util.List;

import unit07.graphs.*;

public class AdjacencyGraphST<E> {
    private AdjacencyGraph<E> graph;
    private E[] S;
    private E[] T;

    public AdjacencyGraphST(AdjacencyGraph<E> graph, E[] S, E[] T){
        this.graph = graph;
        this.S = S;
        this.T = T;
    }
    public AdjacencyGraph<E> getGraph(){return this.graph;}
    public boolean bfSearch(){
        boolean ret = false;
        for(E ele : S){
            for(E el: T){
                try{
                if(graph.bfSearch(ele, el)){
                    ret = true;
                }}
                catch(NullPointerException e){}
            }
        }
        return ret;
    }

    public List<E> bfPath(){
        List<E> re = null;
        for(E ele : S){
            for(E el: T){
                try{
                if(graph.bfSearch(ele, el)){
                    List<E> be = graph.bfPath(ele, el);
                    if(re==null&&be.size()>1){
                        re=be;}
                    if(be.size()<re.size()&&be.size()>1){
                        re = be;
                    }
                }}
                catch(NullPointerException e){}
            }
        }
        return re;
    }

}
