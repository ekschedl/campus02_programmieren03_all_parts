package _NETZWERK___.localServer_Client_mit_HintergrundThread;

import java.io.BufferedWriter;
import java.io.IOException;

public class WorkerThread implements Runnable {

    private BufferedWriter out;

    public WorkerThread(BufferedWriter out) {
        this.out = out;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                // Nachricht an Server senden
                out.write("Hintergrund-Thread: Ich lebe noch!");
                out.newLine();
                out.flush();

                // Warte 2 Sekunden
                Thread.sleep(2000);
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Hintergrund-Thread wurde unterbrochen oder Verbindung beendet.");
        }
    }
}