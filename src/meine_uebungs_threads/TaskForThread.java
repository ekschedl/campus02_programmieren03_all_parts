package meine_uebungs_threads;

// Diese Klasse ist ein Task (Aufgabe) für einen Thread.
// Sie implementiert das Runnable-Interface und muss deshalb die Methode run() definieren.
public class TaskForThread implements Runnable {
    @Override
    public void run() {
        // Eine Schleife, die 5-mal läuft
        for (int i = 1; i <= 5; i++) {
            // Gibt eine Nachricht mit Nummer aus
            System.out.println("hi , i am from TaskForThread, number  " + i);
            try {
                // Der Thread macht eine Pause von 1000 Millisekunden (1 Sekunde)
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // Wenn der Thread unterbrochen wird, erscheint diese Meldung
                System.out.println("Thread is disturbed");
            }
        }
    }
}