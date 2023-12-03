package unit06;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class FruitComparator implements Comparator<Fruit> {
    @Override
    public int compare(Fruit one, Fruit two){
        double ret = (one.getPrice()-two.getPrice());
        if(ret==0.0){
            return one.compareTo(two);
        }
        else{
            if(ret>0.0){
                return 1;
            }
            else{
                return -1;
            }
        }
       }

    public static void main(String[] args){
    LinkedList<Fruit> li = new LinkedList<>();
    li.add(new Fruit("Apple", 1.50));
    li.add(new Fruit("Apple", 1.00));
    li.add(new Fruit("Xy", 2.20));
    li.add(new Fruit("Pear", 1.30));
    System.out.println(li);
    Collections.sort(li,new FruitComparator());
    System.out.println(li);
    Collections.sort(li);
    System.out.println(li);
    }

}
