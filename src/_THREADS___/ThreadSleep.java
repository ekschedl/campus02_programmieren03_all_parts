package _THREADS___;

public class ThreadSleep extends Thread {

    @Override
    public void run() {
        // Schleife läuft 4-mal
        for (int i = 1; i < 5; i++) {
            try {
                // Thread pausiert 2000 Millisekunden = 2 Sekunden
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // Falls der Thread während des Schlafens unterbrochen wird
                System.out.println(e);
            }
            // Ausgabe: Name des aktuellen Threads + Zählerstand
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public void print() {
        System.out.println("Testausgabe");
    }

    public static void main(String[] args) {
        /*
         * Wichtiger Unterschied:
         * - Wenn man die run()-Methode direkt aufruft → ganz normales Methodenverhalten, kein Multithreading
         * - Wenn man start() aufruft → ein eigener Thread wird erzeugt, run() läuft parallel zum Hauptprogramm
         *
         * start() sorgt dafür, dass das Betriebssystem dem Thread eigene Rechenzeit gibt
         * Dadurch können mehrere Threads quasi gleichzeitig laufen
         */

        // Zwei eigene Threads werden erstellt
        ThreadSleep t1 = new ThreadSleep();
        ThreadSleep t2 = new ThreadSleep();

        // Beide Threads starten, sie laufen unabhängig voneinander
        t1.start();
        t2.start();
    }
}
/*Wichtig:
	•	start() → Erzeugt neuen Thread, run() wird von diesem Thread parallel ausgeführt
	•	sleep() → Lässt den aktuellen Thread für die angegebene Zeit pausieren
	•	Thread.currentThread().getName() → Gibt den Namen des aktuell laufenden Threads zurück
*/