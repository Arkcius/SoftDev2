package unit07;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import unit07.graphs.AdjacencyGraph;

public class BFSMain {

    public static AdjacencyGraphST<String> makeAdjacencyGraphST(String filename) throws IOException{
        FileReader fread = new FileReader(filename);
        BufferedReader bread = new BufferedReader(fread);
        AdjacencyGraph<String> graph = new AdjacencyGraph<>();
        String st = bread.readLine();
        String[] token = st.split(" ");
        String[] S = new String[200];
        int i=0;
        for(String s : token){
            graph.add(s);
            S[i] = s;
            i++;
        }
        String Ts = bread.readLine();
        token = Ts.split(" ");
        String[] T = new String[200];
        i=0;
        for(String t : token){
            graph.add(t);
            T[i] = t;
            i++;
        }
        String breaker = bread.readLine();
        while(breaker!=null){
            token = breaker.split(" ");
            String first = token[0];
            for(String ele : token){
                if(!graph.contains(ele)){
                    graph.add(ele);
                }
                if(ele!=first){
                    graph.connectDirected(first, ele);
                }
            }
            breaker = bread.readLine();
        }
        bread.close();
        fread.close();
        return new AdjacencyGraphST<>(graph, S, T);
    }

    public static AdjacencyGraphSTv2<String> makeAdjacencyGraphSTv2(String filename) throws IOException{
        FileReader fread = new FileReader(filename);
        BufferedReader bread = new BufferedReader(fread);
        AdjacencyGraph<String> graph = new AdjacencyGraph<>();
        String st = bread.readLine();
        String[] token = st.split(" ");
        String[] S = new String[200];
        int i=0;
        for(String s : token){
            graph.add(s);
            S[i] = s;
            i++;
        }
        String Ts = bread.readLine();
        token = Ts.split(" ");
        String[] T = new String[200];
        i=0;
        for(String t : token){
            graph.add(t);
            T[i] = t;
            i++;
        }
        String breaker = bread.readLine();
        while(breaker!=null){
            token = breaker.split(" ");
            String first = token[0];
            for(String ele : token){
                if(!graph.contains(ele)){
                    graph.add(ele);
                }
                if(ele!=first){
                    graph.connectDirected(first, ele);
                }
            }
            breaker = bread.readLine();
        }
        bread.close();
        fread.close();
        return new AdjacencyGraphSTv2<>(graph, S, T);
    }

    public static void main(String[] args) throws IOException{
        /* 
        AdjacencyGraphST<String> Grap = makeAdjacencyGraphST("unit-7-Arkcius/data/bfs/graph1.txt");
        System.out.println(Grap.bfPath());
        Grap = makeAdjacencyGraphST("unit-7-Arkcius/data/bfs/graph2.txt");
        System.out.println(Grap.bfPath());
        Grap = makeAdjacencyGraphST("unit-7-Arkcius/data/bfs/graph3.txt");
        System.out.println(Grap.bfPath());
        Grap = makeAdjacencyGraphST("unit-7-Arkcius/data/bfs/graph4.txt");
        System.out.println(Grap.bfPath());
        Grap = makeAdjacencyGraphST("unit-7-Arkcius/data/bfs/graph5.txt");
        System.out.println(Grap.bfPath());
        Grap = makeAdjacencyGraphST("unit-7-Arkcius/data/bfs/graph6.txt");
        System.out.println(Grap.bfPath());
        Grap = makeAdjacencyGraphST("unit-7-Arkcius/data/bfs/graph7.txt");
        System.out.println(Grap.bfPath());
        Grap = makeAdjacencyGraphST("unit-7-Arkcius/data/bfs/graph8.txt");
        System.out.println(Grap.bfPath());
        Grap = makeAdjacencyGraphST("unit-7-Arkcius/data/bfs/graph9.txt");
        System.out.println(Grap.bfPath());
        Grap = makeAdjacencyGraphST("unit-7-Arkcius/data/bfs/graph10.txt");
        System.out.println(Grap.bfPath());*/

        AdjacencyGraphSTv2<String> Gra = makeAdjacencyGraphSTv2("unit-7-Arkcius/data/bfs/graph1.txt");
        System.out.println(Gra.bfSearch());
        System.out.println(Gra.bfPath());
        Gra = makeAdjacencyGraphSTv2("unit-7-Arkcius/data/bfs/graph2.txt");
        System.out.println(Gra.bfPath());
        Gra = makeAdjacencyGraphSTv2("unit-7-Arkcius/data/bfs/graph3.txt");
        System.out.println(Gra.bfPath());
        Gra = makeAdjacencyGraphSTv2("unit-7-Arkcius/data/bfs/graph4.txt");
        System.out.println(Gra.bfPath());
        Gra = makeAdjacencyGraphSTv2("unit-7-Arkcius/data/bfs/graph5.txt");
        System.out.println(Gra.bfPath());
        Gra = makeAdjacencyGraphSTv2("unit-7-Arkcius/data/bfs/graph6.txt");
        System.out.println(Gra.bfPath());
        Gra = makeAdjacencyGraphSTv2("unit-7-Arkcius/data/bfs/graph7.txt");
        System.out.println(Gra.bfPath());
        Gra = makeAdjacencyGraphSTv2("unit-7-Arkcius/data/bfs/graph8.txt");
        System.out.println(Gra.bfPath());
        Gra = makeAdjacencyGraphSTv2("unit-7-Arkcius/data/bfs/graph9.txt");
        System.out.println(Gra.bfPath());
        Gra = makeAdjacencyGraphSTv2("unit-7-Arkcius/data/bfs/graph10.txt");
        System.out.println(Gra.bfPath());
    }
}
