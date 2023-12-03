package unit04.practicum;

public class Battle{
    public static void main(String[] args){
        Mario mar = new Mario("Mario", 100);
        Lonk lon = new Lonk("Link", 150);
        battler(mar,lon);
    }

    public static void battler(Fighter one, Fighter two){
        int round =1;
        while(one.isConscious()==true&&two.isConscious()==true){
            System.out.println(one+" Attacks "+two);
            two.damage(one.attack());
            System.out.println(two+" Attacks "+one);
            one.damage(two.attack());
            System.out.println(one +" Health: "+one.getHealth());
            System.out.println(two +" Health: "+two.getHealth());
            System.out.println("Round "+round+"\n");
            round += 1;
        }
        if(one.isConscious()==false){
            System.out.println(two+" Wins");
        }
        else if(two.isConscious()==false){
            System.out.println(one+" Wins");
        }
        else{
            System.out.println("DRAW");
        }
    }
}
