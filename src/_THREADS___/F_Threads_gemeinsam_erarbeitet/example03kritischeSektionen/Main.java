package _THREADS___.F_Threads_gemeinsam_erarbeitet.example03kritischeSektionen;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Mein von example03-kritische Sektionen starting.");
        Person p1 = new Person("Andreas");
        Person p2 = new Person("Person2");

        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);

        t1.start();
        t2.start();

        System.out.println("State t1: " + t1.getState());
        System.out.println("State t2: " + t2.getState());

        //Thread.sleep(1200);
        //p1.requestShutDown();
        //Thread.sleep(1200);
        //p2.requestShutDown();

        System.out.println("MAIN: Ende");
    }
}
