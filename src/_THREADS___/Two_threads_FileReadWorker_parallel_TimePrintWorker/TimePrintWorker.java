package _THREADS___.Two_threads_FileReadWorker_parallel_TimePrintWorker;

import java.util.Date;
public class TimePrintWorker extends Worker implements Runnable {

    public TimePrintWorker(String name) {
        super(name);
    }

    @Override
    protected void work() {
        printStarted();

        while (shouldRun) {
            Date d = new Date();
            System.out.println(name + " Uhrzeit: " + d.toString());

            try {
                Thread.sleep(1000); // Jede Sekunde ausgeben
            } catch (InterruptedException e) {
                System.out.println(name + ": wurde unterbrochen.");
                break;
            }
        }

        printStopped();
    }

    @Override
    public void run() {
        work();
    }
}