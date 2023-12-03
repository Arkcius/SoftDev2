import java.util.Scanner;
public class Hello{
    public static void helloYou(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please Enter Name: ");
        String name = scanner.nextLine();
        System.out.println("Hello "+ name);
        scanner.close();
    }
    public static void main(String[] args){
        helloYou();
    }
}
