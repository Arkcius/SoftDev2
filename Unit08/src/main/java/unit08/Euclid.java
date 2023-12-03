package unit08;

public class Euclid {
    public static int gcd(int A, int B){
    //as long as A is not equal to B
    while(A!=B){
    //if A greater than B
    if(A>B){
    //A= A-b
    A=A-B;}
    //else
    else{
    //B=B-A
    B=B-A;}
    }
    //return A
    return A;
}

    public static void main(String[] args){
        int A = 15;
        int B = 10;
        System.out.println("A:"+A+" B:"+B+" GCD:"+gcd(A,B));
    }


}
