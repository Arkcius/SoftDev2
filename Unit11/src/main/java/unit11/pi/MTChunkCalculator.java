package unit11.pi;

import org.apfloat.Apfloat;

public class MTChunkCalculator extends PiCalculator {
    private Apfloat pi;
    private int i;

    public MTChunkCalculator(PiTermCalculator termCalc){
        super(termCalc);
    }

    @Override
    public Apfloat calculate(long num){
        pi = new Apfloat(0, termCalc.getPrecision());
        for(i =0; i<num/(num/10);i++){
            Thread n = new Thread(new Runnable(){
                public void run(){
                synchronized(termCalc){
                    for(int j =0;i<num/10;i++){
                    pi = pi.add(termCalc.calculateTerm(i+j));}
                    termCalc.notify();
                }}});
                n.start();
                try {
                    n.join();
                } catch (InterruptedException e) {}
            }
            
        return termCalc.finalAdjustment(pi);
    }
}
