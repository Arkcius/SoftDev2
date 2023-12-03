package unit08.haunted;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Scanner;

import unit08.graphs.*;

public class EscapeDA {
    public static WAdjacencyGraph<Area> buildGraph(Map<Area,Collection<Area>> passages){
        WAdjacencyGraph<Area> ret = new WAdjacencyGraph<>();
        for(Area room : passages.keySet()){
            ret.add(room);
        }
        double weight =0.0;
        for(Area room : passages.keySet()){
            for(Area ro : passages.get(room)){
                if(ro.isHaunted()==true){weight=100.0;}
                else{weight=1.0;}
                if(room.isHaunted()){weight=100.0;}
                ret.connect(room, ro, weight);
            }
        }
        return ret;
    }

    public static void main(String[] args) throws IOException{
        System.out.println("Enter filename: ");
        Scanner scan = new Scanner(System.in);
        String filename = scan.nextLine();
        scan.close();
        BuildingFileParser build = new BuildingFileParser(filename);
        WAdjacencyGraph<Area> graph = buildGraph(build.getPassages());
        Area start = build.getStartArea();
        System.out.println("You awake in the "+start+" and need to get out");
        System.out.println("\nHaunted Areas:");
        for(Area haunt : build.getHauntedAreas()){
            System.out.println("\t"+haunt);
        }
        System.out.println("Safe");
        for(Area haunt : build.getSafeAreas()){
            System.out.println("\t"+haunt);
        }
        System.out.println("Exit");
        for(Area haunt : build.getExitAreas()){
            System.out.println("\t"+haunt);
        }
        WPath<Area> mainPath = null;
        for(Area exit : build.getExitAreas()){
            WPath<Area> path = graph.dijkstrasPath(start, exit);
            if(mainPath==null){
                mainPath=path;
            }
            else if(path.distance()<mainPath.distance()){
                mainPath=path;
            }
        }
        if(mainPath.distance()<100){
            System.out.println("You escape through "+mainPath);
        }
        else{System.out.println("There is no escape");}
    }
}
