package SecureNetworkServices;

import java.io.*;
import java.net.*;

public class SocketServer {
    public static void main( String[] args ) throws IOException {
         
    	int portNumber = 17777;
    	
    	//it needs to be a socket that awaits and accepts connections
    	ServerSocket ss = new ServerSocket( portNumber );
    	
    	//sockets just like the client
        System.out.println( "Waiting for connections..." );

    	Socket s = ss.accept();
        if ( s.isConnected() ) System.out.println( "Connected: " + s.getInetAddress() + ":" + s.getPort() );

        BufferedReader in = new BufferedReader( new InputStreamReader( s.getInputStream() ) );
        PrintWriter out = new PrintWriter( s.getOutputStream(), true );

//        System.out.print( “\u2713");
        String message = "";
        String Server = String.valueOf('\u2713');
        String name ;
        String statement = "UNRECOGNISED";
        while ( true ) {
            message = in.readLine();
            if(message.contains("HELLO")){
                String[] parts = message.split(" ");
                name = parts[1];
                System.out.println( "recv:" + message );
                out.println(Server);
                out.println("Your Message Was Received:"+ name);

            } else {
                System.out.println( "recv: " + message );
                out.println(statement);
                out.println("Your Message Was: "+ statement);
            }



        	if ( message.equals( "CLOSECONNECTION" ) ) {
        		s.close();
        		ss.close();
        		System.exit(0);
        	}
        }
    }
}