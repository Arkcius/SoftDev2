package unit03.gvt;

public class Trollzord extends Troll{
    private static final int MAXHP = 64;
    private static final double REGEN = 0.05;

    public Trollzord(String name){
        super(name,MAXHP,REGEN);
    }

    public  Attack attack(){
        int[] at = {25};
        return new Attack("Flame War",at,DamageType.MAGICAL);

    }
    public void takeDamage(Attack attack){
        double atMod = 1.0;
        DamageType type = attack.getDamageType();
        if(type == DamageType.HOLY){
            atMod = 1.25;
        for(int hit: attack.getHits()){
            int setter = (int)(super.getCurHp()-(hit*atMod));
            super.setCurHp(setter);
        }
        int cur = super.getCurHp()>0 ? super.getCurHp() : 0;
        super.setCurHp(cur);
    }
}
}
