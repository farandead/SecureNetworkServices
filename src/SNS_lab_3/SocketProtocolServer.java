package SNS_lab_3;


import java.io.*;
import java.net.*;

public class SocketProtocolServer {
    public static void main( String[] args ) throws IOException {

        int portNumber = 17778;
        boolean initialised = false;
        String clientName = "";

        //it needs to be a socket that awaits and accepts connections
        ServerSocket ss = new ServerSocket( portNumber );

        //sockets just like the client
        System.out.println( "Waiting for connections..." );

        Socket s = ss.accept();
        if ( s.isConnected() ) System.out.println( "Connected: " + s.getInetAddress() + ":" + s.getPort() );

        //structure to read messages
        BufferedReader in = new BufferedReader( new InputStreamReader( s.getInputStream() ) );	// incoming
        PrintWriter out = new PrintWriter( s.getOutputStream(), true );	// outgoing

        String message = "";
        while ( true ) {
            message = in.readLine();

            //process "closeconnection"
            if ( message.equals( "CLOSECONNECTION" ) ) {
                System.out.println( "Terminating..."  );
                s.close();
                ss.close();
                System.exit(0);
            }

            //initialisation
            if ( initialised ) {
                //receive and send back a tick mark to Client
                System.out.println( "recv: " + message );
                out.println( "\u2713" );	//the tick
            }
            else {	// we expect "HELLO"
                String[] m;
                m = message.split( " " );	// find words separated by space
                if ( m[0].equals( "HELLO" ) ) {
                    clientName = m[1];
                    System.out.println( "Client \"" + clientName + "\" connected" );
                    initialised = true;
                    out.println( "OK" );
                }
                else
                    out.println( "NOTRECOGNISED" );
            }

        }
    }
}