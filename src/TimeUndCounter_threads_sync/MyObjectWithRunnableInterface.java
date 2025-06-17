package TimeUndCounter_threads_sync;

import java.util.Date;

public class MyObjectWithRunnableInterface implements Runnable {

private boolean isRunning=true;
public Object myObjVorSync;


    public void requestShutdown() {
        isRunning = false;
    }


    @Override
    public void run() {
        Date d = new Date();


    }
}
