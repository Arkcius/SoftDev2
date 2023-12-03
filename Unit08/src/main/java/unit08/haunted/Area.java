package unit08.haunted;

public class Area {
    private String name;
    private AreaType type;
    private String evilPresence;

    public Area(String name, AreaType type){
        this.name = name;
        this.type = type;
        this.evilPresence = null;
    }

    public String getName(){return this.name;}
    public AreaType getType(){return this.type;}
    public boolean isHaunted(){return this.evilPresence==null;}
    public void haunt(String evil){
        this.evilPresence=evil;
    }
    @Override
    public String toString(){
        if(evilPresence==null){
            return name+" ["+type+"]";
        }
        else{
            return name+" ["+type+"/"+evilPresence+"]";
        }
    }

    @Override
    public boolean equals(Object oth){
        Area other = (Area) oth;
        if(oth instanceof Area){
            return (this.name==other.name);
        }
        else{return false;}
    }

    @Override
    public int hashCode(){
        return this.name.hashCode();
    }
}
