package unit04.practicum;

public abstract class Fighter{
    private String name;
    private int health;

    public Fighter(String name,int health){
        this.health = health;
        this.name = name;
    }
    public int getHealth(){return this.health;}
    public void setHeatlh(int neww){this.health = neww;}
    public String getName(){return this.name;}
    public boolean isConscious(){
        return health>0;
    }
    public abstract int attack();
    public abstract void damage(int attack);

}
