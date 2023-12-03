package unit03.gvt;

public class Fighter extends Goat{
    private static int maxHp = 150;

    public Fighter(String name){
        super(name,maxHp);
    }
    @Override
    public Attack attack(){
        int[] at = {25};
        return new Attack("Cleave",at,DamageType.PHYSICAL);

    }
    @Override
    public void takeDamage(Attack attack){
        double atMod = 1.0;
        DamageType type = attack.getDamageType();
        if(type == DamageType.MAGICAL){
            atMod = 1.25;
        } else if(type == DamageType.PHYSICAL){
            atMod = .75;
        }
        for(int hit: attack.getHits()){
            int setter = (int)(super.getCurHp()-(hit*atMod));
            super.setCurHp(setter);
        }
        int cur = super.getCurHp()>0 ? super.getCurHp() : 0;
        super.setCurHp(cur);
    }

    @Override
    public String toString(){
        return "A fighter named "+super.getName()+" with "+super.getCurHp()+"/"+super.getMaxHP()+" hit points";
    }
    public static void main(String[] args){
        Fighter bob = new Fighter("Bob");
        Fighter larry = new Fighter("Larry");
        System.out.println(bob);
        System.out.println(larry);

        System.out.println();
        System.out.println(bob.getName()+" attacks "+larry.getName());
        Attack bobAt = bob.attack();
        larry.takeDamage(bobAt);
        System.out.println(larry);
        
        System.out.println();
        System.out.println(larry.getName()+" attacks "+bob.getName());
        Attack larryAt = larry.attack();
        bob.takeDamage(larryAt);
        System.out.println(bob);
    }
}