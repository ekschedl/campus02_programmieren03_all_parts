package _THREADS___.F_Threads_gemeinsam_erarbeitet.example01Person;

public class Main {
    public static void main(String[] args)  {
        Runnable p1 = new Person("Andreas");
        Runnable p2 = new Person("Person2");

        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);

        t1.start();
        t2.start();

        try {
            System.out.println("MAIN: Warte auf Thread 1...");
            t1.join();
            System.out.println("MAIN: Warte auf Thread 2...");
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("MAIN: Ende");
    }
}
