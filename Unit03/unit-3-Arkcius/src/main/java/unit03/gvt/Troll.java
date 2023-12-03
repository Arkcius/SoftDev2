package unit03.gvt;

public abstract class Troll{
    private final String name;
    private final int maxHp;
    protected int curHp;
    private final double regen;

    public Troll(String name,int maxHp,double regen){
        this.name = name;
        this.maxHp = maxHp;
        this.curHp = maxHp;
        this.regen = regen;
    }
    public String getName(){return this.name;}
    public int getMaxHP(){return maxHp;}
    public int getCurHp(){return curHp;}
    public double getRegen(){return regen;}
    public void setCurHp(int cur){this.curHp = cur;}
    
    @Override
    public String toString(){
        return "A troll named "+getName()+" with "+getCurHp()+"/"+getMaxHP()+" hit points";
    }

    public abstract Attack attack();
    public abstract void takeDamage(Attack attack);

    public void heal(int he){
        curHp += he;
        curHp = curHp<maxHp ? curHp:maxHp;
    }

    public boolean isConscious(){
        return curHp>0;
    }

    public void regen(){
        if(this.isConscious()==true){
            curHp += (int)(curHp*regen);
        }
    }

}