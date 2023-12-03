package unit01;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;



public class CalculonTest {
    @Test
    public void testAdd(){
        float x = 5.1f;
        float y = 7.2f;
        float expected = x+y;

        float actual = Calculon.add(5.1f,7.2f);

        assertEquals(expected,actual, 0.001f);
    }
    @Test
    public void testSubtract(){
        float x = 5.1f;
        float y = 7.2f;
        float expected = x-y;

        float actual = Calculon.subtract(5.1f,7.2f);

        assertEquals(expected,actual, 0.001f);
    }
    @Test
    public void testMultiply(){
        float x = 5.1f;
        float y = 7.2f;
        float expected = x*y;

        float actual = Calculon.multiply(5.1f,7.2f);

        assertEquals(expected,actual, 0.001f);
    }
    @Test
    public void testDivide(){
        float x = 5.1f;
        float y = 7.2f;
        float expected = x/y;

        float actual = Calculon.divide(5.1f,7.2f);

        assertEquals(expected,actual, 0.001f);
    }
    }
