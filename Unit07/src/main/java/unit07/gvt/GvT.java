package unit07.gvt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import unit07.graphs.Vertex;

public class GvT {
    private AdjacencyGraph<Cell> graphs;
    private HashSet<Cell> trollCells;
    private static Cell[][] cells;
    private int ROWS;
    private int COLS;

    public GvT(String filename) throws IOException{
        try{
            FileReader fread = new FileReader(filename);
            BufferedReader bread = new BufferedReader(fread);
            AdjacencyGraph<Cell> graph = new AdjacencyGraph<>();
            String[] token = bread.readLine().split(" ");
            ROWS =  Integer.parseInt(token[0]);
            COLS = Integer.parseInt(token[1]);
            cells = new Cell[ROWS][COLS];
            String line = null;
            int row = 0;
            this.trollCells = new HashSet<>();
            while((line=bread.readLine())!=null){
                String[] tokens = line.split(" ");
                for(int col =0; col<tokens.length;col++){
                    char ch = tokens[col].charAt(0);
                    if(ch=='T'){
                        cells[row][col] = new Cell(row, col, true);
                        trollCells.add(cells[row][col]);
                    }
                    else{
                        cells[row][col]=new Cell(row, col, false);
                    }
                    graph.add(cells[row][col]);
                    if(col>0){
                        graph.connectUndirected(cells[row][col-1], cells[row][col]);
                    }
                    if(row>0){
                        graph.connectUndirected(cells[row-1][col], cells[row][col]);
                    }
                }
                row++;
            }
            bread.close();
            fread.close();
            this.graphs = graph;
    }
    catch (FileNotFoundException e){
        System.out.println("File not Found at "+filename);
    }
    }

    public List<Cell> dfPathMage(){
        Vertex<Cell> st = graphs.vertices.get(cells[0][0]);
        Vertex<Cell> ed = graphs.vertices.get(cells[ROWS-1][COLS-1]);
        Set<Vertex<Cell>> visited = new HashSet<>();
        visited.add(st);
        for (Cell trol : trollCells){
            visited.add(graphs.getVertex(trol));
        }
        return graphs.visitDFPath(st,ed,visited);
    }

    public List<Cell> dfPathFighter(){
        Vertex<Cell> st = graphs.vertices.get(cells[0][0]);
        Vertex<Cell> ed = graphs.vertices.get(cells[ROWS-1][COLS-1]);
        List<Cell> ret = null;
        for(Cell trol : trollCells){
            Set<Vertex<Cell>> visited = new HashSet<>();
            visited.add(st);
            for(Cell adder : trollCells){
                if(adder!=trol){visited.add(graphs.getVertex(adder));}
            }
            ret = graphs.visitDFPath(st,ed,visited);
            if(ret!=null){
                break;
            }
            }
        return ret;
    }

    public static void main(String[] args) throws IOException{
        GvT gvt = new GvT("unit-7-Arkcius/data/dfs/graph2_mage.txt");
        List<Cell> path = gvt.dfPathMage();
        System.out.print("[");
        for(Cell ele : path){
            System.out.print(ele+", ");
        }
        System.out.println("]");
        GvT gvt2 = new GvT("unit-7-Arkcius/data/dfs/graph3_fighter.txt");
        path = gvt2.dfPathFighter();
        System.out.print("[");
        for(Cell ele : path){
            System.out.print(ele+", ");
        }
        System.out.println("]");
    }
}

