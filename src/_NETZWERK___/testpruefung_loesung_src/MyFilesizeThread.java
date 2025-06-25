
package _NETZWERK___.testpruefung_loesung_src;

import java.io.File;

public class MyFilesizeThread implements Runnable {

    File logfileFromMain;  // Referenz auf die Logdatei, kommt vom Main-Programm

    public MyFilesizeThread(File logfileToSize) {
        this.logfileFromMain = logfileToSize;  // Übergabe der Logdatei an das Thread-Objekt
    }

    @Override
    public void run() {
        // Solange Thread nicht unterbrochen wurde, läuft die Schleife weiter
        while (!Thread.interrupted()) {
            //Alternative wäre: neue File-Instanz, hier wird aber direkt das übergebene File verwendet
            // File localLogFile = new File("logfile.txt");
            System.out.println("FILSIZE: " +
                    //localLogFile.length() + "( i am thread)" +
                    logfileFromMain.length() +  // Zeigt aktuelle Dateigröße an (in Bytes)
                    " (Name:  " + Thread.currentThread().getName() + ")");  // Gibt auch den Namen des Threads aus

            try {
                Thread.sleep(5000);  // Thread schläft 5 Sekunden, dann wieder Dateigröße prüfen
            } catch (InterruptedException e) {
                System.out.println("Schlaf wurde unterbrochen, beende mich.");
                //Wenn der Schlaf unterbrochen wird (z.B. durch interrupt()), beendet sich der Thread sauber
                //throw new RuntimeException(e);

                //wrapping would be: (down not work here, but in priciple)
                //throw new LogFileException(e.getMessage());

                //Anmerkung: Hier könnte theoretisch auch eine eigene Exception geworfen werden
                //throw new LogFileException(e.getMessage());  // Beispiel für Exception-Wrapping (funktioniert hier nicht direkt)
                break;

            }
        }
    }
}