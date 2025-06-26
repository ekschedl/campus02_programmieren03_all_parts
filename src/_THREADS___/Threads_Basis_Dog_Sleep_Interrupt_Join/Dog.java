package _THREADS___.Threads_Basis_Dog_Sleep_Interrupt_Join;

import java.io.Serializable;

// Die Klasse Dog erweitert Animal und implementiert Runnable, damit Dog als Thread laufen kann
public class Dog extends Animal implements Runnable {

    // Steuerungs-Flag, das bestimmt, ob die Endlosschleife weiterlaufen soll
    private boolean isRunning = true;

    // Methode, um den Thread von außen sauber zu beenden
    public void requestShutdown() {
        System.out.print("Request shutdown wurde von folgendem Thread ausgeführt:");
        System.out.println(Thread.currentThread().getName());
        isRunning = false; // Flag setzen → Schleife im run() wird beendet
    }

    @Override
    public void run() {
        // Begrüßungsausgabe → zeigt, dass dieser Thread läuft
        System.out.println("Dog: Hallo ich bin ein Dog und ein Thread gleichzeitig");

        // Aktuellen Thread-Namen ausgeben
        System.out.println("Dog: Mein Thread Name: " + Thread.currentThread().getName());

        // Endlosschleife, die läuft, solange isRunning true ist
        while (isRunning == true) {

            try {
                // Simuliert Arbeit → alle 500ms kurze Pause
                System.out.println("Dog: Ich arbeite gerade! Solange isRunning == true.");
                Thread.sleep(500); // Thread pausiert für 500ms
            } catch (InterruptedException e) {
                // Wenn der Thread im Schlaf unterbrochen wird, bricht er sauber ab
                System.out.println("Dog: mein Schlaf wurde unterbrochen!");
                break; // Schleife beenden
            }
        }

        // Abschlussmeldung, wenn Thread beendet wird
        System.out.println("Dog: ich beende mich.");
    }
}