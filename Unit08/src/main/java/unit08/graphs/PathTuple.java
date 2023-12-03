package unit08.graphs;

public class PathTuple<E> {
    private WVertex<E> vertex;
    private WVertex<E> predecessor;
    private double distance;

    public PathTuple(WVertex<E> vertex){
        this.vertex = vertex;
        this.predecessor = null;
        this.distance = Double.POSITIVE_INFINITY;
    }

    public WVertex<E> getVertex(){return this.vertex;}
    public double getDistance(){return this.distance;}
    public WVertex<E> getPredecessor(){return this.predecessor;}

    public void update(WVertex<E> pred,double dis){
        if(dis<this.distance){
            this.predecessor = pred;
            this.distance = dis;
        }
    }

    @Override
    public String toString(){
        return vertex + ":("+predecessor+", "+distance+")";
    }
}
