package _FILE____IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class _13_zeigeDatei_inBytes_Und_ZeichenMitIndex______B {

    public static void main(String[] args) throws IOException {
        // 🟡 Infoausgabe: Start des Programms
        System.out.println("UE13: Read Binary from file + ANZAHL der eingelesenen Zeichen");

        // 🔹 Datei-Objekt mit absolutem Pfad
        File file = new File("/Users/kaaatkina/CAMPUS02_2025/Programmieren_3/src/urls_extra_aufgaben.txt");

        // 🔹 Datei wird im Binärmodus geöffnet
        FileInputStream fis = new FileInputStream(file);

        // 🔹 Spaltenüberschrift für Ausgabe: Index, Dezimalwert, Zeichen
        System.out.println("1:" + "\t" + "DEZ" + " CHAR");

        int byteRead; // speichert jeweils ein Byte aus der Datei
        int count = 0; // zählt die Anzahl der eingelesenen Zeichen

        // 🔁 Schleife liest Zeichen bis zum Dateiende (-1)
        while ((byteRead = fis.read()) != -1) {
            System.out.println(count + ":\t" + byteRead + "\t" + (char) byteRead);
            count++;
        }

        // 🔚 Ausgabe der Gesamtanzahl gelesener Zeichen
        System.out.println("\nCount: " + count);
    }
}
// von herrn fuchs package at.campus02.pr3.fileio.binaryinput;
//
//import java.io.BufferedInputStream;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//
//public class ue_13{
//  /*
//    1. Schreiben Sie ein Programm, welches von einer Datei alle Zeichen auf der
//    Konsole ausgibt. (FileInputStream)
//    2.  Zählen Sie die Anzahl der eingelesenen Zeichen
//     und geben Sie die Gesamtanzahl am Ende aus.
//     */
//
//    public static void main(String[] args) throws IOException {
//
//        File file = new File("test-output.txt");
//        // FileInputStream stellt eine Verbindung zur Datei her. Datei wird geöffnet.
//        FileInputStream fileInputStream = new FileInputStream(file);
//        // Für Optimierung der Performance -> BufferedInputStream
//        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
//
//        // read() liefert Byte for Byte aus der Datei. Wenn das Ende erreicht ist, dann liefert die Methode -1 als Ergebnis.
//        // While-Schleife liest somit Zeichen um Zeichen aus.
//        int byteRead;
//        int character_count = 0;
//        while ((byteRead = bufferedInputStream.read()) != -1) {
//            // char[] ch = Character.toChars(byteRead);
//            // System.out.println(ch);
//            // Byte wird in char umgewandelt und ausgegeben.
//
//            if (!Character.isWhitespace((char) byteRead)) {
//                System.out.println((char) byteRead);
//                character_count++;
//            }
//        }
//
//        System.out.println(character_count);
//
//        // close() gibt die Datei wieder frei.
//        bufferedInputStream.close();
//    }
//}
