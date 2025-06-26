package _THREADS___;

public class ThreadExample extends Thread {
    public void run() {
        System.out.println("thread is running...");
    }

    public static void main(String args[]) {
        ThreadExample t1 = new ThreadExample();
        t1.start();
        ThreadExample t2 = new ThreadExample();
        t2.start();
    }
}