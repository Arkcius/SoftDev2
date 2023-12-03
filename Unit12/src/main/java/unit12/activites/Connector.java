package unit12.activites;

import java.io.IOException;
import java.net.Socket;

public class Connector {
    public static void main(String[] args) throws IOException{
        Socket sock = new Socket("www.google.com",80);
        if(sock!=null){
            System.out.println("Connection 1 successful");
        }
        sock.close();
        Socket sock2 = new Socket("www.npr.org",443);
        if(sock2!=null){
            System.out.println("Connection 2 successful");
        }
        sock2.close(); 
        Socket sock3 = new Socket("swec-123.rit.edu",33075);
        if(sock3!=null){
            System.out.println("Connection 3 successful");
        } 
        sock3.close();
    }
}
