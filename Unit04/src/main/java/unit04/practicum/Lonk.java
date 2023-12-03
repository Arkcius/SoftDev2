package unit04.practicum;
import java.util.Random;

public class Lonk extends Fighter{
    private Random RNG = new Random();
    public Lonk(String name,int health){
        super(name, health);
    }

    public int attack(){
        return 45;
    }
    public void damage(int damage){
        int block = RNG.nextInt(0, 100);
        if(block>=50){
            this.setHeatlh(this.getHealth()-(damage/2));
            System.out.println(this.getName()+" Blocks");
        }
        else{
            this.setHeatlh(this.getHealth()-damage);
        }
        if(this.getHealth()<0){
            this.setHeatlh(0);
        }
    }
    @Override
    public String toString(){
        return this.getName();
    }
}