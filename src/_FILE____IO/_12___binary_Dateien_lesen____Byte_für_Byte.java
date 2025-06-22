package _FILE____IO;

//Implementieren Sie ein Binary Input Beispiel von den Folien (nicht selbst erarbeitet).

import java.io.*;

// Aufgabenstellung später, mit Exceptions:
//
//Aufgabe:
//
//Schreiben Sie Übung 12 neu (mit Exceptions):
//
//        1) löschen Sie den "throws IOExeption" Text aus der Methodensignatur von Main
//2) behandeln Sie die (möglicherweise) auftretenden Exceptions mit try/catch
public class _12___binary_Dateien_lesen____Byte_für_Byte {

    public static void main(String[] args) {

        File file = new File("ue_12_text_Byte_fuer_byte.txt");

        FileInputStream fileInputStream = null;
        BufferedInputStream bufferedInputStream = null;

        try {
            // Datei öffnen
            fileInputStream = new FileInputStream(file);

            // Für bessere Performance: gepuffertes Lesen
            bufferedInputStream = new BufferedInputStream(fileInputStream);

            int byteRead;
            int i = 0;

            // Lies jedes Byte, bis das Dateiende erreicht ist (-1)
            while ((byteRead = bufferedInputStream.read()) != -1) {
                // Ausgabe als dezimaler Wert + zugehöriges Zeichen
                System.out.print((int) ((char) byteRead));
                System.out.println("\t'" + (char) byteRead + "'");
                i++;
            }

        } catch (FileNotFoundException e) {
            System.out.println("❌ Datei nicht gefunden: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("❌ Fehler beim Lesen der Datei: " + e.getMessage());
        } finally {
            // Ressourcen schließen
            try {
                if (bufferedInputStream != null) bufferedInputStream.close();
                if (fileInputStream != null) fileInputStream.close();
            } catch (IOException e) {
                System.out.println("❌ Fehler beim Schließen der Datei: " + e.getMessage());
            }
        }
    }
}
