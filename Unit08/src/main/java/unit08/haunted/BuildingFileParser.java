package unit08.haunted;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;

public class BuildingFileParser {
    private Random RNG = new Random();
    private Collection<Area> safeAreas;
    private Collection<Area> exitAreas;
    private Collection<Area> hauntedAreas;
    private Map<Area,Collection<Area>> passages;
    
    public BuildingFileParser(String filename)throws IOException{
        FileReader file = new FileReader("unit-8-Arkcius/"+filename);
        BufferedReader bread = new BufferedReader(file);
        Map<String,Area> allAreas = new HashMap<>();
        String[] token = bread.readLine().split(",");
        passages = new HashMap<>();
        while(token!=null){
            int index =0;
            Collection<Area> connected = new HashSet<>();
            Area mains = null;
            for(String ele : token){
                String[] ro = ele.split("-");
                if(allAreas.get(ro[0])==null){
                    AreaType type = null;
                    if(ro[1].equals("EXIT")){type = AreaType.EXIT;}
                    else if(ro[1].equals("HALLWAY")){type = AreaType.HALLWAY;}
                    else{type = AreaType.ROOM;}
                    Area room = new Area(ro[0], type);
                    if(type!=AreaType.EXIT){
                    room.haunt(EvilPresenceUtil.getRandomPresence());}
                    allAreas.put(ro[0], room);
                }
                if(index!=0){
                    connected.add(allAreas.get(ro[0]));
                }
                else{
                    mains = allAreas.get(ro[0]);
                }
                index++;
            }
            passages.put(mains, connected);
            try{
            token = bread.readLine().split(",");}
            catch(NullPointerException e){
                break;
            }
        }
        bread.close();
        file.close();
        safeAreas = new HashSet<>();
        exitAreas = new HashSet<>();
        hauntedAreas = new HashSet<>();
        for(String roo : allAreas.keySet()){
            Area room = allAreas.get(roo);
            if(room.getType()==AreaType.EXIT){
                exitAreas.add(allAreas.get(roo));
            }
            else if(room.isHaunted()==false){
                hauntedAreas.add(allAreas.get(roo));
            }
            else{
                safeAreas.add(allAreas.get(roo));
            }
        }
    }

    public Collection<Area> getSafeAreas(){return this.safeAreas;}
    public Collection<Area> getExitAreas(){return this.exitAreas;}
    public Collection<Area> getHauntedAreas(){return this.hauntedAreas;}
    public Area getStartArea(){
        int ran = RNG.nextInt(safeAreas.size());
        Object[] ret = safeAreas.toArray();
        return (Area) ret[ran];
    }
    public Map<Area,Collection<Area>> getPassages(){return this.passages;}
}
