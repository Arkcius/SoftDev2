package unit07.graphs;

public class Graphs {
    public static AdjacencyGraph<String> makeGraph(){
        AdjacencyGraph<String> ret = new AdjacencyGraph<>();
        ret.add("A");
        ret.add("B");
        ret.add("C");
        ret.add("D");
        ret.add("E");
        ret.add("F");
        ret.add("G");
        ret.add("H");
        ret.add("I");
        ret.add("J");
        ret.add("K");

        ret.connectDirected("A", "C");
        ret.connectDirected("C", "H");
        ret.connectUndirected("A", "B");
        ret.connectUndirected("B", "E");
        ret.connectUndirected("E", "C");
        ret.connectDirected("D", "B");
        ret.connectUndirected("C","D");
        ret.connectDirected("E", "F");
        ret.connectUndirected("D", "F");
        ret.connectUndirected("F", "G");
        ret.connectUndirected("K", "I");
        ret.connectUndirected("J", "K");
        ret.connectDirected("J", "I");

        return ret;
    }
}
