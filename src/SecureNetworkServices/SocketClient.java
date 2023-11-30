package SecureNetworkServices;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.*;
import java.net.*;



public class SocketClient {
    public static void main( String[] args ) throws IOException {
         
    	int portNumber = 17777;
    	String hostName = "127.0.0.1";
    	
    	System.out.println( "Connecting..." );
        Socket s = new Socket( hostName, portNumber );
        if ( s.isConnected() ) System.out.println( "Connected to " + s.getInetAddress() + ":" + s.getPort() + " from " + s.getLocalAddress() + ":" + s.getLocalPort() );
        if ( s.isConnected() ) System.out.println( "Accepted Connection from: " + s.getInetAddress() + ":" + s.getPort() );

        PrintWriter out = new PrintWriter( s.getOutputStream(), true );
        BufferedReader in = new BufferedReader( new InputStreamReader( s.getInputStream() ) );

        //reads keyboard
        BufferedReader userInput = new BufferedReader( new InputStreamReader(System.in) );

        String message = "";
        String Server = "";
        String name ;
        String statement;
        while ( true ) {
        	System.out.print( "send:" );
        	message = userInput.readLine();	//reads keyboard until user hits a newline
            out.println( message );
            Server = in.readLine();
            name = in.readLine();
//            statement = in.readLine();

            System.out.println(Server);
            System.out.println(name);
//            if (statement.length() >=0 ){
//                System.out.println(statement);
//            }
            if ( message.equals( "CLOSECONNECTION" ) ) {

            	s.close();
            	System.exit(0);
            }
        }
    }
}




