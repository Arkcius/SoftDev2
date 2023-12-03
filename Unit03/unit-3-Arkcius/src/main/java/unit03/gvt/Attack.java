package unit03.gvt;
public class Attack{
    private final String name;
    private final int[] hits;
    private final DamageType damageType;

    public Attack(String name, int[] hits, DamageType damageType){
        this.name = name;
        this.hits = hits;
        this.damageType = damageType;
    }

    public String getName(){return this.name;}
    public int[] getHits(){return this.hits;}
    public DamageType getDamageType(){return this.damageType;}

    @Override
    public String toString(){
        return this.name+" hits "+this.hits+" times with "+this.damageType+" damage";
    }
}