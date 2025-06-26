package _THREADS___;

public class ThreadMethods_mehr implements Runnable {

    @Override
    public void run() {
        // Name setzen und ausgeben
        System.out.println("[" + Thread.currentThread().getName() + "] läuft mit Priorität " + Thread.currentThread().getPriority());

        // Kurze Pause
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("[" + Thread.currentThread().getName() + "] wurde unterbrochen.");
        }

        System.out.println("[" + Thread.currentThread().getName() + "] ist fertig.");
    }

    public static void main(String[] args) {
        System.out.println("[Hauptthread] startet.");

        // Runnable-Objekt erstellen
        Runnable runnable = new ThreadMethods_mehr();

        // Thread erstellen und starten
        Thread t1 = new Thread(runnable);
        t1.setName("Arbeiter1");
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();

        // Zweiten Thread starten
        Thread t2 = new Thread(runnable);
        t2.setName("Arbeiter2");
        t2.setPriority(Thread.MIN_PRIORITY);
        t2.start();

        // Status prüfen
        System.out.println("Lebt " + t1.getName() + "? " + t1.isAlive());
        System.out.println("Lebt " + t2.getName() + "? " + t2.isAlive());

        try {
            // Auf das Ende von t1 warten
            t1.join();
            System.out.println(t1.getName() + " ist jetzt beendet.");

            // Auf das Ende von t2 warten
            t2.join();
            System.out.println(t2.getName() + " ist jetzt beendet.");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("[Hauptthread] Alle Threads sind fertig.");
    }
}

/*
Zusammenfassung genutzter Methoden:
- setName(): Thread bekommt eigenen Namen
- getName(): Gibt den Namen zurück
- setPriority(): Priorität setzen (1 bis 10)
- getPriority(): Gibt die gesetzte Priorität zurück
- start(): Thread wird gestartet
- isAlive(): Prüft, ob Thread noch läuft
- join(): Hauptthread wartet, bis anderer Thread fertig ist
- sleep(): Lässt Thread pausieren
- interrupt(): Könnte einen schlafenden Thread unterbrechen (nicht aktiv hier)
*/