package unit06.HW2;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Shop {
    public static void main(String[] args){
        Map<Integer,Sushi> hm = new HashMap<>();
        Random rng = new Random(1);
        for(int i =0;i<25;i++){
            Sushi h = new Sushi(i, rng.nextInt(81)+20, rng.nextInt(31)+10);
            hm.put(h.getNumber(), h);
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 3-8 Items Individually");
        int number = sc.nextInt();
        Order ord = new Order();
        while(ord.size()<8&&number!=25){
            try{
            ord.adder(hm.get(number));
            hm.remove(number);
            System.out.println("Enter next order number or 25 to finish");
            number = sc.nextInt();
            if(number==25&&ord.size()>3){
                break;
            }}
            catch (NullPointerException e){
                System.out.println("Invalid input Enter number 0-24 that hasnt been chosen");
                System.out.println("Enter next order number or 25 to finish");
                number = sc.nextInt();
            }
        }
        sc.close();
        System.out.println("Order total = $"+ord.getCost());
        for(Sushi ele : ord.getBag()){
            System.out.println("Eating "+ele);
        }
    }
}
