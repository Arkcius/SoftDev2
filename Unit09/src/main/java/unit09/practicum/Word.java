package unit09.practicum;

import unit09.graphs.WAdjacencyGraph;
import unit09.graphs.WPath;

public class Word {
    public static WAdjacencyGraph<String> makeWordGraph(){
        WAdjacencyGraph<String> graph = new WAdjacencyGraph<>();
        graph.add("H");
        graph.add("A");
        graph.add("P");
        graph.add("p");
        graph.add("Y");
        graph.add("S");

        graph.connect("H", "A", 1.0);
        graph.connect("A", "P", 1.0);
        graph.connect("P", "p", 1.0);
        graph.connect("p", "Y", 1.0);
        graph.connect("Y", "S", 1.0);
        graph.connect("S", "H", 100.0);

        graph.connect("H", "P", 100.0);
        graph.connect("A", "p", 100.0);
        graph.connect("P", "Y", 100.0);
        graph.connect("p", "S", 100.0);
        graph.connect("Y", "H", 100.0);
        graph.connect("S", "A", 100.0);

        graph.connect("H", "p", 100.0);
        graph.connect("A", "Y", 100.0);
        graph.connect("P", "S", 100.0);
        graph.connect("p", "H", 100.0);
        graph.connect("Y", "A", 100.0);
        graph.connect("S", "P", 100.0);

        graph.connect("H", "Y", 100.0);
        graph.connect("A", "S", 100.0);
        graph.connect("P", "H", 100.0);
        graph.connect("p", "A", 100.0);
        graph.connect("Y", "P", 100.0);
        graph.connect("S", "p", 100.0);

        return graph;
    }

    public static void main(String[] args){
        WAdjacencyGraph<String> graph = makeWordGraph();
        WPath<String> word = graph.dijkstrasPath("H", "S");
        System.out.println(word);
    }
}
