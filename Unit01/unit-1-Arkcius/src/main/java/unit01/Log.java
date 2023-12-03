import java.util.Scanner;
public class Log {
    // Log method takes in int base and value and returns approximate log function rounded down
    public static int log(int base, int value){
        // makes an int total that starts at 0
        int total = 0;
        //if value is less than 1 it makes total negative 1
        if(value < 1){
                total = -1; } 
        //while the value is greater than 0
        while(value > 0){
            //checks if value is equal to or greater than the base and if so divides value by base and increases total
            if(value >= base){
                value = value / base;
                total = total + 1;
            }
            // else just divides value by base so that value will become 0 to break loop
            else{
                value = value / base;
            }
        }
        return total;
    }
    //main method that just calls log for all the results needed
    public static void main(String[] args){
        int b = 1;
        int c = 1;
        Scanner scanner = new Scanner(System.in);
        while(b>=1 && c>= 1){  
            System.out.print("Enter Base: ");
            b = scanner.nextInt();
            System.out.print("Enter Value: ");
            c = scanner.nextInt();
            System.out.println(log(b,c));   
        }
        scanner.close();
    }
}
