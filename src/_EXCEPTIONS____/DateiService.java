package _EXCEPTIONS____;

import java.io.IOException;

public class DateiService {

    // Methode kündigt mit "throws" an, dass hier eine IOException möglich ist
    public void ladeDatei(String dateiname) throws IOException {

        // Simulierter Check: Datei existiert nicht
        if (dateiname == null || dateiname.isEmpty()) {
            // Hier wird die Exception tatsächlich "geworfen"
            throw new IOException("Dateiname ungültig oder leer!");
        }

        System.out.println("✅ Datei wird geladen: " + dateiname);
    }

    public static void main(String[] args) {
        DateiService ds = new DateiService();

        try {
            ds.ladeDatei("");  // Leerer Dateiname provoziert Fehler
        } catch (IOException e) {
            System.out.println("❌ Fehler beim Laden: " + e.getMessage());
        }
    }
}

/*Ablauf:

✅ Die Methode ladeDatei() kündigt im Kopf mit throws IOException an: Achtung, hier kann was schiefgehen.
✅ Im Code wird mit throw new IOException(...) die Ausnahme tatsächlich ausgelöst.
✅ Im main() fangen wir den Fehler ab mit try-catch.*/