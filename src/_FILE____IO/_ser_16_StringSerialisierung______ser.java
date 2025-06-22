package _FILE____IO;

import java.io.*;

public class _ser_16_StringSerialisierung______ser {
    public static void main(String[] args) {

        String text = "Hallo Welt";  // Das zu speichernde String-Objekt
        String dateiname = "ue_16_object.dat";  // Name der Zieldatei

        // 🔹 SCHREIBEN: String-Objekt serialisieren und speichern
        try {
            FileOutputStream fos = new FileOutputStream(dateiname);              // Verbindung zur Datei
            ObjectOutputStream oos = new ObjectOutputStream(fos);                // Objekt-Stream zum Schreiben
            oos.writeObject(text);                                               // Objekt schreiben
            oos.close();                                                         // Stream schließen
            System.out.println("✅ Objekt wurde serialisiert und gespeichert.");
        } catch (IOException e) {
            System.out.println("❌ Fehler beim Schreiben: " + e.getMessage());
        }

        // 🔹 LESEN: String-Objekt aus Datei laden und anzeigen
        try {
            FileInputStream fis = new FileInputStream(dateiname);               // Verbindung zur Datei
            ObjectInputStream ois = new ObjectInputStream(fis);                 // Objekt-Stream zum Lesen
            String gelesen = (String) ois.readObject();                         // Objekt lesen und casten
            ois.close();                                                        // Stream schließen
            System.out.println("📄 Gelesenes Objekt: " + gelesen);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("❌ Fehler beim Lesen: " + e.getMessage());
        }
    }
}
