package SNS_lab_5;

public class ThreadSample extends Thread  {

    private String msg;

    public void run() {
        System.out.println( Thread.currentThread().getName() + ": " + msg );
    }

    public ThreadSample( String m ) {
        msg = m;
    }

}



