package unit01;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculon{
    public static float add(float a, float b){
        return a+b;
    }
    public static float subtract(float a, float b){
        return a-b;
    }
    public static float multiply(float a, float b){
        return a*b;
    }
    public static float divide(float a, float b){
        return a/b;
    }
    public static float raise(float a, float b){
        float total = a;
        while(b > 1){
            total = total*a;
            b-=1;
        }
        return total;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        try{
        System.out.print("Enter first Float: ");
        float x = scanner.nextFloat();
        System.out.print("Enter second Float: ");
        float y = scanner.nextFloat();
        System.out.println("Add "+ x +" + "+ y + " = "+add(x,y));
        System.out.println("Subtract "+ x +" - "+ y + " = "+subtract(x,y));
        System.out.println("Multiply "+ x +" * "+ y + " = "+multiply(x,y));
        System.out.println("Divide "+ x +" / "+ y + " = "+divide(x,y));
        System.out.println("Power "+ x +" ^ "+ y + " = "+raise(x,y));
        }
        catch(InputMismatchException e){
            System.out.println("Invalid Integer!");
        }
        
        scanner.close();

    }
}
