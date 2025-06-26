package _THREADS___.F_Uhrbeispiel_plus_Locks;
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
//Warum synchronized (mySyncObj)?
//        ➡ Damit beide Threads nicht gleichzeitig die Konsole “zumüllen” – sie warten aufeinander.
//
//Warum Thread.sleep(1000) im try-Block?
//        ➡ Damit der Thread jede Sekunde etwas tut und dabei unterbrechbar bleibt.
//
//        Warum while (Thread.currentThread().isInterrupted() == false)?
//        ➡ Eleganter Abbruchmechanismus durch interrupt() von außen.
//
//Alternative: Du hast auch requestShutdown() drin, aber im aktuellen Code benutzt du nur die interrupt()-Variante.
