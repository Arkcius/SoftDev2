package unit12.intersection;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.HashSet;
import java.util.Set;

public class SIServer {
    private DatagramSocket socket;
    private DatagramPacket packetin;
    private Set<String> set;
    private Set<String> X;

    public SIServer(int port,Set<String> set) throws IOException{
        this.socket = new DatagramSocket(port);
        byte[] buffer = new byte[1024];
        this.packetin = new DatagramPacket(buffer,buffer.length);
        this.set = set;
        this.X = new HashSet<>();
    }

    public void send(String message) throws IOException{
        DatagramPacket out = new DatagramPacket(message.getBytes(), message.length(),packetin.getAddress(),packetin.getPort());
        socket.send(out);
    }

    public String receive() throws IOException{
        socket.receive(packetin);
        String message = new String(packetin.getData(),0,packetin.getLength());
        return message;
    }

    public void close(){
        socket.close();
    }

    public Set<String> getIntersection(){
        return this.X;
    }

    public void mainLoop() throws IOException{
        String message = this.receive();
        if(set.contains(message)){
            set.remove(message);
            X.add(message);
        }
        else{
            this.send("NO");
        }
        Object[] setter = set.toArray();
        set.remove(setter[0]);
        this.send((String)setter[0]);

        while(!message.equals("END")){
            message = this.receive();
            if(message.equals("NO")){
                message = this.receive();
            }
            else if(message.equals("END")){
                break;
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
        SIServer server = new SIServer(54321,Sets.set3());
        server.mainLoop();
        System.out.println(server.getIntersection());
        System.out.println(Sets.set2_3());
        server.close();
    }
}
