package _THREADS___;

public class ThreadMethods_sleep_prio implements Runnable {
    @Override
    public void run() {
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        System.out.println("Prio of Thread is " + Thread.currentThread().getPriority());
    }

    public static void main(String[] args) {
        ThreadMethods_sleep_prio tm = new ThreadMethods_sleep_prio();
        Thread thread = new Thread(tm);
        thread.start();
        try {
            thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread Running");
    }
}
