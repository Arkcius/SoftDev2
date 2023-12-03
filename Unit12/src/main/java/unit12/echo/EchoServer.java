package unit12.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException{
        ServerSocket server = new ServerSocket(54321);
        Socket client = server.accept();
        InputStream input = client.getInputStream();
        InputStreamReader ir = new InputStreamReader(input);
        BufferedReader reader = new BufferedReader(ir);
        String line = reader.readLine();
        System.out.println(line);
        PrintWriter writer = new PrintWriter(client.getOutputStream());
        writer.println(line.toUpperCase());
        writer.flush();
        client.close();
        server.close();
    }
    }

