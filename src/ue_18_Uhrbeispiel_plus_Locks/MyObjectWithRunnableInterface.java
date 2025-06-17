package ue_18_Uhrbeispiel_plus_Locks;

import java.util.Date;

public class MyObjectWithRunnableInterface implements Runnable {
    private boolean isRunning = true;
    public Object mySyncObj;

    public void requestShutdown() {
        isRunning = false;
    }

    @Override
    public void run() {
        // while(isRunning == true){
        while (Thread.currentThread().isInterrupted() == false) {
            Date d = new Date();

            //warte darauf dass
            //ich als Thread alleine Zugriff auf "mySyncObj"
            // habe
            synchronized (mySyncObj) {
                System.out.println(Thread.currentThread().getName() +
                        " " + d);
                //TODO: More output
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("MyThread: my sleep " +
                        "has been disturbed.");
                break;
            }
        }
        System.out.println("MyThread: shutting down.");
    }
}
