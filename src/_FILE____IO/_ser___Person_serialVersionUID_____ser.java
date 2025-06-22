package _FILE____IO;
//implements Serializable
//Macht die Klasse speicherbar
//serialVersionUID = 1L
//Verhindert Fehler bei Änderungen der Klasse
//ObjectOutputStream
//Speichert das Objekt in Datei
//ObjectInputStream
//Liest Objekt wieder aus Datei
//beruf (neues Feld)
//kann hinzugefügt werden – solange serialVersionUID gleich bleibt
import java.io.*;

// 💡 Die Klasse soll gespeichert und später wieder geladen werden
public class _ser___Person_serialVersionUID_____ser implements Serializable {

    // ⚠️ Wichtig: Wir setzen die serialVersionUID manuell, damit bei späteren Änderungen
    // die alte Version beim Laden nicht als inkompatibel gilt.
    private static final long serialVersionUID = 1L;

    private String name;
    private int alter;

    // ✨ NEUES FELD (kann später hinzugefügt werden, ohne dass es kracht!)
    private String beruf;

    // Konstruktor
    public _ser___Person_serialVersionUID_____ser(String name, int alter, String beruf) {
        this.name = name;
        this.alter = alter;
        this.beruf = beruf;
    }

    // Ausgabe
    public String toString() {
        return name + ", " + alter + " Jahre, Beruf: " + beruf;
    }

    // 👉 Methode: Objekt serialisieren (= speichern)
    public static void speichern(_ser___Person_serialVersionUID_____ser p, String dateiname) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dateiname));
        oos.writeObject(p);
        oos.close();
        System.out.println("✅ Objekt gespeichert.");
    }

    // 👉 Methode: Objekt wieder laden (= deserialisieren)
    public static _ser___Person_serialVersionUID_____ser laden(String dateiname) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dateiname));
        _ser___Person_serialVersionUID_____ser p = (_ser___Person_serialVersionUID_____ser) ois.readObject();
        ois.close();
        return p;
    }

    // Hauptmethode zum Testen
    public static void main(String[] args) {
        try {
            // Objekt erzeugen
            _ser___Person_serialVersionUID_____ser person = new _ser___Person_serialVersionUID_____ser("Katja", 25, "Entwicklerin");

            // 1️⃣ Objekt speichern
            speichern(person, "person.ser");

            // 2️⃣ Objekt laden
            _ser___Person_serialVersionUID_____ser geladenePerson = laden("person.ser");
            System.out.println("🔄 Geladenes Objekt: " + geladenePerson);

        } catch (Exception e) {
            System.out.println("❌ Fehler: " + e.getMessage());
        }
    }
}
