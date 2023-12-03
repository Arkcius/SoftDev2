import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Files{
    public static void info(String filename){
        File file = new File(filename);
        String name = file.getName();
        String absol = file.getAbsolutePath();
        boolean exist = file.exists();
        long length = file.length();
        System.out.println("Name: "+name);
        System.out.println("Absolute Path: "+absol);
        System.out.println("Exist: "+exist);
        System.out.println("Length: "+length);
    }

    public static void printFile(String filename) throws IOException{
        FileReader fread = new FileReader(filename);
        BufferedReader bread = new BufferedReader(fread);
        String line = "";
        while(line!=null){
            line = bread.readLine();
            System.out.println(line);
        }
        bread.close();
        fread.close();
    }

    public static void main(String[] args){
        info("Calculon.java");
        info("data/alice.txt");
        
    }
}
