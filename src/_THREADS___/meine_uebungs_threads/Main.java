package _THREADS___.meine_uebungs_threads;

public class Main {
    public static void main(String[] args) {
        // Erstelle eine Instanz der Aufgabe (Runnable)
        TaskForThread task1 = new TaskForThread();
        // Erstelle einen Thread mit der Aufgabe
        Thread myThread = new Thread(task1);
        // Starte den Thread (führt task1.run() im Hintergrund aus)
        myThread.start();

        // Der Haupt-Thread läuft parallel weiter
        System.out.println("Hi from Main");

        // Erstelle eine zweite Aufgabe
        TaskNameforThread taskName = new TaskNameforThread();
        // Erstelle einen zweiten Thread mit der zweiten Aufgabe
        Thread myThread2 = new Thread(taskName);
        // Starte auch den zweiten Thread
        myThread2.start();

        TaskWordOne task3=new TaskWordOne();
        Thread myThread3= new Thread(task3);
        myThread3.start();

        TaskWordTwo task4=new TaskWordTwo();
        Thread myThread4= new Thread(task4);
        myThread4.start();

    }
}