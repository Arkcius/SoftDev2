package unit03.gvt;

public class Mage extends Goat{
    private static int maxHp = 125;

    public Mage(String name){
        super(name,maxHp);
    }
    @Override
    public Attack attack(){
        int[] at = {9,9,9,9};
        return new Attack("Magic Missle",at,DamageType.MAGICAL);

    }
    @Override
    public void takeDamage(Attack attack){
        double atMod = 1.0;
        DamageType type = attack.getDamageType();
        if(type == DamageType.MAGICAL){
            atMod = .75;
        } else if(type == DamageType.PHYSICAL){
            atMod = 1.25;
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
        return "A mage named "+super.getName()+" with "+super.getCurHp()+"/"+super.getMaxHP()+" hit points";
    }

    public static void main(String[] args){
        Mage bob = new Mage("Bob");
        Mage larry = new Mage("Larry");
        System.out.println(bob);
        System.out.println(larry);
        System.out.println();
        System.out.println(bob.getName()+" attacks "+larry.getName());
        Attack bobAt = bob.attack();
        larry.takeDamage(bobAt);
        System.out.println(larry);
    }
}
