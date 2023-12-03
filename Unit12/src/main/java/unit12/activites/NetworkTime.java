package unit12.activites;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class NetworkTime {
    public static void main(String[] args)throws IOException{
        Socket client = new Socket("time.nist.gov",13);
        InputStream input = client.getInputStream();
        Scanner scanner = new Scanner(input);
        while(scanner.hasNext()){
            String message = scanner.next();
            System.out.print(message);
        }
        scanner.close();
        client.close();
        System.out.println();
    }
}
