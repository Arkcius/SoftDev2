public class CountUp{
    public static int countWhile(int n){
        int i = 0;
        int total = 0;
        System.out.println(i);
        while(i != n){
            i = i+1;
            total = total + i;
            System.out.println(i);
        }
        return total;
    }
    public static int countFor(int n){
        int total = 0;
        for(int c=0; c<=n; c++){
            total+=c;
            System.out.println(c);
        }
        return total;
    }
    public static void main(String[] args){
        System.out.println("Counted total = " +countWhile(6));
        System.out.println("Counted total = " +countFor(6));
    }
}
