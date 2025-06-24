package _EXCEPTIONS____.ChainingDemo;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class UE_Exception_Chaining_me {
    public static void main(String[] args) {

        try {
            datenVerarbeiten();  // Start: ruft Methode, die später Exception wirft
        } catch (VerarbeitungsException_me e) {
            System.out.println("Fehler beim Verarbeiten: " + e.getMessage());
            e.printStackTrace();  // Vollständige Fehlerkette anzeigen (Chaining sichtbar)
        }
    }

    // Methode simuliert Datenverarbeitung
    public static void datenVerarbeiten() throws VerarbeitungsException_me {
        ladeDatenAusDatei();  // Datei wird geladen (oder auch nicht...)
    }

    // Methode versucht, Datei zu laden
    public static void ladeDatenAusDatei() throws VerarbeitungsException_me {
        try {
            FileReader fr = new FileReader("daten_nicht_existiert.txt");
        } catch (FileNotFoundException e) {
            // Chaining: eigene Exception werfen, Original-Fehler anhängen
            throw new VerarbeitungsException_me("Datei konnte nicht geladen werden", e);
        }
    }
}
/*✅ Was ist passiert:
	•	Du hast versucht, eine Datei daten_nicht_existiert.txt zu öffnen → Die Datei gibt es nicht
	•	Das löst FileNotFoundException aus (technischer Ursprung)
	•	Diese Exception hast du “gechained” → eigene VerarbeitungsException_me geworfen
	•	Dank e.printStackTrace() siehst du:
	•	Oben: Deine eigene Fehlermeldung "Datei konnte nicht geladen werden"
	•	Unten unter Caused by: Die tatsächliche technische Ursache → Datei fehlt
*/