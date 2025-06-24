package _THREADS___.ue_17_threads;

public class MainThreadsMeineUebungen {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hauptthread: " + Thread.currentThread().getName());

        Thread t1 = new Thread(() -> {
            System.out.println("Ich bin: " + Thread.currentThread().getName());
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            System.out.println("Ich bin: " + Thread.currentThread().getName());
        });
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("t1 und t2 fertig und nun läuft:" + Thread.currentThread().getName());
        System.out.println(t1.threadId());

        StopTask stopTask1 = new StopTask();
        Thread t3 = new Thread(stopTask1);
        t3.start();
        Thread.sleep(5000);
        stopTask1.makeStop();
    }
}
