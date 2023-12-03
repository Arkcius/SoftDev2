package unit11.pi;

import java.math.BigDecimal;
import java.math.MathContext;

import org.apfloat.Apfloat;

public class RamanujanTermCalculator implements PiTermCalculator{
    private final long precision;


    public RamanujanTermCalculator(long precision){
        this.precision = precision;
    }

    @Override
    public Apfloat calculateTerm(long n){
        Apfloat num = new Apfloat((1103+(26390*n)), precision);
        num = num.multiply(fact(4*n));
        Apfloat de = powe(396, 4*n);
        Apfloat fn = fact(n);
        for(int i =0;i<3;i++){
            fn = fn.multiply(fact(n));
        }
        de = de.multiply(fn);
        return num.divide(de);
    }



    @Override
    public Apfloat finalAdjustment(Apfloat sum) {
        BigDecimal two = new BigDecimal (2);
        Apfloat sqrt2 = new Apfloat(two.sqrt(new MathContext((int)precision)));
        sqrt2 = sqrt2.multiply(new Apfloat(2, precision));
        sqrt2 =sqrt2.divide(new Apfloat(9801, precision));
        sum = sum.multiply(sqrt2);
        Apfloat one = new Apfloat(1, precision);
        sum = one.divide(sum);
        return sum;
    }

    @Override
    public long getPrecision() {
        return precision;}
    
    public Apfloat powe(long n,long s){
        if(s == 0){
            return new Apfloat(1);
        }
        Apfloat ret = new Apfloat(n,precision);
        for(long i =0;i<s-1;i++){
            ret = ret.multiply(new Apfloat(n, precision));
        }
        return ret;
    }
    
    public Apfloat fact(long n) {
        Apfloat fact = new Apfloat(1, precision);
        for (int i = 2; i <= n; i++) {
            Apfloat st = new Apfloat(i, precision);
            fact = fact.multiply(st);
        }
        return fact;
        }        
}
