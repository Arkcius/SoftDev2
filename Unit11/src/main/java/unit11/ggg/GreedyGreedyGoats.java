package unit11.ggg;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GreedyGreedyGoats {
    private static final int TurnipLimit=200;
    public static void main(String[] args){
        Trough trough = new Trough(TurnipLimit);
        TurnipDropper td = new TurnipDropper(trough);
        Thread tds = new Thread(td);
        tds.start();
        Goat gt1 = new Goat(Color.CYAN, trough);
        new Thread(gt1).start();
        Goat gt2 = new Goat(Color.GREEN, trough);
        new Thread(gt2).start();
        Goat gt3 = new Goat(Color.ORANGE, trough);
        new Thread(gt3).start();
        Goat gt4 = new Goat(Color.YELLOW, trough);
        new Thread(gt4).start();


        while(tds.isAlive()){
            if(trough.atLimit()&&trough.isEmpty()){
                System.out.println("Turnips Dropped: "+trough.getTurnipsSoFar());
                List<Goat> goats = new ArrayList<>();
                goats.add(gt1); 
                goats.add(gt2);
                goats.add(gt3);
                goats.add(gt4);
                goats.sort(new Comparator<Goat>() {
                    public int compare(Goat a, Goat b){
                        return a.getTurnipsEaten()-b.getTurnipsEaten();
                    }
                });
                int sum = 0;
                for(Goat g : goats){
                    System.out.println(g+" Ate: "+g.getTurnipsEaten());
                    sum += g.getTurnipsEaten();
                }
                System.out.println("In Total Ate "+sum+" Turnips");
                System.exit(0);
                break;
            }
        }


    }
}
