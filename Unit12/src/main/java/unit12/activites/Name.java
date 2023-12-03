package unit12.activites;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Name {
    public static void main(String[] args)throws IOException{
        Socket client = new Socket("129.21.100.43",4321);
        OutputStream out = client.getOutputStream();
        PrintWriter printer = new PrintWriter(out);
        printer.println("Ryan R");
        printer.flush();
        client.close();

    }
}
