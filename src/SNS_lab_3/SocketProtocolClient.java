package SNS_lab_3;

import java.io.*;
import java.net.*;



public class SocketProtocolClient {
    public static void main( String[] args ) throws IOException {

        int portNumber = 17778;
        String hostName = "127.0.0.1", clientName = "Alice";

        System.out.println( "Connecting..." );
        Socket s = new Socket( hostName, portNumber );
        if ( s.isConnected() ) System.out.println( "Connected to " + s.getInetAddress() + ":" + s.getPort() + " from " + s.getLocalAddress() + ":" + s.getLocalPort() );

        PrintWriter out = new PrintWriter( s.getOutputStream(), true );
        BufferedReader in = new BufferedReader( new InputStreamReader( s.getInputStream() ) );

        //initialise
        System.out.println( "Initialising... (" + clientName + ")" );
        out.println( "HELLO" + " " + clientName );
        if ( !in.readLine().equals( "OK" ) ) {
            System.out.print( "Server rejected." );
            s.close();
            System.exit(0);
        }

        //reads keyboard
        BufferedReader userInput = new BufferedReader( new InputStreamReader( System.in ) );

        String message = "", messageFromServer;
        while ( true ) {
            System.out.print( "send: " );
            message = userInput.readLine();		//reads keyboard until user hits a newline

            //sending to server
            out.println( message );

            // handling special command "CLOSECONNECTION"
            if ( message.equals( "CLOSECONNECTION" ) ) {
                System.out.println( "Terminating" );
                s.close();
                System.exit(0);
            }

            //receive message
            messageFromServer = in.readLine();
            System.out.println( "server: " + messageFromServer );

        }
    }
}





