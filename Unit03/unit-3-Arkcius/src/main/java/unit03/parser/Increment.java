package unit03.parser;

public class Increment implements Expression{
    private final Expression express;

    public Increment(Expression express){
        this.express = express;

    }
    @Override
    public double evaluate(){
        return express.evaluate()+1;
    }
}