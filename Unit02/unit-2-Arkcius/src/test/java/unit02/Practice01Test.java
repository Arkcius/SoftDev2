package unit02;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


public class Practice01Test{
    @Test
    public void test1(){
        String expected = "[1, 2, 3]";
        int[] aray = {1,2,3};
        String actual = Practice01.arrayToString(aray);
        assertEquals(expected, actual);
    }
    @Test
    public void test2(){
        String expected = "[1, 2, 3, 5, 7]";
        int[] aray = {1,2,3,5,7};
        String actual = Practice01.arrayToString(aray);
        assertEquals(expected, actual);
    }

}
