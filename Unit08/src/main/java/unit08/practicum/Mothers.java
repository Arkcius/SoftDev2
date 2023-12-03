package unit08.practicum;

import java.util.LinkedList;
import java.util.List;

import unit08.graphs.AdjacencyGraph;

public class Mothers{
    public static List<String> findMothers(AdjacencyGraph<String> gra, List<String> values){
        List<String> ret = new LinkedList<>();
        for(String val : values){
            boolean mother = true;
            for(String oth : values){
                if(oth!=val){
                    if(gra.bfSearch(val, oth)==false){
                        mother = false;
                    }
                }
            }
            if(mother == true){
                ret.add(val);
            }
        }
        return ret;
    }


    public static void main(String[] args){
        AdjacencyGraph<String> test1 = new AdjacencyGraph<>();
        test1.add("A");
        test1.add("B");
        test1.add("C");
        test1.add("D");
        test1.add("E");
        List<String> testl = new LinkedList<>();
        testl.add("A");
        testl.add("B");
        testl.add("C");
        testl.add("D");
        testl.add("E");
        
        test1.connectDirected("A", "B");
        test1.connectDirected("B", "C");
        test1.connectDirected("C", "D");
        test1.connectDirected("B", "E");
        test1.connectDirected("E", "A");

        List<String> pr1 = findMothers(test1,testl);
        System.out.println(pr1.toString());

        //Starting second graph

        AdjacencyGraph<String> test2 = new AdjacencyGraph<>();
        test2.add("X");
        test2.add("T");
        test2.add("V");
        test2.add("W");
        test2.add("Y");
        test2.add("U");
        test2.add("Z");
        List<String> testk = new LinkedList<>();
        testk.add("X");
        testk.add("T");
        testk.add("V");
        testk.add("W");
        testk.add("Y");
        testk.add("U");
        testk.add("Z");
        
        test2.connectDirected("Z", "Y");
        test2.connectDirected("Z", "U");
        test2.connectDirected("X", "U");
        test2.connectDirected("X", "T");
        test2.connectDirected("Y", "X");
        test2.connectDirected("T", "V");
        test2.connectDirected("W", "T");
        test2.connectDirected("Y", "W");

        List<String> pr2 = findMothers(test2,testk);
        System.out.println(pr2.toString());
    }
}