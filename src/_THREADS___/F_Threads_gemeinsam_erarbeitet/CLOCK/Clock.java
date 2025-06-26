package _THREADS___.F_Threads_gemeinsam_erarbeitet.CLOCK;

import java.util.Date;

public class Clock implements Runnable {
    private boolean isRunning = true;

    public void requestShutDown() {
        System.out.println("Thread " +
                " got shutdown Request");
        isRunning = false;
    }

    @Override
    public void run() {
        while (isRunning) {
            Date d = new Date();
            System.out.println(Thread.currentThread().getName()+": "+ d.toString());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
