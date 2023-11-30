package SNS_lab_4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import static java.lang.System.out;

public class UdpServer_Thread extends Thread {
    DatagramPacket packet;
    DatagramSocket socket;
    public void run() {
        try {
            socket.receive(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String newValue = new String(packet.getData(),0, packet.getLength());
        System.out.println( Thread.currentThread().getName() + ": " + "Packet Port:" + packet.getPort()+"Packet Address:"+packet.getAddress() );
        System.out.println("Received :" + newValue);

    }
    public UdpServer_Thread(DatagramSocket s , DatagramPacket p){
        socket = s;
        packet=p;
    }


}
