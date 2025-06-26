package _THREADS___.Synchronized__TimeUndCounter_2threads_____sync;

public class Main {
    public static void main(String[] args) throws InterruptedException {
            Object syncObj = new Object(); // Gemeinsames Lock-Objekt

            MyObjectWithRunnableInterface worker1 = new MyObjectWithRunnableInterface();
            worker1.myObjVorSync = syncObj;

            MyObjectWithRunnableInterface worker2 = new MyObjectWithRunnableInterface();
            worker2.myObjVorSync = syncObj;

            Thread t1 = new Thread(worker1);
            Thread t2 = new Thread(worker2);

            t1.start();
            t2.start();

            Thread.sleep(5000); // 5 Sekunden laufen lassen

            worker1.requestShutdown();
            worker2.requestShutdown();

            t1.join();
            t2.join();

            System.out.println("Alle Threads beendet.");
        }
    }
