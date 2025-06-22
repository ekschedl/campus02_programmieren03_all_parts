package _FILE____IO;

import java.io.*;
import java.net.URL;

public class _09___Url_To_File_Downloader_UrlAusDatei___Url {
    public static void main(String[] args) {
        try {
            // 1. URL aus Datei lesen
            BufferedReader urlReader = new BufferedReader(new FileReader("/Users/kaaatkina/CAMPUS02_2025/Programmieren_3/src/url_webseite_vor_netzwerk_ue_09.txt"));
            String urlString = urlReader.readLine(); // nur eine Zeile
            urlReader.close();

            // 2. URL öffnen
            URL url = new URL(urlString);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

            // 3. Datei vorbereiten
            BufferedWriter bwriter = new BufferedWriter(new FileWriter("content_aus_url_aus_datei_ue_09.html"));


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