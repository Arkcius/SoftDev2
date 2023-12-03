package unit02.chickens;
import java.util.Random;


public class Chicken{
    public static final Random RNG = new Random();
    public static final String[] NAMES = {"Bob","Billy", "Joe", "Sarah", "Emily", "Jimmy", "Jared", "Sam", "Kevin", "Terry"};
    public final Size[] SIZES = {Size.PEEWEE,Size.SMALL,Size.MEDIUM,Size.LARGE,Size.EXTRA_LARGE,Size.JUMBO};
    public final Color[] COLORS = {Color.BROWN,Color.WHITE};
    private Size size;
    private Color color;
    private String name;

    public Chicken(Size size, Color color, String name){
        this.size = size;
        this.color = color;
        this.name = name;
    }

    public Egg layEgg(){
        Egg eg = new Egg(this.color,this.size);
        return eg;
    }

    public Chicken randChicken(){
        int rand = RNG.nextInt(0,10);
        int rand1 = RNG.nextInt(0,2);
        int rand2 = RNG.nextInt(0,6);
        Chicken chick = new Chicken(SIZES[rand2], COLORS[rand1], NAMES[rand]);
        return chick;

    }

    @Override
    public String toString(){
        return name+" a chicken that lays "+this.size+" "+this.color+" eggs";
    }
    @Override
    public boolean equals(Object obj){
        Chicken other = (Chicken) (obj);
        if(obj instanceof Chicken){
            return (this.size==other.size);
        }
        else{ 
            return false;
        }
    } 
}
