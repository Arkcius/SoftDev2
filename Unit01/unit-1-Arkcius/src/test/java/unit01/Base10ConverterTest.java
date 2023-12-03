package unit01;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Base10ConverterTest{
    @Test
    public void test5(){
        int expected = 5;
        char a = '5';
        int actual = Base10Converter.charToInteger(a);
        assertEquals(expected, actual);
    }
    @Test
    public void test0(){
        int expected = 0;
        char a = '0';
        int actual = Base10Converter.charToInteger(a);
        assertEquals(expected, actual);
    }
    @Test
    public void test10b(){
        char[] a = {'5','4','6','7'};
        int expected = 5467;
        int actual = Base10Converter.arrayToInteger(a, 10,true);
        assertEquals(expected, actual);
    }
    @Test
    public void test10l(){
        char[] a = {'5','4','6','7'};
        int expected = 7645;
        int actual = Base10Converter.arrayToInteger(a, 10,false);
        assertEquals(expected, actual);
    }
    @Test
    public void test8b(){
        char[] a = {'5','4','6','7'};
        int expected = 2871;
        int actual = Base10Converter.arrayToInteger(a, 8,true);
        assertEquals(expected, actual);
    }
    @Test
    public void test8l(){
        char[] a = {'5','4','6','7'};
        int expected = 4005;
        int actual = Base10Converter.arrayToInteger(a, 8,false);
        assertEquals(expected, actual);
    }
    @Test
    public void test2b(){
        char[] a = {'1','0','1','1'};
        int expected = 11;
        int actual = Base10Converter.arrayToInteger(a, 2,true);
        assertEquals(expected, actual);
    }
    @Test
    public void test2l(){
        char[] a = {'1','0','1','1'};
        int expected = 13;
        int actual = Base10Converter.arrayToInteger(a, 2,false);
        assertEquals(expected, actual);
    }
}