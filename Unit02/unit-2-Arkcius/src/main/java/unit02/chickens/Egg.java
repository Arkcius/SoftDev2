package unit02.chickens;

public class Egg{
    private Color color;
    private Size size;
    private boolean cracked;

    public Egg(Color color, Size size){
        this.color = color;
        this.size = size;
        this.cracked = false;
    }

    public void crack(){
        this.cracked = true;
    }
    public boolean isCracked(){return this.cracked;}

    @Override
    public String toString(){
        if(this.cracked == false ){
            return "An uncracked "+ this.size+" ("+this.size.getOZ()+")"+" "+this.color+" egg";
        } 
        else{
            return "A cracked "+ this.size+" ("+this.size.getOZ()+")"+" "+this.color+" egg";
        }
    }
    @Override
    public boolean equals(Object obj){
        Egg other = (Egg) (obj);
        if(obj instanceof Egg){
            return ((this.size==other.size)&&(this.color==other.color)&&(this.cracked==other.cracked));
        }
        else{ 
            return false;
        }
    } 
}
