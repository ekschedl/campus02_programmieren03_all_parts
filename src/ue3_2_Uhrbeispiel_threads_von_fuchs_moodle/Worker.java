package ue3_2_Uhrbeispiel_threads_von_fuchs_moodle;

import java.util.Date;

public class Worker implements Runnable {

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
                System.out.print(Thread.currentThread().getName() + "[");
                System.out.print(d.toString());
                System.out.print(", CPUS: ");
                System.out.print(Runtime.getRuntime().availableProcessors());
                System.out.print(", FreeMem: ");
                System.out.print(Runtime.getRuntime().freeMemory());
                System.out.println("]");
                try {
                    Thread.sleep(sleepInterval);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


