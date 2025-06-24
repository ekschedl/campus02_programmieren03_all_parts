package _EXCEPTIONS____;

import java.io.FileWriter;
import java.io.IOException;

public class ChainingBeispiel {

    public static void main(String[] args) {

        try {
            speichereDaten();
        } catch (RuntimeException e) {
            System.out.println("⚠️ Oberste Fehlermeldung: " + e.getMessage());

            // Originale Ursache anzeigen:
            System.out.println("💥 Ursprüngliche Ursache: " + e.getCause());
        }
    }

    // Methode: Fängt IOException ab, verpackt sie in RuntimeException
    public static void speichereDaten() {
        try {
            // Dateipfad ist ungültig → löst IOException aus
            FileWriter writer = new FileWriter("/ungültiger/pfad/datei.txt");
            writer.write("Test");
            writer.close();
        } catch (IOException ex) {
            // Hier CHAINING: neue Exception + ursprüngliche anhängen
            throw new RuntimeException("Speichern fehlgeschlagen!", ex);
        }
    }
}
/*✅ FileWriter kann eine IOException werfen, zum Beispiel wenn:
	•	Der Pfad nicht existiert
	•	Du keine Schreibrechte hast
	•	Die Festplatte voll ist

➡️ Das musst du technisch abfangen, weil IOException checked ist.

⸻

Warum throw new RuntimeException(..., ex)?
	•	RuntimeException ist unchecked → du musst sie im Methodenkopf nicht weitergeben
	•	Trotzdem willst du den ursprünglichen Fehler nicht verlieren
	•	Deswegen hängst du die Original-Exception mit ex an → das nennt man Exception Chaining
		•	"Oberste Meldung" → Deine eigene, verständliche Fehlerbeschreibung
	•	ex → Die technische Ursache (IOException), die drangehängt wird

⸻

Vorteil:
	•	Außenstehender Code sieht beides:
	•	Deine klare Meldung
	•	Die ursprüngliche Ursache mit allen Details (z.B. Pfad ungültig)
*/
