package _FILE____IO;

import java.io.IOException;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
public class _09___Url_verschiedene_aufgaben_extra___Url {

        public static void main(String[] args) {
            System.out.println("Starte URL-Download...");

            File urlDatei = new File("src/urls_extra_aufgaben.txt"); // Datei mit mehreren URLs
            int urlCounter = 1; // zählt mit, damit jede Seite einen eigenen Namen bekommt

            try (BufferedReader urlReader = new BufferedReader(new FileReader(urlDatei))) {
                String urlZeile;

                while ((urlZeile = urlReader.readLine()) != null) {
                    System.out.println("Lese URL: " + urlZeile);

                    try {
                        URL url = new URL(urlZeile); // prüft, ob gültige URL
                        BufferedReader reader = new BufferedReader(
                                new InputStreamReader(url.openStream())
                        );

                        String dateiname = "seite" + urlCounter + ".html"; // z.B. seite1.html, seite2.html ...
                        BufferedWriter writer = new BufferedWriter(
                                new FileWriter(dateiname)
                        );

                        String line;
                        while ((line = reader.readLine()) != null) {
                            System.out.println(line); // Zeige HTML auf Konsole

                            // Filter: nur speichern, wenn Zeile <p> enthält
                            if (line.contains("<p>")) {
                                writer.write(line);
                                writer.write(System.lineSeparator()); // plattformunabhängiger Zeilenumbruch
                            }
                        }

                        writer.close();
                        reader.close();
                        System.out.println("Gespeichert in: " + dateiname);
                        urlCounter++;

                    } catch (MalformedURLException e) {
                        System.out.println("Ungültige URL: " + urlZeile);
                    } catch (IOException e) {
                        System.out.println("Fehler beim Lesen/Schreiben: " + e.getMessage());
                    }
                }

            } catch (FileNotFoundException e) {
                System.out.println("Datei urls.txt nicht gefunden.");
            } catch (IOException e) {
                System.out.println("Fehler beim Lesen der URL-Datei: " + e.getMessage());
            }

            System.out.println("Fertig!");
        }
    }
