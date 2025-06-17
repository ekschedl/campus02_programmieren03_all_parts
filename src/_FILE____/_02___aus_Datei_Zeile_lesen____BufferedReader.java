package _FILE____;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class _02___aus_Datei_Zeile_lesen____BufferedReader {
    public static void main(String[] args) throws IOException {

        // wieso BeufferedReader -weil	Er puffert viele Zeichen intern und liest zeilenweise → schneller und praktischer
        //	•	readLine() ist nur in BufferedReader verfügbar!
        BufferedReader br = new BufferedReader(new FileReader("text.txt"));
        String zeile;
        while ((zeile = br.readLine()) != null) {
            System.out.println(zeile);
        }
        br.close();
    }
}
