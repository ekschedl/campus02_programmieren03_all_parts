package _FILE____IO;


// Wichtig:
//        •	FileWriter überschreibt die Datei, wenn sie schon existiert.
//        •	Wenn du anhängen willst (statt überschreiben):
//        new FileWriter(datei, true)


//Schreiben Sie ein Programm, das Ihre Noten aus allen Fächern im ersten Semester
// von der Konsole einliest und anschließend als „.txt“ Datei speichert.
//Beispiel:
//        - PR1: 1
//        - Englisch: 1
//Die Eingabe endet, wenn das Wort „STOP“ eingegeben wird.
//Verwenden Sie die Klassen BufferedReader, InputStreamReader und FileWriter
//
//Damit das klappt, brauchst du:
// Diese drei Klassen:
//        •	InputStreamReader – übersetzt die Eingaben von der Tastatur (System.in) in lesbare Zeichen.
//        •	BufferedReader – erlaubt dir, ganze Zeilen einzulesen (z. B. PR1: 1) mit readLine().
//        •	FileWriter – später speichern wir alle Eingaben damit in eine Textdatei.

import java.io.*;

public class _10___konsole_notenEingabe_ToFile {

    public static void main(String[] args) throws IOException {

        // Schritt 1: Eingabe vorbereiten
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);  // verbindet Tastatur mit Reader
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);   // ermöglicht zeilenweises Lesen


        // Schritt 2: Datei vorbereiten
        //Wenn du die Datei in einem bestimmten Ordner speichern willst, dann musst du beim new File(...) einfach den kompletten Pfad angeben – nicht nur den Dateinamen.
        File myDatei = new File("src/noten_semester.txt"); // die Datei wird im Projektordner erstellt
        FileWriter fileWriter = new FileWriter(myDatei); // schreibt von oben nach unten,// Achtung: überschreibt Datei
        // Optional: new FileWriter(myDatei, true); // → Anhängen statt überschreiben


        // Schritt 3: Eingabe lesen & in Datei schreiben
        System.out.println("Bitte gib deine Noten ein (Schreibe 'STOP' zum Beenden):");
        String eingegebeneZeile = bufferedReader.readLine(); // erste Eingabe holen

        while (!eingegebeneZeile.equalsIgnoreCase("stop")) {  // solange kein STOP
            fileWriter.write(eingegebeneZeile + "\n");            // Zeile ausgeben
            eingegebeneZeile = bufferedReader.readLine();     // nächste Eingabe holen
        }


        // Schritt 4: Ressourcen schließen
        fileWriter.close();
        bufferedReader.close();
        System.out.println("Eingabe beendet.");

    }
}



//public class Aufgabe1_SpeichernVonKonsole {
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter writer = new PrintWriter(new FileWriter("eingabe.txt"));
//
//        System.out.println("Bitte gib deine Texte ein (STOP beendet):");
//
//        String zeile;
//        while (!(zeile = reader.readLine()).equalsIgnoreCase("STOP")) {
//            writer.println(zeile);
//        }
//
//        writer.close();
//        reader.close();
//        System.out.println("Eingabe gespeichert.");
//    }
//}