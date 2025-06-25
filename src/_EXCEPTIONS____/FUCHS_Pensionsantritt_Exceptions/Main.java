package _EXCEPTIONS____.FUCHS_Pensionsantritt_Exceptions;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Übung \"Pensionsantritt\" START");

        Person peter = new Person(64, "Peter");  // Neues Person-Objekt mit Alter 64
        boolean ageReadAndSetSuccessfully = false;  // Kontrollvariable: Hat Alter korrekt funktioniert?
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Bitte ein neues Alter (60-65 exkl) eingeben!");

            try {
                int newAge = scanner.nextInt();  // Einlesen der Zahl von Konsole
                peter.setAge(newAge);  // Methode prüft, ob Alter gültig, sonst Exception
                ageReadAndSetSuccessfully = true;  // Nur wenn kein Fehler, wird Abbruchbedingung gesetzt

            } catch (InputMismatchException e) {  // Falsches Format, z.B. Text statt Zahl
                System.err.println("Fehler: Eingabe kann nicht als Zahl interpretiert werden!");
                scanner.nextLine();  // Leert den Scanner-Puffer, sonst Endlosschleife

            } catch (ZAMException e) {  // Eigene, selbst programmierte Exception z.B. ungültiges Alter
                System.err.println("Fehler: " + e.getMessage());  // Gibt die definierte Fehlermeldung aus

            } catch (NoSuchElementException e) {  // Benutzer hat Strg+D (EOF) gedrückt
                System.err.println("ERROR: Strg+D gedrückt, beende das Programm.");
                return;

            } catch (NullPointerException e) {  // Sollte theoretisch nicht passieren, falls peter null wäre
                System.err.println("Fehler: Peter gibt es nicht. Beende mich.");
                return;

            } catch (Exception e) {  // Auffangen aller sonstigen, unbekannten Fehler
                System.out.println("ERROR: unbekannter Error " + e.getMessage() + " " + e.getClass());
                System.err.println("ERROR: beende Programm.");
                return;
            }

        } while (ageReadAndSetSuccessfully == false);  // Wiederhole, bis korrektes Alter eingegeben wurde

        System.out.println("Age von Peter: " + peter.getAge());  // Ausgabe des final gesetzten Alters
        System.out.println("Übung \"Pensionsantritt\" ENDE");
    }
}