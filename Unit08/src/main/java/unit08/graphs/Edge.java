package unit08.graphs;


public class Edge<E> implements Comparable<Edge<E>>{
    private double weight;
    private WVertex<E> from;
    private WVertex<E> to;

    public Edge(WVertex<E> from, WVertex<E> to,double weight){
        this.weight = weight;
        this.from = from;
        this.to=to;
    }
    public double getWeight(){return this.weight;}
    public WVertex<E> getFrom(){return this.from;}
    public WVertex<E> getTo(){return this.to;}
    @Override
    public int compareTo(Edge<E> other){
        double ret = this.weight-other.getWeight();
        if(ret>0){return 1;}
        else if(ret<0){return -1;}
        else{return 0;}
    }
}
