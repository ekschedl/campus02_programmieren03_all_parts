package _FILE____;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//ÜBUNG-8
//Schreiben Sie ein Programm, das zeilenweise
//Tastatureingaben auf die Konsole schreibt, bis
//das Wort „STOP“ eingegeben wird.
//Verwenden Sie dazu den InputStream System.in
//Verwenden Sie weiters die Klassen: ▪ InputStreamReader und BufferedReader


public class _08___StopBeiEingabe {
    public static void main(String[] args) throws IOException {
        // Ready to receive user Input
        InputStreamReader  inputStreamReader=new  InputStreamReader(System.in);

        // legt einen BufferedReader über den InputStreamReader.
        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);

        // Zeile für Zeile wird eingelesen.
        String eingabe;

        System.out.println("Bitte gib Zeilen ein (Stop mit \"STOP\"):");

        // // Zeile für Zeile wird eingelesen, Wiederhole solange, bis "STOP" eingegeben wurde
        while (!(eingabe = bufferedReader.readLine()).equalsIgnoreCase("STOP")) {
            System.out.println("Eingabe: " + eingabe);
        }
        // BR wird wird geschlossen
        bufferedReader.close();

        // Information, dass das Programm vorbei ist.
        System.out.println("Programm wurde beendet.");


    }
}
//Du brauchst nur einen Weg, um von der Tastatur zu lesen.
////Und du hast zwei Möglichkeiten:
//	•	Scanner ist einfacher
//	•	BufferedReader ist schneller, robuster, ideal wenn du später in eine Datei schreiben willst (z. B. mit FileWriter).

//✅ Weg 1: Scanner (einfach)
//import java.util.Scanner;
//
//public class NotenMitScanner {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Gib deine Noten ein (z. B. PR1: 1), 'STOP' zum Beenden:");
//
//        while (true) {
//            String zeile = scanner.nextLine();
//            if (zeile.equalsIgnoreCase("STOP")) break;
//            System.out.println("Eingegeben: " + zeile);
//        }
//
//        scanner.close();
//    }
//}
//
//Weg 2: BufferedReader (besser für Dateiverarbeitung)
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.IOException;
//
//public class NotenMitBufferedReader {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("Gib deine Noten ein (z. B. PR1: 1), 'STOP' zum Beenden:");
//
//        String zeile;
//        while (!(zeile = br.readLine()).equalsIgnoreCase("STOP")) {
//            System.out.println("Eingegeben: " + zeile);
//        }
//
//        br.close();
//    }
