package unit08;

import java.util.LinkedList;
import java.util.List;

public class Greedy {
    public static List<Currency> makeChange(double price,double payment){
        //while price greater than zero
        //if able to take dollar and then quarter and so on and add to list
        //until price = 0
        List<Currency> ret = new LinkedList<>();
        double dif = payment-price;
            while(dif>=1.00){
                ret.add(Currency.DOLLAR);
                dif-=1.00;
            }
            while(dif>=0.25){
                ret.add(Currency.QUARTER);
                dif-=0.25;
            }
            while(dif>=0.10){
                ret.add(Currency.DIME);
                dif-=0.10;
            }
            while(dif>=0.05){
                ret.add(Currency.NICKEL);
                dif-=0.05;
            }
            while(dif>=0.00){
                ret.add(Currency.PENNY);
                dif-=0.01;
            }
        return ret;
    }

    public static void main(String[] args){
        double price1 = 2.24;
        System.out.println(makeChange(price1,4.00).toString());
        price1 = 1.87;
        System.out.println(makeChange(price1,2.00).toString());
        price1 = 0.06;
        System.out.println(makeChange(price1,1.00).toString());
    }
}
