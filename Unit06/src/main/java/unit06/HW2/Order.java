package unit06.HW2;

import java.util.HashSet;
import java.util.Set;

public class Order {
    private int cost;
    private Set<Sushi> bag;

    public Order(){
        this.cost = 0;
        this.bag = new HashSet<>();
    }

    public int size(){return bag.size();}
    public int getCost(){return this.cost;}
    public Set<Sushi> getBag(){return this.bag;}
    public void adder(Sushi value){
        bag.add(value);
        cost+=value.getPrice();
    }

}
