package unit01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LogTest{
    public static int log(int base, int value){
        int total = 0;
        if(value < 1){
                total = -1; } 
        while(value > 0){
            if(value >= base){
                value = value / base;
                total = total + 1;
            }
            else{
                value = value / base;
            }
        }
        return total;
    }
    @Test
    public void testBasic(){
        int b = 2;
        int n = 10;
        int expect = 3;
        int total = LogTest.log(b,n);
        assertEquals(total, expect);
    }
    @Test
    public void testNegative(){
        int b = 2;
        int n = -1;
        int expect = -1;
        int total = LogTest.log(b,n);
        assertEquals(total, expect);
    }
    @Test
    public void testBase10(){
        int b = 10;
        int n = 210;
        int expect = 2;
        int total = LogTest.log(b,n);
        assertEquals(total, expect);
    }
    @Test
    public void test2(){
        int b = 2;
        int n = 1000000;
        int expect = 19;
        int total = LogTest.log(b,n);
        assertEquals(total, expect);
    }


}