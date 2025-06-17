//package ue_8_stop_Iin_output;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Scanner;
//
////        Schreiben Sie ein Programm, das zeilenweise Tastatureingaben auf die Konsole schreibt, bis das Wort „STOP“ eingegeben wird.
////       Verwenden Sie dazu den InputStream System.in
////        Verwenden Sie weiters die Klassen:
////        InputStreamReader und BufferedReader
//
//
//public class ue_8 {
//    /*
//    Schreiben Sie ein Programm, das zeilenweise Tastatureingaben
//    auf die Konsole schreibt, bis das Wort „STOP“ eingegeben wird.
//    Verwenden Sie dazu den InputStream System.in
//    Verwenden Sie weiters die Klassen: InputStreamReader und BufferedReader
//     */
// /*
//    Schreiben Sie ein Programm, das zeilenweise Tastatureingaben
//    auf die Konsole schreibt, bis das Wort „STOP“ eingegeben wird.
//    Verwenden Sie dazu den InputStream System.in
//    Verwenden Sie weiters die Klassen: InputStreamReader und BufferedReader
//     */
//
//    public static void main(String[] args) throws IOException {
//        // Ready to receive user Input
//        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
//
//        // legt einen BufferedReader über den InputStreamReader.
//        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//
//        // Zeile für Zeile wird eingelesen.
//        String line;
//        while (!(line = bufferedReader.readLine()).equals("STOP")) {
//            System.out.println(line);
//        }
//
//        // BR wird wird geschlossen
//        bufferedReader.close();
//        // Information, dass das Programm vorbei ist.
//        System.out.println("Closed");
//
//    }
//
//
//}