package unit12.duplexer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Duplexer {
    private Socket sock;
    private PrintWriter printer;
    private BufferedReader reader;


    public Duplexer(Socket sock) throws IOException{
        this.sock = sock;
        this.printer = new PrintWriter(sock.getOutputStream());
        this.reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
    }

    public void send(String message){
        printer.println(message);
        printer.flush();
    }

    public String receive() throws IOException{
        return reader.readLine();
        
    }

    public void close() throws IOException{
        reader.close();
        printer.close();
        sock.close();
    }
}
