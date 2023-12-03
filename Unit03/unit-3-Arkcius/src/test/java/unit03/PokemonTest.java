package unit03;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import unit03.practicum.Pokemon;
import unit03.practicum.PokemonType;

public class PokemonTest{
    @Test
    public void level(){
        Pokemon boi = new Pokemon("bob", PokemonType.FIRE);
        boi.levelUp();
        int actual = boi.getLevel();
        int expected = 2;
        assertEquals(expected, actual);
    }
    @Test
    public void levelMax(){
        Pokemon boi = new Pokemon("bob", PokemonType.FIRE,100);
        boi.levelUp();
        int actual = boi.getLevel();
        int expected = 100;
        assertEquals(expected, actual);
    }
    @Test
    public void String(){
        Pokemon boi = new Pokemon("bob", PokemonType.FIRE);
        String actual = boi.toString();
        String expected = "Pokemon{Name = bob, Type = FIRE, Level = 1}";
        assertEquals(expected, actual);
    }
    @Test
    public void equalTrue(){
        Pokemon boi = new Pokemon("bob", PokemonType.FIRE);
        Pokemon boi2 = new Pokemon("bob", PokemonType.FIRE);
        boolean actual = boi.equals(boi2);
        boolean expected = true;
        assertEquals(expected, actual);
    }
    @Test
    public void equalFalse(){
        Pokemon boi = new Pokemon("bob", PokemonType.FIRE);
        boi.levelUp();
        Pokemon boi2 = new Pokemon("bob", PokemonType.FIRE);
        boolean actual = boi.equals(boi2);
        boolean expected = false;
        assertEquals(expected, actual);
    }
    @Test
    public void equalFalse2(){
        Pokemon boi = new Pokemon("bob", PokemonType.FIRE);
        Pokemon boi2 = new Pokemon("bob", PokemonType.WATER);
        boolean actual = boi.equals(boi2);
        boolean expected = false;
        assertEquals(expected, actual);
    }
}
