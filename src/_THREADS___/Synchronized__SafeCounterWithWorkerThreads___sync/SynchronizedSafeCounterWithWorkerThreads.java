package _THREADS___.Synchronized__SafeCounterWithWorkerThreads___sync;

/*
✅ counter ist static, deshalb teilen ihn alle Threads
✅ synchronized sichert ab, dass nur 1 Thread gleichzeitig zählt
✅ Threads erhöhen sauber bis 20, dann bricht jeder für sich die Schleife ab
✅ Thread.sleep(1000) simuliert sinnvolle Pausen, wirkt wie „langsames Zählen“
✅ Ausgabe zeigt dir klar, welcher Thread wann zählt
 */
public class SynchronizedSafeCounterWithWorkerThreads implements Runnable {
    private static int counter = 0;
    // Statischer Counter: Alle Threads teilen sich denselben Wert

    @Override
    public void run() {
        while (true) {
            // Endlosschleife - wird nur durch break verlassen, sobald counter >= 20

            synchronized (SynchronizedSafeCounterWithWorkerThreads.class) {
                // Kritische Sektion: Nur EIN Thread darf hier gleichzeitig hinein
                if (counter >= 20) {
                    break;
                    // Wenn Ziel (20) erreicht, Schleife beenden
                }
                counter++;
                // Counter sicher erhöhen
                System.out.println("[" + Thread.currentThread().getName() + "] Counter: " + counter);
                // Aktuellen Stand + Threadname ausgeben
            }

            try {
                Thread.sleep(1000);
                // 1 Sekunde Pause, bevor nächster Schleifendurchlauf startet
            } catch (InterruptedException e) {
                e.printStackTrace();
                // Falls der Thread im Schlaf unterbrochen wird, Fehler ausgeben
            }
        }
    }
}