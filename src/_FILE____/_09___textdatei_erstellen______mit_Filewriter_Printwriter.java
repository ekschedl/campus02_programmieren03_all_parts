package _FILE____;

//Schreiben Sie ein Programm, welches
// eine Textdatei mittels Filewriter und Printwriter erstellt.

//FileWriter = Grundwerkzeug,Er schreibt direkt in die Datei – Zeichen für Zeichen.ist eher „roh“ – du musst Zeilenumbrüche, Formatierung etc. selbst machen.
//PrintWriter =  eine Komfortklasse, die auf FileWriter aufbaut.
//Mit ihm kannst du einfach strukturierte Texte, Zahlen, Variablen, Zeilen usw. schreiben – fast wie mit System.out.println()!

//pw.println("Hallo")
//	schreibt den Text + automatisch einen Zeilenumbruch
// 	entspricht also: "Hallo\n" (bei Windows: "Hallo\r\n")

//pw.write("Hallo")
//schreibt nur den Text, ohne Zeilenumbruch
//du musst \n selbst hinzufügen, wenn du möchtest, Wenn du danach noch etwas schreibst, kommt es direkt dahinter auf der gleichen Zeile:


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class _09___textdatei_erstellen______mit_Filewriter_Printwriter {
    public static void main(String[] args) throws IOException {
        //angeben Pfad zu einem Verzeichnis:
        //erstelle ein File-Objekt für den Ordner, in dem meine Datei gespeichert werden soll
        File pathToMyFile = new File("/Users/kaaatkina/CAMPUS02_2025/Programmieren_3/dir_for_ue_09");

        // gleich prüfen, ob der Ordner existiert oder ihn mit mkdirs() erstellen
        if (!pathToMyFile.exists()) {
            pathToMyFile.mkdirs();
        }

        //new File erstellt daraus ein vollständiges File-Objekt mit Pfad + Name
        File myFile = new File(pathToMyFile, "textdatei_for_ue_09.txt");


        // Writer vorbereiten – PrintWriter mit FileWriter als Basis
        //Warum:PrintWriter bietet println(), printf()
        FileWriter fileWriter = new FileWriter(myFile); //FileWriter erwartet eine Datei, keinen Ordner.
        PrintWriter printWriter = new PrintWriter(fileWriter);

        // Jetzt schreiben:
        printWriter.println("Hallo Welt");         // erste Zeile
        printWriter.println("Ich liebe Sommer");   // zweite Zeile


        printWriter.write("Text mit write()");
        printWriter.write(" ← das ist ohne Zeilenumbruch");

        printWriter.println();  // manuell eine leere Zeile

        printWriter.println("Text mit println()");
        printWriter.println("← das ist mit Zeilenumbruch");
        // Am Ende: beide schließen
        printWriter.close(); // Schließt auch den FileWriter automatisch
    }


}
