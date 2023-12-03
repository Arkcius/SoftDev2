package unit12.intersection;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashSet;
import java.util.Set;

public class SIClient {
    private DatagramSocket socket;
    private String SERVER_NAME;
    private int PORT;
    private Set<String> set;
    private Set<String> X;

    public SIClient(String serverName, int port,Set<String> set) throws IOException{
        this.SERVER_NAME = serverName;
        this.PORT = port;
        this.socket = new DatagramSocket();
        this.set = set;
        this.X = new HashSet<>();
    }

    public void send(String message) throws IOException{
        DatagramPacket out = new DatagramPacket(message.getBytes(), message.length(),InetAddress.getByName(SERVER_NAME),PORT);
        socket.send(out);
    }

    public String receive() throws IOException{
        byte[] buffer = new byte[1024];
        DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);
        socket.receive(incoming);
        String message = new String(incoming.getData(),0,incoming.getLength());
        return message;
    }

    public void close(){
        socket.close();
    }

    public Set<String> getIntersection(){
        return this.X;
    }

    public void mainLoop() throws IOException{
        Object[] setter = set.toArray();
        set.remove(setter[0]);
        this.send((String)setter[0]);
        String message = "";
        while(!message.equals("END")){
            message = this.receive();
            if(message.equals("NO")){
                message = this.receive();
            }
            else{
                X.add((String)setter[0]);
            }

            if(set.contains(message)){
                set.remove(message);
                X.add(message);
            }
            else{
                this.send("NO");
            }
            if(!set.isEmpty()){
            setter = set.toArray();
            set.remove(setter[0]);
            this.send((String)setter[0]);}
            else{
                this.send("END");
                break;
            }
        }

    }

    public static void main(String[] args) throws IOException{
        SIClient client = new SIClient("localhost", 54321,Sets.set2());
        client.mainLoop();
        System.out.println(client.getIntersection());
        System.out.println(Sets.set2_3());
        client.close();
    }
}
