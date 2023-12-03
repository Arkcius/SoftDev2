package unit11.chevre;

/**
 * A class that will ultimately represent a party Goat out for a night of
 * dancing at the world famous Club Chèvre.
 */
public class Goat implements Runnable{
    private String name;
    private int coolness ;
    private int stamina;
    private ClubChevre club;

    public Goat(ClubChevre club){
        this.club = club;
        this.name = Utils.makeGoatName();
        this.coolness = Utils.getRandomNumber(1, 100);
        this.stamina = Utils.getRandomNumber(5, 10);
    }

    public String getName(){return this.name;}


    @Override
    public void run(){
        synchronized(this){
            synchronized(club){
                club.getInLine(this);
                System.out.println(name+" got into line behind "+(club.numberOfGoatsInLine()-1));
                club.notify();
            }
            try{this.wait();}
            catch(InterruptedException e){}

            for(int i =0;i<stamina;i++){
                System.out.println(name+" is dancing");
                try{Thread.sleep(1000);}
                catch(InterruptedException e){}
            }

            
        }
    }

    public static void main(String[] args){
        new Thread(new Goat(new ClubChevre())).start();


    }
}
