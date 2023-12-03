package unit10.assignment.part2;

public class Woolie implements Runnable{
    private String name;
    private int crossTime;
    private City start;
    private City end;
    private Bridge brig;

    public Woolie(String name, int cross, City start, City end,Bridge brig){
        this.name = name;
        this.crossTime = cross;
        this.start = start;
        this.end = end;
        this.brig = brig;
    }

    @Override
    public void run(){
        System.out.println(name+" has arrived at the bridge at "+ start.toString());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {}
        while(brig.enterBridge()==false){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {}
        }
        System.out.println(name+" is starting to cross");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {}
        for(int i=1; i<=crossTime;i++){
            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException ie){}
            System.out.println("\t"+name+": "+i+" seconds");
        }
        System.out.println(name+" arrives at "+end.toString());
        brig.leaveBridge();
    }

    public static void main(String[] args){
        Bridge brig = new Bridge();
        Woolie one = new Woolie("Fred", 3, City.Courtwald, City.Glassdell,brig);
        Woolie two = new Woolie("Roger", 5, City.Courtwald, City.Glassdell,brig);
        Woolie three = new Woolie("BOB", 4, City.Glassdell, City.Courtwald,brig);
        Woolie four = new Woolie("Jared", 3, City.Courtwald, City.Glassdell,brig);
        Woolie[] listo = new Woolie[]{one,two,three,four};
        for(int i =0 ; i<listo.length;i++){
            new Thread(listo[i]).start();
        }

    }
}
