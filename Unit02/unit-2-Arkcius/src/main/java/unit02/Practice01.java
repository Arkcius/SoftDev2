package unit02;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class Practice01{
    public static String arrayToString(int[] aray){
        int length = aray.length;
        String finall ="[";
        for(int i=0;i<length;i++){
            finall = finall + aray[i];
            if(i<length-1){
                finall = finall + ", ";
            } 
        }
        finall = finall + "]";
        return finall;
    }

    public static int printLines(File filename, char letter) throws IOException{
        try{
        FileReader fread = new FileReader(filename);
        BufferedReader bread = new BufferedReader(fread);
        String line = bread.readLine();
        int total = 0;
        while(line!=null){
            try{
            String line2 = line.toLowerCase();
            char ch = line2.charAt(0);
            if(ch==letter){
                System.out.println(line);
                total += 1;
            }
            line = bread.readLine();
        }
        catch(StringIndexOutOfBoundsException e){

        }
        bread.close();
        fread.close();
        return total;
    }
    }
    catch(FileNotFoundException e){
        System.out.println("File Not Found");
        return 0;
    }
    return 0;
    }

public static void main(String[] args) throws IOException{
    File file = new File("D:\\Profiles\\rar6741\\SoftDevII\\Unit02\\unit-2-Arkcius\\data\\alice.txt");
    int total = printLines(file, 'a');
    System.out.println("A: "+total);
}
}
