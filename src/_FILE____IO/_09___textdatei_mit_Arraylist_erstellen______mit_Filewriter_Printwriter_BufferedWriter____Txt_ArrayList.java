package _FILE____IO;

//Schreiben Sie ein Programm, welches
// eine Textdatei mittels Filewriter und Printwriter erstellt.

//FileWriter = Grundwerkzeug,Er schreibt direkt in die Datei – Zeichen für Zeichen.ist eher „roh“ – du musst Zeilenumbrüche, Formatierung etc. selbst machen.
//PrintWriter =  eine Komfortklasse, die auf FileWriter aufbaut.
//Mit ihm kannst du einfach strukturierte Texte, Zahlen, Variablen, Zeilen usw. schreiben – fast wie mit System.out.println()!

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class _09___textdatei_mit_Arraylist_erstellen______mit_Filewriter_Printwriter_BufferedWriter____Txt_ArrayList {
    public static void main(String[] args) {
        // Zielpfad für die Datei (plattformunabhängig)
        String pfad = System.getProperty("user.home") + File.separator +
                "CAMPUS02_2025" + File.separator +
                "Programmieren_3" + File.separator + "dir_for_ue_09";

        // Datei-Objekt erstellen (Ordner + Dateiname)
        File myFile = new File(pfad, "lieblingstiere.txt");

        try {
            // PrintWriter auf Basis von FileWriter
            FileWriter fileWriter = new FileWriter(myFile);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            // Inhalte schreiben
            // Tiere in einem Array speichern
            String[] tiere = {"Katze", "Hund", "Eule", "Delfin"};

            // Überschrift schreiben
            printWriter.println("Meine Lieblingstiere:");

            // Schleife über das Array
            for (int i = 0; i < tiere.length; i++) {
                printWriter.println((i + 1) + ". " + tiere[i]);
            }

            // Writer schließen
            printWriter.close();

            System.out.println("Datei erfolgreich erstellt: " + myFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Fehler beim Schreiben in die Datei.");
            e.printStackTrace();
        }
    }
}

// ue _9 von Herrn Fuchs
//public class BeispielMitBufferedWriter {
//    public static void main(String[] args) {
//        // Datei erstellen und vorbereiten
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter("tiere_liste.txt"))) {
//
//            // Zeilen in einer Schleife schreiben
//            writer.write("Meine Lieblingstiere:");
//            writer.newLine();
//
//            String[] tiere = {"Katze", "Hund", "Eule", "Delfin"};
//
//            for (int i = 0; i < tiere.length; i++) {
//                writer.write((i + 1) + ". " + tiere[i]);
//                writer.newLine(); // Neue Zeile
//            }
//
//            // Optional: Schreibpuffer sofort leeren (nicht zwingend bei close())
//            writer.flush();
//
//            System.out.println("Fertig! Datei wurde erfolgreich geschrieben.");
//
//        } catch (IOException e) {
//            System.out.println("Fehler beim Schreiben in die Datei!");
//            e.printStackTrace();
//        }
//    }
//}