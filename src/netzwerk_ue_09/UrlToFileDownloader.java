package netzwerk_ue_09;

import java.io.*;
import java.net.URL;

public class UrlToFileDownloader {
    public static void main(String[] args) {
        try {
            // 1. URL angeben
            URL url = new URL("https://ekschedl.com");

            // 2. InputStream von der URL öffnen
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(url.openStream()));

            // 3. Datei vorbereiten
            BufferedWriter bwriter = new BufferedWriter(
                    new FileWriter("content.html"));

//            bwriter.write("test");
//            bwriter.flush(); writer.close();

            // 4. Zeile für Zeile lesen und speichern
            String one_line;
            while ((one_line = br.readLine()) != null) {
                bwriter.write(one_line);
                bwriter.newLine(); // neue Zeile, sonst steht alles auf eine Zeile
                System.out.println(one_line); //auf Konsole ausgeben!!!

            }

            // 5. Ressourcen schließen
            br.close();
            bwriter.close();

            System.out.println("Download abgeschlossen.");
        } catch (IOException e) {
            System.out.println("Fehler: " + e.getMessage());
        }
    }
}


/*URL url = new URL(...)
подключается к веб-странице

url.openStream()
открывает поток чтения данных

BufferedReader
читает построчно

BufferedWriter
записывает в файл

newLine()
делает перенос строки в файле
*/