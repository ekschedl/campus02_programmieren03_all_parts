package ue_18_threads_with_stop;

public class Counter {
    public int count = 0;

    public synchronized void increment() {
        count++;
        System.out.println("[" + Thread.currentThread().getName() + "] Wert: " + count);

    }

    public int getCount() {
        return count;
    }
}
