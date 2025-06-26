package _THREADS___.Synchronized__TimeUndCounter_2threads_____sync;

import java.util.Date;

public class MyObjectWithRunnableInterface implements Runnable {

    private boolean isRunning = true;
    public Object myObjVorSync; // Synchronisationsobjekt, wird von außen übergeben
    private static int counter = 0; // Gemeinsamer Zähler für alle Threads

    public void requestShutdown() {
        isRunning = false; // Sauberer Abbruch von außen möglich
    }

    @Override
    public void run() {
        while (isRunning) {
            synchronized (myObjVorSync) {
                counter++;
                Date d = new Date();
                System.out.println(Thread.currentThread().getName() +
                        " | Zeit: " + d +
                        " | Counter: " + counter);
            }

            try {
                Thread.sleep(1000); // 1 Sekunde Pause zwischen Ausgaben
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " wurde unterbrochen.");
                break;
            }
        }
        System.out.println(Thread.currentThread().getName() + " beendet sich.");
    }
}