package unit03.parser;

public class Constant implements Expression{
    private double constant;

    public Constant(double constant){
        this.constant = constant;
    }

    @Override
    public double evaluate(){
        return constant;
    }

}