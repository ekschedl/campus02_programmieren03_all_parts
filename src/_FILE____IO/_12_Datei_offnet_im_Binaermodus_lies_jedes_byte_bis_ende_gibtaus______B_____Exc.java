package _FILE____IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class _12_Datei_offnet_im_Binaermodus_lies_jedes_byte_bis_ende_gibtaus______B_____Exc {

    public static void main(String[] args) throws IOException { // Methode main startet das Programm, IOException wird weitergegeben
        System.out.println("UE12: Read Binary from file"); // Gibt Info auf der Konsole aus

        // Erstellt ein File-Objekt mit absolutem Pfad zur Datei "test2.txt"
        File file = new File("ue_12_text_Byte_fuer_byte.txt");

        // Erstellt einen FileInputStream, um die Datei byteweise zu lesen
        FileInputStream fis = new FileInputStream(file);

        int byteRead; // Speichert jeweils das aktuell gelesene Byte (als int-Wert)

        // Liest solange Bytes aus der Datei, bis -1 (Ende der Datei) erreicht ist
        while ((byteRead = fis.read()) != -1) {
            // Gibt den gelesenen Byte-Wert (Zahl 0–255) mit Leerzeichen aus
            System.out.print(byteRead + " ");
        }


        fis.close(); // ← Sehr wichtig: schließt den FileInputStream korrekt!
    }
}

