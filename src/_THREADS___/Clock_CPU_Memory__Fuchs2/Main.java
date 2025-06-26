package _THREADS___.Clock_CPU_Memory__Fuchs2;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello world2!");

        //erstelle ein eindeutiges Objekt, das zur synchronisation verwendet werden kann
        Object mySyncObjFromMain = new Object();

        MyObjectWithRunnableInterface mowri1 = new MyObjectWithRunnableInterface();
        MyObjectWithRunnableInterface mowri2 = new MyObjectWithRunnableInterface();

        //gebe das sync-Objekt an beide Thread-Objekte,
        //damit sie nicht gleichzeitig in die kritische Sektion
        //gehen, sondern warten
        mowri1.mySyncObj = mySyncObjFromMain;
        mowri2.mySyncObj = mySyncObjFromMain;

        Thread myThread = new Thread(mowri1);
        Thread myThread2 = new Thread(mowri2);
        myThread.start();
        myThread2.start();

        //auf tastendruck warten
        Scanner scanner = new Scanner(System.in);
        String enterKey = scanner.nextLine(); //warte hier
        if(enterKey.isEmpty())
        {
            System.out.println("Main: requesting Shutdown.");
            //Version 1: eigene Funktion
            //mowri.requestShutdown();
            //Version 2: eingebaute intterupt() Funktion
            myThread.interrupt();
            myThread2.interrupt();


        }
        myThread.join(); // warte auf Beenden von myThread
        System.out.println("Main: terminating.");
    }
}