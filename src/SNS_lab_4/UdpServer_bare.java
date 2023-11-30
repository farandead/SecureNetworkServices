package SNS_lab_4;

import java.io.*;
import java.net.*;
import java.util.*;

import static java.lang.System.out;

public class UdpServer_bare {

	public static void main(String[] args) throws IOException {
		System.out.println( "Starting server..." );
		DatagramSocket socket = new DatagramSocket( 17778 );
		byte[] bufRecv = new byte[256];
		DatagramPacket packet = new DatagramPacket( bufRecv, bufRecv.length );

		while ( true ) {
			socket.receive( packet );
			System.out.println( "Got packet..." );
			out.println(packet.getAddress());
			out.println(packet.getLength());
			out.println(packet.getPort());
			// handle packet
			UdpServer_Thread srv = new UdpServer_Thread( socket, packet );
			srv.start();
		}


	    //TODO: show properties of packet (port, IP addres, ...), retrieve and show message


//		String MessageRec = new String(packet.getData(),0, packet.getLength());
//		out.println(MessageRec);
//
//		String repliedMsg = "Heya";
//		byte[] serverReply = repliedMsg.getBytes();	// we need raw bytes
//		InetAddress address = packet.getAddress();
//		DatagramPacket ServerPacketSend = new DatagramPacket( serverReply, serverReply.length, address, packet.getPort() );
//		socket.send(ServerPacketSend);
//
//		socket.close();
	}
}
