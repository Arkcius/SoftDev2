package unit02;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import unit02.chickens.*;

public class ChickenTest{
    @Test
    public void eggMake(){
        Egg eg = new Egg(Color.WHITE,Size.SMALL);
        String actual = eg.toString();
        String expected = "An uncracked SMALL (18) WHITE egg";
        assertEquals(expected, actual);
    }
    @Test
    public void eggMakeCrack(){
        Egg eg = new Egg(Color.WHITE,Size.SMALL);
        eg.crack();
        boolean actual = eg.isCracked();
        boolean expected = true;
        assertEquals(expected, actual);
    }
    @Test
    public void eggMakeCrackout(){
        Egg eg = new Egg(Color.WHITE,Size.SMALL);
        eg.crack();
        String actual = eg.toString();
        String expected = "A cracked SMALL (18) WHITE egg";
        assertEquals(expected, actual);
    }
    @Test
    public void eggMakeEqualTrue(){
        Egg eg = new Egg(Color.WHITE,Size.SMALL);
        Egg eggg = new Egg(Color.WHITE,Size.SMALL);
        boolean actual = eg.equals(eggg);
        boolean expected = true;
        assertEquals(expected, actual);
    }
    @Test
    public void eggMakeEqualFalse(){
        Egg eg = new Egg(Color.WHITE,Size.SMALL);
        Egg eggg = new Egg(Color.WHITE,Size.SMALL);
        eg.crack();
        boolean actual = eg.equals(eggg);
        boolean expected = false;
        assertEquals(expected, actual);
    }
    @Test
    public void chickenMakeEqualFalse(){
        Chicken eg = new Chicken(Size.SMALL,Color.WHITE,"Bob");
        Chicken eggg = new Chicken(Size.MEDIUM,Color.WHITE,"Bob");
        boolean actual = eg.equals(eggg);
        boolean expected = false;
        assertEquals(expected, actual);
    }
    @Test
    public void chickenMakeEqualTrue(){
        Chicken eg = new Chicken(Size.SMALL,Color.WHITE,"Bob");
        Chicken eggg = new Chicken(Size.SMALL,Color.WHITE,"Bob");
        boolean actual = eg.equals(eggg);
        boolean expected = true;
        assertEquals(expected, actual);
    }
}