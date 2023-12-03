package unit02.swb;
public class Weapon{
    private String name;
    private int damageValue;
    private DamageType damageType;

    public Weapon(String name, int damageValue, DamageType damageType){
        this.name = name;
        this.damageValue = damageValue;
        this.damageType = damageType;
    }

    public String getName() {return this.name;}
    public int getDamageColor() {return this.damageValue;}
    public DamageType getDamageType(){return this.damageType;}
    @Override
    public String toString(){
        return name+ ": "+damageType+" "+damageType.getColor() + ", Value = "+damageValue;
    }

    @Override
    public boolean equals(Object obj){
        Weapon other = (Weapon) (obj);
        if(obj instanceof Weapon){
            return (damageType==other.damageType);
        }
        else{ 
            return false;
        }
    }

}
