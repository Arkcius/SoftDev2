
public class IterativeFib{
    public static int fib(int n){
        int fir = 0;
        int sec = 1;
        int temp = 0;
        if(n<1){
            return -1;
        }
        for(int i = 0; i<n; i++){
            temp = sec;
            sec = fir + sec;
            fir = temp;
        }
        return temp;
    }
    public static void main(String[] args){
        System.out.println(fib(0));
        System.out.println(fib(1));
        System.out.println(fib(2));
        System.out.println(fib(3));
        System.out.println(fib(4));
        System.out.println(fib(5));
        System.out.println(fib(6));
        System.out.println(fib(7));

    }
}
