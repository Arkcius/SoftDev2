package unit10.activities;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public interface Operation{
        public double execute(double left, double right);
    }

    public static Operation getOperation(String operation){
        if(operation.equals("+")){
            return new Operation(){
                public double execute(double left, double right){
                    return left+right;
                }
            };
        }
        else if(operation.equals("-")){
            return (left,right) -> left - right;
        }
        else if(operation.equals("*")){
            return (left,right) -> left * right;
        }
        else if(operation.equals("/")){
            return (left,right) -> left / right;
        }
        else if(operation.equals("**")||operation.equals("^")){
            return Math::pow;
        }
        else{
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        double left = 0.0;
        double right = 0.0;
        String op = null;
        while(quit==false){
        System.out.println("Enter in form number operator number");
        try{
        left = scanner.nextDouble();
        op = scanner.next();
        right = scanner.nextDouble();
        Operation oper = getOperation(op);
        Double ret = oper.execute(left,right);
        System.out.println(ret);
        }
        catch(InputMismatchException ime){
            break;
        }
        

        }
        scanner.close();
        }


    }

