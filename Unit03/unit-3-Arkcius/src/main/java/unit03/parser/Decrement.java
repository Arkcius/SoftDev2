package unit03.parser;

public class Decrement implements Expression{
    private final Expression express;

    public Decrement(Expression express){
        this.express = express;

    }
    @Override
    public double evaluate(){
        return express.evaluate()-1;
    }
}