public class Conditional{
    public static void evenlyDivisible(int n){
        if(n%2==0){
            System.out.println(n + " is Even");
        }
        else if(n%3==0){
            System.out.println(n + " is divisble by 3");
        }
        else if(n%5==0){
            System.out.println(n + " is divisble by 5");
        }
        else{
            System.out.println(n + " is odd but not divisible by 3 or 5");
        }
    }
    public static void main(String[] args){
        evenlyDivisible(3);
        evenlyDivisible(25);
        evenlyDivisible(10);
        evenlyDivisible(11);
    }
}
