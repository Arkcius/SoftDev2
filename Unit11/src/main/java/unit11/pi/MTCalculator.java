package unit11.pi;

import org.apfloat.Apfloat;

public class MTCalculator extends PiCalculator{
    private Apfloat pi;
    private int i;

    public MTCalculator(PiTermCalculator termCalc){
        super(termCalc);
    }

    @Override
    public Apfloat calculate(long num){
        pi = new Apfloat(0, termCalc.getPrecision());
        for(i =0; i<num;i++){
            Thread n = new Thread(new Runnable(){
                public void run(){
                synchronized(termCalc){
                    pi = pi.add(termCalc.calculateTerm(i));
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