package _FILE____IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class _13_zeigeDatei_inBytes_Und_ZeichenMitIndex______B {

    public static void main(String[] args) throws IOException {
        // 🟡 Infoausgabe: Start des Programms
        System.out.println("UE13: Read Binary from file + ANZAHL der eingelesenen Zeichen");

        // 🔹 Datei-Objekt mit absolutem Pfad
        File file = new File("/Users/kaaatkina/CAMPUS02_2025/Programmieren_3/test2.txt");

        // 🔹 Datei wird im Binärmodus geöffnet
        FileInputStream fis = new FileInputStream(file);

        // 🔹 Spaltenüberschrift für Ausgabe: Index, Dezimalwert, Zeichen
        System.out.println("Nr:" + "\t" + "DEZ" + " CHAR");

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

