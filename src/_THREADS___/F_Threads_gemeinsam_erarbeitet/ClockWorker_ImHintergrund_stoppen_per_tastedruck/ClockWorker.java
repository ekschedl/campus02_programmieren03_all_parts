package _THREADS___.F_Threads_gemeinsam_erarbeitet.ClockWorker_ImHintergrund_stoppen_per_tastedruck;

import java.util.Date;

public class ClockWorker implements Runnable {

    private final int sleepInterval = 200; //1000 msec = 1 SEK
    private boolean isRunning = true;
    private final static Object lockObject = new Object();

    public void requestShutDown() {

        isRunning = false;
    }

    @Override
    public void run() {
        while (isRunning) {
            synchronized (lockObject) {
                // Date current_date = new Date();
                //System.out.println(current_date.toString());
                Date d = new Date();
                System.out.print(Thread.currentThread().getName() + "  ");
                System.out.println(d.toString());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


