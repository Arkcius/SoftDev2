package unit08.haunted;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import unit08.backtracker.Backtracker;
import unit08.backtracker.Configuration;

public class EscapeBT implements Configuration<EscapeBT> {
    private Area[] path;
    private Area start;
    private BuildingFileParser build;

    public EscapeBT(Area start,BuildingFileParser build,Area[] path){
        this.start = start;
        this.path = path;
        path[0]=this.start;
        this.build = build;
    }
    public EscapeBT(BuildingFileParser build,Area[] path){
        this.start = path[0];
        this.path = path;
        this.build = build;
    }

    public Area[] getPath(){return this.path;}
    @Override
    public Collection<EscapeBT> getSuccessors() {
        List<EscapeBT> successors = new ArrayList<>();
        int length = path.length;
        for(Area neigh : build.getPassages().get(path[length-1])){
            Area[] copy = Arrays.copyOf(path, length+1);
            copy[length] = neigh;
            successors.add(new EscapeBT(build,copy));
        }
        return successors;
    }

    @Override
    public boolean isValid() {
        int length = path.length;
        if(length<2){return true;}
        else{
            Area last = path[length-1];
            if(last.isHaunted()==false){
                return false;
            }
            for(int i=0; i<path.length-2;i++){
                if(last.equals(path[i])){
                    return false;
            }
        }
            return true;
    }
}

    @Override
    public boolean isGoal() {
        return isValid()&& (path[path.length-1].getType()==AreaType.EXIT);
    }

    public Configuration<EscapeBT> solve(Configuration<EscapeBT> config){
        if(config.isGoal()){
            return config;
        }
        else{
            for(Configuration<EscapeBT> child: config.getSuccessors()){
                if(child.isValid()){
                    Configuration<EscapeBT> sol = solve(child);
                    if(sol!=null){
                        return sol;
                    }
                }
            }
        }
        return null;
    }
    


    public static void main(String[] args) throws IOException{
        System.out.println("Enter filename: ");
        Scanner scan = new Scanner(System.in);
        String filename = scan.nextLine();
        scan.close();
        BuildingFileParser build = new BuildingFileParser(filename);
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

        Area[] path = new Area[1];
        EscapeBT config = new EscapeBT(start, build, path);
        Backtracker<EscapeBT> backtracker = new Backtracker<>(false);
        EscapeBT sol = backtracker.solve(config);
        if(sol!=null){
            path = sol.getPath();
            System.out.println("You escaped Path:");
            String ret = "[";
            for(Area ele : path){
                if(ele!=path[path.length-1]){
                ret+= ele.toString()+", ";}
                else{
                    ret+= ele.toString()+"]";
                }
            }
            System.out.println(ret);

        }
        else{
            System.out.println("no Escape");
        }
    }
}
