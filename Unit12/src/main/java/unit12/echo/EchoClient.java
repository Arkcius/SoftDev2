package unit12.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient {
    public static void main(String[] args) throws IOException{
        Socket sock = new Socket("localHost",54321);
        OutputStream out = sock.getOutputStream();
        PrintWriter writer = new PrintWriter(out);
        writer.println("Its Monday");
        writer.flush();
        InputStream in = sock.getInputStream();
        InputStreamReader ir = new InputStreamReader(in);
        BufferedReader read = new BufferedReader(ir);
        String message = read.readLine();
        System.out.println(message);
        sock.close();
    }
}
