package _NETZWERK___.chat_homework;

public class LogWatcher implements Runnable {

    private final java.io.File file; // Das ist die Datei, die beobachtet wird
    private volatile boolean isRunning = true; // volatile = andere Threads sehen Änderungen sofort//Damit der Hauptthread die Änderung sofort sieht

    // Konstruktor – wenn ich einen LogWatcher erstelle, gebe ich den Pfad zur Datei mit
    public LogWatcher(String filePath) {
        // Wir merken uns die Datei, die beobachtet werden soll
        this.file = new java.io.File(filePath);
    }

    @Override
    public void run() {
        // Solange isRunning true ist → immer weiter ausführen
        while (isRunning) {
            long size = file.length(); // Dateigröße in Bytes in variable speichern
            System.out.println("Dateigröße von chat_log.txt: " + size + " Bytes"); // und es (size) in der Konsole zeigen

            try {
                // Ich warte 5 Sekunden, bevor ich nochmal prüfe – sonst wäre es zu schnell
                Thread.sleep(5000); // 5 Sekunden warten
            } catch (InterruptedException e) {
                System.out.println(" LogWatcher unterbrochen.");
                break; // Sicher beenden
            }
        }

    }

    // Diese Methode kann von außen aufgerufen werden, um den Thread höflich zu stoppen//Wird später vom Hauptprogramm aufgerufen, um isRunning = false zu setzen
    public void hoefflichStoppen() {
        isRunning = false;
    }
}