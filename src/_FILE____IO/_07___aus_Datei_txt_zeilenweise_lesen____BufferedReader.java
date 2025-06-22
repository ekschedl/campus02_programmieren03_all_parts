package _FILE____IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class _07___aus_Datei_txt_zeilenweise_lesen____BufferedReader {
    public static void main(String[] args) throws IOException {

        // Warum BufferedReader?
        // BufferedReader liest den Text nicht Zeichen für Zeichen,
        // sondern gleich eine ganze Zeile auf einmal.
        // Das ist einfacher und schneller.

        // Wir sagen dem Programm: "Öffne bitte diese Datei zum Lesen"
        BufferedReader br = new BufferedReader(
               // new FileReader("/Users/kaaatkina/CAMPUS02_2025/Programmieren_3/test15_buffered.txt"));

        //oder plattformunabhängige Version
        new FileReader(System.getProperty("user.home") + File.separator +
                "CAMPUS02_2025" + File.separator +
                "Programmieren_3" + File.separator +
                "test07_buffered.txt"));


        String zeile; // In dieser Variable speichern wir jede gelesene Zeile

        // Solange es noch Zeilen in der Datei gibt, mach weiter
        while ((zeile = br.readLine()) != null) {
            // Gib die Zeile auf dem Bildschirm aus
            System.out.println(zeile);
        }

        // Wenn alles gelesen wurde, schließen wir die Datei wieder
        br.close();
    }
}


//// von Herrn Fuchs
//public class ue_7 {
//    public static void main(String[] args) throws IOException {
//
//        // öffnet die Datei test.txt
//        File file = new File("/Users/kaaatkina/CAMPUS02_2025/Programmieren_3/test.txt");
//
//        // liefert einen textorientierten Stream der Datei zurück
//        FileReader fileReader = new FileReader(file);
//
//        // legt einen BufferedReader über den FileReader.
//        // Somit kann komfortabler/effizienter auf die Datei zugegriffen werden.
//        BufferedReader bufferedReader1 = new BufferedReader(fileReader);
//
//        // Alternative 1 – alles in einem Ausdruck (File wird direkt erzeugt)
//        BufferedReader br2 = new BufferedReader(
//                new FileReader(new File("/Users/kaaatkina/CAMPUS02_2025/Programmieren_3/test.txt")));
//
//        // Alternative 2 – direkt mit Pfad als String
//        BufferedReader br3 = new BufferedReader(
//                new FileReader("/Users/kaaatkina/CAMPUS02_2025/Programmieren_3/test.txt"));
//
//        // Zeile für Zeile wird eingelesen.
//        // Ist das Dateiende erreicht, so wird null zurückgeliefert.
//        String line;
//        while ((line = bufferedReader1.readLine()) != null) {
//            System.out.println(line);
//        }
//
//        // bufferedReader wird geschlossen
//        bufferedReader1.close();
//    }
//}
//}