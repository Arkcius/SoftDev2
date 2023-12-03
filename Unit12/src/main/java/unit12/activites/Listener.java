package unit12.activites;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Listener {
    public static void main(String[] args) throws IOException{
        ServerSocket server = new ServerSocket(22);
        Socket client = server.accept();
        System.out.println("Connected");
        server.close();
        client.close();
    }    
}
