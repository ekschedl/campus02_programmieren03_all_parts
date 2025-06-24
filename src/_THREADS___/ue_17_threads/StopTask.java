package _THREADS___.ue_17_threads;

public class StopTask implements Runnable {

    boolean stooped = false;


    public void makeStop() {
        stooped = true;

    }


    @Override
    public void run() {
        while (!stooped) {
            System.out.println("Arbeite ..." + Thread.currentThread().getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Thread " + Thread.currentThread().getName() + " wurde gestoppt.");

    }
}
