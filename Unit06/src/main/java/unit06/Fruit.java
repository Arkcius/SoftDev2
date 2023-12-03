package unit06;

import java.util.Collections;
import java.util.LinkedList;

public class Fruit implements Comparable<Fruit>{
    private String name;
    private double price;

    public Fruit(String name, double price){
        this.name = name;
        this.price = price;
    }
    public String getName(){return this.name;}
    public double getPrice(){return this.price;}

    @Override
    public String toString(){
        return name+" $"+price;
    }

    @Override
    public int compareTo(Fruit other){
        return this.name.toLowerCase().compareTo(other.name.toLowerCase());
    }

    public static void main(String[] args){
        LinkedList<Fruit> li = new LinkedList<>();
        li.add(new Fruit("Apple", 1.50));
        li.add(new Fruit("Xy", 1.20));
        li.add(new Fruit("Pear", 1.30));
        System.out.println(li);
        Collections.sort(li);
        System.out.println(li);
    }


}
