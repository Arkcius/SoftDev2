package unit04.practicum;
import java.util.Random;

public class Mario extends Fighter{
    private Random RNG = new Random();
    public Mario(String name,int health){
        super(name, health);
    }

    public int attack(){
        return RNG.nextInt(25,51);
    }
    public void damage(int damage){
        int dodge = RNG.nextInt(0, 100);
        if(dodge>=25){
            this.setHeatlh(this.getHealth()-damage);
            if(this.getHealth()<0){
                this.setHeatlh(0);
            }
        }
        else{
            System.out.println(this.getName()+" Dodges");
        }
    }
    @Override
    public String toString(){
        return this.getName();
    }
}
