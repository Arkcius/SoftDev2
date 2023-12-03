package unit12.echo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPEchoClient {
    public static void main(String[] args) throws IOException{
        String message = "Hello";
        DatagramPacket outgoing = new DatagramPacket(message.getBytes(), message.length(), InetAddress.getByName("localhost"),54321);
        DatagramSocket sock = new DatagramSocket();
        sock.send(outgoing);
        byte[] buffer = new byte[1024];
        DatagramPacket incoming = new DatagramPacket(buffer,buffer.length);
        
        sock.close();
    }
}
