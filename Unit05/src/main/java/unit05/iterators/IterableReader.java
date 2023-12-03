package unit05.iterators;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class IterableReader implements Iterable<String>,Iterator<String>,AutoCloseable{
    private String file;
    private FileReader fread;
    private BufferedReader bread;

    public IterableReader(String file) throws IOException{
        this.file = file;
        this.fread = new FileReader(file);
        this.bread = new BufferedReader(fread);
    }

    

    public Iterator<String> iterator(){
        try {
            return new IterableReader(file);
        } catch (IOException e) {
            return null;
        }
    }



    @Override
    public void close() throws IOException {
        bread.close();
        fread.close();
    }

    @Override
    public boolean hasNext() {
        try {
            return bread.ready();
        } catch (IOException e) {
            return false;
        }
        }
    
    @Override
    public String next(){
        try {
            return bread.readLine();
        } catch (IOException e) {
            return "failed to read line";
        }
    }
    
    public static void main(String[] args) throws IOException {
        try (IterableReader reader = new IterableReader("C:/Users/ryanr/SoftDevII/Unit05/unit-5-Arkcius/data/simple.txt");) 
        {
            while (reader.hasNext()) {
                System.out.println(reader.next());
            }
        }
        try (IterableReader reader = new IterableReader("C:/Users/ryanr/SoftDevII/Unit05/unit-5-Arkcius/data/simple.txt");)     
        {
            for (String line : reader) {
                System.out.println(line);
            }
        }
    }
 
    
}
