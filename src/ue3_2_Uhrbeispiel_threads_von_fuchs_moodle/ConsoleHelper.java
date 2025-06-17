package ue3_2_Uhrbeispiel_threads_von_fuchs_moodle;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsoleHelper {

    public static String readLine() {
        // 🔸 InputStreamReader wandelt die Bytes vom Tastatureingabestrom (System.in) in Zeichen (char) um.
        InputStreamReader isr = new InputStreamReader(System.in);

        // 🔸 BufferedReader puffert (= speichert zwischendurch) die Eingabe und bietet komfortable Methoden wie readLine()
        //     → Vorteil: ganze Zeile auf einmal lesen, nicht Zeichen für Zeichen
        BufferedReader br = new BufferedReader(isr);

        try {
            // 🔸 Liest eine ganze Zeile Text von der Tastatur (bis Enter gedrückt wird)
            return br.readLine();
        } catch (Exception e) {
            // 🔸 Wenn beim Einlesen ein Fehler passiert, wird die Fehlermeldung angezeigt
            e.printStackTrace();
            return null;
        }
    }
}