package _FILE____IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//ÜBUNG-8
//Schreiben Sie ein Programm, das zeilenweise
//Tastatureingaben auf die Konsole schreibt, bis
//das Wort „STOP“ eingegeben wird.
//Verwenden Sie dazu den InputStream System.in
//Verwenden Sie weiters die Klassen: ▪ InputStreamReader und BufferedReader


public class _08___StopBeiEingabe_mit_Exception_____Kons__E {
    public static void main(String[] args) {
        // Ready to receive user Input
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);

        // legt einen BufferedReader über den InputStreamReader.
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        // Zeile für Zeile wird eingelesen.
        String line;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                // Check if the input is STOP
                if (line.equals("STOP")) {
                    // IF Yes, go out of the while loop
                    break;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                // BR wird wird geschlossen
                bufferedReader.close();
                // Information, dass das Programm vorbei ist.
                System.out.println("Closed");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
