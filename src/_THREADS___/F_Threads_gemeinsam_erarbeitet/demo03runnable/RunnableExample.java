package _THREADS___.F_Threads_gemeinsam_erarbeitet.demo03runnable;

public class RunnableExample implements Runnable {

    @Override
    public void run() {
        System.out.println("I am inside: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        System.out.println("Hello from Demo03: RunnableExample");
        System.out.println("Creating Runnable...");
        RunnableExample r1 = new RunnableExample();
        System.out.println("Creating Thread...");
        Thread t1 = new Thread(r1);
        System.out.println("done. Name of new Thread: " + t1.getName());
        System.out.println("Starting Thread...");
        t1.start(); //nicht t1.run() weil die funktion run() sonst
        System.out.println("Ich bin MAIN");
        System.out.println("Ich bin MAIN");
        System.out.println("Ich bin MAIN");
        System.out.println("Ich bin MAIN");
        System.out.println("Ich bin MAIN");
        System.out.println("Ich bin MAIN");
        System.out.println("Ich bin MAIN");
        System.out.println("Ich bin MAIN");
        System.out.println("Ich bin MAIN");
        System.out.println("Ich bin MAIN");
        System.out.println("Ich bin MAIN");
        //von dem main() Thread ausgeführt wird
    }
}

