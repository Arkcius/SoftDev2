package unit02.chickens;

import java.util.Scanner;

public class ChickenFarm{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of chickens: ");
        int number = scanner.nextInt();
        scanner.close();
        Chicken chick = new Chicken(Size.SMALL,Color.WHITE,"first");
        for(int i=0; i< number;i++){
            Chicken chicke = chick.randChicken();
            System.out.println(chicke);
            Egg eg = chicke.layEgg();
            System.out.println(eg);
        }
    }
}
