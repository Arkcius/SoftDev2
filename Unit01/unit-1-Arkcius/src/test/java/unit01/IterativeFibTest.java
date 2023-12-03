package unit01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class IterativeFibTest{
    public static int fib(int n){
        int fir = 0;
        int sec = 1;
        int temp = 0;
        if(n<1){
            return -1;
        }
        for(int i = 0; i<n-1; i++){
            temp = sec;
            sec = fir + sec;
            fir = temp;
        }
        return temp;
    }
    @Test
    public void test1(){
        int n = 1;
        int expect = 0;
        int actual = fib(n);
        assertEquals(expect,actual);
    }
    @Test
    public void testNeg1(){
        int n = -1;
        int expect = -1;
        int actual = fib(n);
        assertEquals(expect,actual);
    }
    @Test
    public void test2(){
        int n = 2;
        int expect = 1;
        int actual = fib(n);
        assertEquals(expect,actual);
    }
    @Test
    public void test7(){
        int n = 7;
        int expect = 8;
        int actual = fib(n);
        assertEquals(expect,actual);
    }
}