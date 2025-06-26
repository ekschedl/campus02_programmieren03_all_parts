package _THREADS___.F_Threads_gemeinsam_erarbeitet.demo02startThreadTwice;

public class ThreadStartTwice extends Thread {
    public void run() {
        System.out.print("Hello world! This is demo02. ");
        Thread aktuelleFaden = Thread.currentThread();
        System.out.println("I am inside: " + aktuelleFaden.getName());
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadStartTwice t1 = new ThreadStartTwice();
        t1.start();
        ThreadStartTwice t2 = new ThreadStartTwice();
        t2.start();
        t2.start();
    }
}