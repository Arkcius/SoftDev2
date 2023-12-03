package unit06;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class PokemonComparator implements Comparator<Pokemon> {
    @Override
    public int compare(Pokemon one, Pokemon two){
        String alp1 = one.getName();
        String alp2 = two.getName();
        return alp1.toLowerCase().compareTo(alp2.toLowerCase());
    }

    public static void main(String[] args){
        LinkedList<Pokemon> pok = new LinkedList<>();
        pok.add(new Pokemon("char", 5));
        pok.add(new Pokemon("bulb", 8));
        pok.add(new Pokemon("charama", 5));
        pok.add(new Pokemon("squirtle", 7));
        System.out.println(pok);
        Collections.sort(pok, new PokemonComparator());
        System.out.println(pok);
        Collections.sort(pok);
        System.out.println(pok);
    }
}
