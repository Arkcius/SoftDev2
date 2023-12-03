package unit01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Base10Converter{
    public static int charToInteger(char digit){
        int i = digit;
        i-=48;
        return i;
    }

    public static int arrayToInteger(char[] aray,int base,boolean endian){
        int length = aray.length;
        int total = 0;
        if(endian == true){
            for(int i=0;i<length;i++){
                int dig = charToInteger(aray[i]);
                total += dig * (Math.pow(base,length-i-1));
            }
        }
        else{
            for(int i=length-1;i>=0;i--){
                int dig = charToInteger(aray[i]);
                total += dig * (Math.pow(base,i));
            }
        }
        return total;

    }
    public static void main(String[] args) throws IOException{
        System.out.println("Enter just the data/digits portion");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter filename: ");
        String filename = scanner.nextLine();
        scanner.close();
        File file = new File("C:\\Users\\ryanr\\SoftDevII\\Unit01\\unit-1-Arkcius\\"+filename);
        try{
        FileReader fread = new FileReader(file);
        BufferedReader bread = new BufferedReader(fread);
        String line0 = bread.readLine();
        char line0c = line0.charAt(0);
        int base = charToInteger(line0c);
        System.out.println("Base: "+ base);
        line0 = bread.readLine();
        boolean big = true;
        if(line0.charAt(0) == 'b'){
            big = true;
            System.out.println("Endianness: big-endian");
        }
        else{
            big = false;
            System.out.println("Endianness: little-endian");
        }
        while(line0!=null){
            line0 = bread.readLine();
            int c=0;
            String norm = "";
            String deci = "";
            if(line0!=null){
            while(line0.charAt(c)!=' '){
                norm = norm + line0.charAt(c);
                c++;
            }
            c++;
            while(line0.charAt(c)!=' ' && c != line0.length()-1){
                deci = deci + line0.charAt(c);
                c++;
            }
            deci = deci + line0.charAt(c);
            char[] dec = deci.toCharArray();
            char[] nor = norm.toCharArray();
            int deciN = arrayToInteger(dec, 10, true);
            int normN = arrayToInteger(nor, base, big);
            if(deciN==normN){
                System.out.println(norm+": "+deci+" (Match)");
            }
            else{
                System.out.println(norm+": "+normN+" (mismatch "+deci+")");
            }
        }


        }
        bread.close();
        fread.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File not Found");
            String absol = file.getAbsolutePath();
            System.out.println("Absolute Path: "+absol);
        }
    }
        

    }

