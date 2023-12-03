package unit06;

import java.util.Collections;
import java.util.LinkedList;

public class Pokemon implements Comparable<Pokemon>{
    private String name;
    private int number;

    public Pokemon(String name, int number){
        this.name=name;
        this.number=number;
    }
    public String getName(){return this.name;}

    @Override
    public String toString(){
        return number+": "+name;
    }

    @Override
    public int compareTo(Pokemon other){
        return this.number-other.number;
    }

    public static void main(String[] args){
        LinkedList<Pokemon> pok = new LinkedList<>();
        pok.add(new Pokemon("char", 5));
        pok.add(new Pokemon("chara", 8));
        pok.add(new Pokemon("charamand", 5));
        pok.add(new Pokemon("charam", 7));
        System.out.println(pok);
        Collections.sort(pok);
        System.out.println(pok);
    }
}
