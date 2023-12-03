package unit03.gvt;

public abstract class Goat{
    private final String name;
    private final int maxHp;
    protected int curHp;

    public Goat(String name,int maxHp){
        this.name = name;
        this.maxHp = maxHp;
        this.curHp = maxHp;
    }
    public String getName(){return this.name;}
    public int getMaxHP(){return maxHp;}
    public int getCurHp(){return curHp;}
    public void setCurHp(int cur){this.curHp = cur;}
    
    @Override
    public String toString(){
        return "A goat named "+getName()+" with "+getCurHp()+"/"+getMaxHP()+" hit points";
    }

    public Attack attack(){
        int[] at = {10};
        return new Attack("Headbutt",at,DamageType.PHYSICAL);

    }
    public void takeDamage(Attack attack){
        double atMod = 1.0;
        for(int hit: attack.getHits()){
            curHp -=(hit*atMod);
        }
        curHp = curHp>0 ? curHp : 0;
    }

    public void heal(int he){
        curHp += he;
        curHp = curHp<maxHp ? curHp:maxHp;
    }

    public boolean isConscious(){
        return curHp>0;
    }

}