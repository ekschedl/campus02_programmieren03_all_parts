package _EXCEPTIONS____.ChainingDemo;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Chaining_Main {
    public static void main(String[] args) {

        try {
            ladeDatei();  // Wir rufen die Methode auf, die intern einen Fehler verursacht
        } catch (MeineException e) {
            System.out.println("⚠️ Fehler erkannt: " + e.getMessage());
            e.printStackTrace();  // Zeigt alle verschachtelten Fehler (StackTrace)
        }
    }

    public static void ladeDatei() throws MeineException {
        try {
            // Beispiel: Datei existiert nicht
            FileReader reader = new FileReader("nicht_existiert.txt");
        } catch (FileNotFoundException ex) {
            // Hier verpacken wir die Original-Exception in unsere eigene Exception
            throw new MeineException("Datei konnte nicht geladen werden", ex);
        }
    }
}
