package _THREADS___.Two_threads_FileReadWorker_parallel_TimePrintWorker;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileReadWorker extends Worker implements Runnable {

    private String path;               // Pfad zur Textdatei
    public ArrayList<String> lines;    // Speicher für die gelesenen Zeilen

    public FileReadWorker(String name, String path) {
        super(name);                   // Name an Basisklasse übergeben
        this.path = path;
        this.lines = new ArrayList<>();
    }

    @Override
    public void run() {
        work();
    }

    @Override
    protected void work() {
        printStarted(); // Startmeldung

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (!shouldRun) {
                    System.out.println(name + ": Lesevorgang abgebrochen.");
                    break;
                }

                lines.add(line); // Zeile speichern
                System.out.println(name + ": Gelesen -> " + line);

                try {
                    Thread.sleep(500); // künstliche Verzögerung
                } catch (InterruptedException e) {
                    System.out.println(name + ": Unterbrochen.");
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println(name + ": Fehler beim Lesen der Datei.");
            e.printStackTrace();
        }

        printStopped(); // Endmeldung
    }
}
