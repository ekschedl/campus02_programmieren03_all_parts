package _THREADS___.ue_18_threads_with_stop;

import java.util.Date;

public class TimePrinter implements Runnable {

    public static boolean running = true;


    public static void stopRunning() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            Date nowDate = new Date();
            System.out.println("Zeit: " + nowDate);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread unterbrochen");
            }
        }
        System.out.println("Zeit-Anzeige gestoppt.");

    }
}
