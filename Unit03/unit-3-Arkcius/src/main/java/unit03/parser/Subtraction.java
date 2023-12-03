package unit03.parser;

public class Subtraction implements Expression{
    private final Expression exp1;
    private final Expression exp2;

    public Subtraction(Expression exp1, Expression exp2){
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    @Override
    public double evaluate(){
        double one = exp1.evaluate();
        double two = exp2.evaluate();
        return one-two;
    }
}