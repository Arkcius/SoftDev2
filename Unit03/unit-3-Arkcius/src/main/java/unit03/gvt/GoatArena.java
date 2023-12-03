package unit03.gvt;

public class GoatArena{
    public static void Battle(Goat goat1,Goat goat2){
        int round = 1;
        while(goat1.isConscious()&&goat2.isConscious()){
            System.out.println();
            System.out.println("Round: "+round);
            System.out.println(goat1.getName()+" attacks "+goat2.getName());
            Attack goat1AT = goat1.attack();
            goat2.takeDamage(goat1AT);
            System.out.println(goat2.getName()+" attacks "+goat1.getName());
            Attack goat2AT = goat2.attack();
            goat1.takeDamage(goat2AT);
            System.out.println("End of round");
            System.out.println(goat1);
            System.out.println(goat2);
            round += 1;
        }
        if(goat1.isConscious()==false&&goat2.isConscious()==false){
            System.out.println("Both Goats Out\nDRAW");
        }
        else if(goat1.isConscious()==false){
            System.out.println(goat2.getName()+" WINS");
        }else if(goat2.isConscious()==false){
            System.out.println(goat1.getName()+" WINS");
        }
    }

    public static void main(String[] args){
        Mage aMage = new Mage("Bob");
        Fighter aFighter = new Fighter("Larry");
        Battle(aMage, aFighter);
    }
}
