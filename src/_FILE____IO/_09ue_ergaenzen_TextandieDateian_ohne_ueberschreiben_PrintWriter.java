package _FILE____IO;

// Importiert die Klassen, die für Dateioperationen benötigt werden
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class _09ue_ergaenzen_TextandieDateian_ohne_ueberschreiben_PrintWriter {

    public static void main(String[] args) throws IOException {

        // Gibt eine Info auf der Konsole aus
        System.out.println("UE 9: write to file");

        // Erstellt ein Dateiobjekt für die Datei "test.txt"
        File file = new File("test.txt");

        // Erstellt einen FileWriter, der an die Datei anhängt (append = true)
        // Dadurch wird NICHT überschrieben, sondern neue Zeilen kommen dazu
        FileWriter fw = new FileWriter(file, true);

        // Um bequemer Text schreiben zu können, wird ein PrintWriter verwendet
        PrintWriter pw = new PrintWriter(fw);

        // Schreibt zwei feste Zeilen in die Datei
        pw.println("Erste Zeile ");
        pw.println("Zweite Zeile ");

        // Wiederholt 10x und schreibt "Erste Zeile i" in jeder Zeile
        for (int i = 0; i < 10; i++) {
            pw.println("Erste Zeile " + i);
        }

        // Erzwingt das Schreiben aller Daten (falls noch im Zwischenspeicher)
        pw.flush();

        // Schließt den Writer und gibt die Datei frei
        pw.close();
    }
}