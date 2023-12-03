package unit11.chevre;

public class Main {
    public static void main(String[] args){
        ClubChevre club = new ClubChevre();
        for(int i = 0;i<10;i++){
            Goat gt = new Goat(club);
            Thread st = new Thread(gt);
            st.start();
        }

        TrollBouncer troll = new TrollBouncer(club);
        new Thread(troll).start();

        System.out.println("There are "+club.numberOfGoatsInLine()+" in line");




    }
}
