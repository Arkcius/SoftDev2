package unit12.echo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPEchoServer {
    public static void main(String[] args) throws IOException{
        byte[] buffer = new byte[1024];
        DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);
        DatagramSocket sock = new DatagramSocket(54321);
        sock.receive(incoming);
        String message = new String(incoming.getData(),0,incoming.getLength());
        System.out.println(message);         
        DatagramPacket outgoing = new DatagramPacket(message.getBytes(),message.length(),incoming.getAddress(),incoming.getPort());
        sock.close();
    }
}
