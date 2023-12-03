package unit11.pi;

import org.apfloat.Apfloat;

public class PiTimer {
    private static final long NUM_TERMS = 1000;
    private static final long PRECESION = 10000;

    private static void timeCalculation (PiCalculator calculator, long numTerms) {
        long start = System.currentTimeMillis ();
        Apfloat pi = calculator.calculate (numTerms);
        long end = System.currentTimeMillis ();

        System.out.println ("PI = " + pi.toString (true));
        System.out.println ("It took " + (end - start) / 1000.0 + 
            " seconds to calculate PI to " + NUM_TERMS + " terms.");
        System.out.println ("Correctly calculated pi to " + PiMillion.countCorrect (pi.toString (true)) +
            " decimal places.");
    }    
/*
 for the first one the mt calculator got the same number but it was much much slower
 as for the chunk calculator it is slightly less accurate but it is much faster coming in at about
 10-15times quicker.
 */
/*
 the ramanujan both calculated it more precisely and seems to be at around the same speed if not faster
 for them. 
 */
    public static void main(String[] args) {
        //timeCalculation (new STCalculator (new NilakanthaTermCalculator (PRECESION)), NUM_TERMS);
        //timeCalculation(new MTCalculator(new NilakanthaTermCalculator(PRECESION)), NUM_TERMS);
        //timeCalculation(new MTChunkCalculator(new NilakanthaTermCalculator(PRECESION)), NUM_TERMS);
        timeCalculation (new STCalculator (new RamanujanTermCalculator (PRECESION)), NUM_TERMS);
        timeCalculation(new MTCalculator(new RamanujanTermCalculator(PRECESION)), NUM_TERMS);
        timeCalculation(new MTChunkCalculator(new RamanujanTermCalculator(PRECESION)), NUM_TERMS);
        //RamanujanTermCalculator r = new RamanujanTermCalculator(PRECESION);
        //Apfloat sum;
        //sum = r.calculateTerm(0);
        //System.out.println(sum);
        //System.out.println(r.finalAdjustment(r.calculateTerm(1)));
    }
}
