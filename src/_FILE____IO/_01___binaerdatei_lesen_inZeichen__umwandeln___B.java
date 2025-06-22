package _FILE____IO;

import java.io.FileInputStream;
import java.io.IOException;

public class _01___binaerdatei_lesen_inZeichen__umwandeln___B {
    public static void main(String[] args) throws IOException {

        // Öffnet eine Datei als Binär-Stream (byteweise)
        FileInputStream fis = new FileInputStream("eingabe.txt");

        int byteWert;

        // Liest jeden einzelnen Byte-Wert aus der Datei bis zum Ende (-1 = EOF)
        while ((byteWert = fis.read()) != -1) {

            // Wandelt jedes Byte in ein Zeichen (char) um und gibt es direkt aus
            char zeichen = (char) byteWert;
            System.out.print(zeichen); // Zeichen wird sofort auf Konsole ausgegeben
        }

        // Schließt die Datei
        fis.close();
    }
}