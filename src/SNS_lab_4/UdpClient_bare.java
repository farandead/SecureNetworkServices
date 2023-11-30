package SNS_lab_4;

import java.io.*;
import java.net.*;

import static java.lang.System.out;

public class UdpClient_bare {
	public static void main(String[] args) throws IOException {
		DatagramSocket socket = new DatagramSocket();
		byte[] buffed = new byte[256];

		DatagramPacket ServerPacketSend = new DatagramPacket( buffed, buffed.length );
		// send hello
		String msg = "Hello";
		byte[] buf = msg.getBytes();	// we need raw bytes
		InetAddress address = InetAddress.getByName( "127.0.0.1" );	// why getByName?
		DatagramPacket packetSend = new DatagramPacket( buf, buf.length, address, 17778 );
		
		System.out.println( "Press any key to send packet." );
		System.in.read();	// simply waits for a key
		socket.send( packetSend );
		socket.receive(ServerPacketSend);

		String MessageRec = new String(ServerPacketSend.getData(),0, ServerPacketSend.getLength());
		out.println(MessageRec);

        socket.close();
        System.out.println( "Done." );
	}
}

