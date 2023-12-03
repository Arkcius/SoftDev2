package unit10.assignment.part1;

public class Woolie implements Runnable{
    private String name;
    private int crossTime;
    private City start;
    private City end;

    public Woolie(String name, int cross, City start, City end){
        this.name = name;
        this.crossTime = cross;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run(){
        System.out.println(name+" has arrived at the bridge at "+ start.toString());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {}
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
    }

    public static void main(String[] args){
        Woolie one = new Woolie("Fred", 3, City.Courtwald, City.Glassdell);
        Woolie two = new Woolie("Roger", 5, City.Courtwald, City.Glassdell);
        Woolie three = new Woolie("BOB", 4, City.Glassdell, City.Courtwald);
        Woolie four = new Woolie("Jared", 3, City.Courtwald, City.Glassdell);
        Woolie[] listo = new Woolie[]{one,two,three,four};
        for(int i =0 ; i<listo.length;i++){
            new Thread(listo[i]).start();
        }

    }
}
