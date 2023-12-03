public class Casting{
    public static void main(String[] args){
        int x = 329;
        long y = (long) x;
        long z = 12345678910l;
        int z2 = (int)z;
        char a = 'a';
        int b = (int)a;
        int c = 35;
        char d = (char)c;
        //boolean e = True;
        //int f = (int)e;

        System.out.println(y);
        System.out.println(z2);
        System.out.println(b);
        System.out.println(d);
        //System.out.println(f);
    }
}
