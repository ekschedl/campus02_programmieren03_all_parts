package ue_7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ue_7 {
    public static void main(String[] args) throws IOException {
        // öffnet die Datei test.txt
        File file = new File("/Users/kaaatkina/CAMPUS02_2025/Programmieren_3/test.txt");
        // liefert einen textorientierten Stream der Datei zurück
        FileReader fileReader = new FileReader(file);
        // legt einen BufferedReader über den FileReader.
        // Somit kann komfortabler/effizenter auf die Datei zugegriffen werden.
        BufferedReader bufferedReader1 = new BufferedReader(fileReader);

        // ODER
        BufferedReader br2 = new BufferedReader(new FileReader(new File("/Users/kaaatkina/CAMPUS02_2025/Programmieren_3/test.txt")));
        BufferedReader br3 = new BufferedReader(new FileReader("/Users/kaaatkina/CAMPUS02_2025/Programmieren_3/test.txt"));
        // Zeile für Zeile wird eingelesen. Ist das Dateiende erreicht, so wird null zurückgeliefert.
        String line;
        while ((line = bufferedReader1.readLine()) != null) {
            System.out.println(line);
        }
        // bufferedReader wird geschlossen
        bufferedReader1.close();
    }
}





