package SNS_lab_5;

public class ThreadSampleRun {

    public static void main(String args[]) {

        ThreadSample t1 = new ThreadSample( "Fire away, thread One!" );
        ThreadSample t2 = new ThreadSample( "Fire away, thread Two!" );

        t1.start();
        t2.start();
    }
}

