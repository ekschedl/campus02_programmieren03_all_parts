package _FILE____IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Textdatei_Mit_Gewuenschter_Kodierung_Lesen________K {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Dateiname mit Umlauten oder Sonderzeichen
        String dateiname = "umlaute_kodierung_via_scanner_waehlen.txt";

        System.out.print("Bitte gewünschte Kodierung eingeben (UTF-8 oder ISO-8859-1): ");
        String kodierung = scanner.nextLine();

        // Dateigröße vorher ausgeben
        dateigroesseInBytesAusgeben(dateiname);

        dateiEinlesenMitKodierung(dateiname, kodierung);
    }

    // Liest die Datei zeilenweise mit der angegebenen Zeichenkodierung
    public static void dateiEinlesenMitKodierung(String dateipfad, String kodierung) {
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(dateipfad), kodierung));

            System.out.println("\n📄 Inhalt der Datei mit Kodierung " + kodierung + ":");
            String zeile;
            while ((zeile = reader.readLine()) != null) {
                System.out.println(zeile);
            }
            reader.close();

        } catch (IOException e) {
            System.out.println("❌ Fehler beim Lesen: " + e.getMessage());
        }
    }

    // Gibt die Dateigröße in Bytes aus
    public static void dateigroesseInBytesAusgeben(String dateipfad) {
        File datei = new File(dateipfad);
        if (datei.exists()) {
            System.out.println("📦 Dateigröße: " + datei.length() + " Bytes");
        } else {
            System.out.println("⚠️ Datei existiert nicht.");
        }
    }
}