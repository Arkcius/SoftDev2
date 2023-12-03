package unit01;

import java.util.Arrays;

// the package makes you have to run it from the java folder not
//unit01 but if its not there then any testing wont work
//if anyone knows how to fix that please lmk
public class Miscellany{
    public static void reverseChars(String rev){
        int length = rev.length();
        String neww = "";
        for(int i=0;i<length;i++){
            neww = neww + rev.charAt(length-i-1);
        }
        System.out.println(neww);
    }
    public static int[] squares(int n){
        int[] numbers = new int[n];
        for(int i = 0;i<n;i++){
            numbers[i] = i*i;
        }
        return numbers;
    }
    public static int[][] multiplicationTable(int x,int y){
        int [][] table = new int[x][y];
        for(int i = 0;i<x;i++){
            for(int j = 0;j<y;j++){
                table[i][j] = (i+1)*(j+1);
            }
        }
        return table;
    }
    public static void main(String args[]){
        reverseChars("Hello");
        System.out.println(Arrays.toString(squares(5)));
        int[][] table = multiplicationTable(3, 3);
        int i=0;
        while(i<3){
            System.out.println(Arrays.toString(table[i]));
            i++;
        }
    }
}

