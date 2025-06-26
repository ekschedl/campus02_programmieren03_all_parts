package _THREADS___.Synchronized__SafeCounterWithWorkerThreads___sync;

public class Main {
    public static void main(String[] args) {
        SynchronizedSafeCounterWithWorkerThreads worker = new SynchronizedSafeCounterWithWorkerThreads();

        Thread t1 = new Thread(worker);
        Thread t2 = new Thread(worker);
        Thread t3 = new Thread(worker);

        t1.setName("Worker-1");
        t2.setName("Worker-2");
        t3.setName("Worker-3");

        t1.start();
        t2.start();
        t3.start();
    }
}
