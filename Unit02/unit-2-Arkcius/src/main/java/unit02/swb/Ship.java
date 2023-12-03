package unit02.swb;
public class Ship{
    private String name;
    private int hullRating;
    private int shield;
    private Weapon weapon;

    public Ship(String name, int hullRating, int shield, Weapon weapon){
        this.name = name;
        this.hullRating = hullRating;
        this.shield = shield;
        this.weapon = weapon;
    }
    public Ship(String name, int hullRating){
        this(name,hullRating,10,new Weapon("Repeater",0,DamageType.NORMAL));
    }
    public String getName(){return this.name;}
    public int getHullRating(){return this.hullRating;}
    public int getShield(){return this.shield;}
    public Weapon getWeapon(){return this.weapon;}
    @Override
    public String toString(){
        return name+": Shield "+shield+", Hull "+hullRating;
    }

}
