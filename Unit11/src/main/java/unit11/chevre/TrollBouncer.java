package unit11.chevre;

public class TrollBouncer implements Runnable{

    private ClubChevre club;

    public TrollBouncer(ClubChevre club){
        this.club = club;
    }


    @Override
    public void run(){
        while(true){
            synchronized(club){

                while(!club.isAtCapacity()&&club.numberOfGoatsInLine()>0){
                    Goat goat = club.getGoatAtPosition(0);
                    club.removeGoatFromLine(goat);
                    club.startDancing(goat);

                    System.out.println("Bouncer lets "+goat.getName());
                    club.notify();

                    try{club.wait();}
                    catch(InterruptedException e){}
                }


            }
        }
    }
    
}
