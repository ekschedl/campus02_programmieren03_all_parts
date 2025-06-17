package Uhrbeispiel_plus_Locks2;

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
                System.out.print("[");
                System.out.print(d.toString());
                System.out.print(", CPUS: ");
                System.out.print(Runtime.getRuntime().availableProcessors());
                System.out.print(", FreeMem: ");
                System.out.print(Runtime.getRuntime().freeMemory());
                System.out.println("]");
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
