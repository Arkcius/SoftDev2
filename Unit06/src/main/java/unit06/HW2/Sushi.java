package unit06.HW2;

public class Sushi implements Comparable<Sushi>{
    private int number;
    private int weight;
    private int price;

    public Sushi(int number, int weight, int price){
        this.number = number;
        this.weight = weight;
        this.price = price;
    }

    public int getNumber(){return this.number;}
    public int getWeight(){return this.weight;}
    public int getPrice(){return this.price;}

    @Override
    public int compareTo(Sushi other){
        return this.weight-other.weight;
    }

    @Override
    public int hashCode(){
        int hash = number;
        return hash;
    }

    @Override
    public String toString(){
        return "Sushi{number="+number+", weight="+weight+" grams, $"+price+"}";
    }
}
