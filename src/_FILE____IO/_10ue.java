package _FILE____IO;

import java.io.*;

//1. Liest Benutzereingaben über die Konsole.
// 2.	Jede Eingabe wird sofort in die Datei test.txt geschrieben.
// 3.	Wenn der Benutzer „STOP“ eingibt, wird die Eingabe beendet.
// 4.	Danach wird der Writer sauber geschlossen.

public class _10ue {
    public static void main(String[] args) throws IOException {

        System.out.println("UE 10"); // Gibt einen Start-Hinweis aus

        // InputStreamReader und BufferedReader für die Eingabe von System.in
        InputStreamReader inputStreamReader = new InputStreamReader(System.in); // Wandelt Byte-Stream (System.in) in Zeichen um
        BufferedReader br = new BufferedReader(inputStreamReader); // BufferedReader erlaubt bequemes zeilenweises Lesen

        String line = br.readLine(); // Liest erste Benutzereingabe von der Konsole

//Öffne file <UE9

        File f = new File("ue10.txt"); // Erstellt ein File-Objekt für die Datei "test.txt"
        FileWriter fw = new FileWriter(f, true); //append true damit es  dazugeschrieben wird, nicht überschreibt
        PrintWriter pw = new PrintWriter(fw); // Ermöglicht einfaches Schreiben in die Datei

        // Solange der Benutzer nicht "STOP" eingibt (unabhängig von Groß-/Kleinschreibung)
        while (!line.equalsIgnoreCase("STOP")) {
            System.out.println("read"); // Konsolenausgabe zur Info
            pw.println(line); // Schreibt die aktuelle Eingabezeile in die Datei
            line = br.readLine(); // Liest nächste Zeile vom Benutzer ein
        }

        pw.flush(); // Schreibt evtl. noch im Speicher gepufferte Daten raus
        pw.close(); // Schließt den Writer und gibt die Datei frei

    }
}