package _EXCEPTIONS____.FUCHS_Pensionsantritt_Exceptions;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Übung \"Pensionsantritt\" START");

        Person peter = new Person(64, "Peter");
        boolean ageReadAndSetSuccessfully = false;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Bitte ein neues Alter (60-65 exkl) eingeben!");
            try {
                int newAge = scanner.nextInt();
                peter.setAge(newAge);
                ageReadAndSetSuccessfully = true;
            } catch (InputMismatchException e) {
                System.err.println("Fehler: Eingabe kann nicht als Zahl interpretiert werden!");
                scanner.nextLine(); // Buffer leeren
            } catch (ZAMException e) {
                System.err.println("Fehler: " + e.getMessage());
            } catch (NoSuchElementException e) {
                System.err.println("ERROR: Strg+D gedrückt, beende das Programm.");
                return;
            } catch (NullPointerException e) {
                System.err.println("Fehler: Peter gibt es nicht. Beende mich.");
                return;
            } catch (Exception e) {
                System.out.println("ERROR: unbekannter Error" + e.getMessage() + e.getClass());
                System.err.println("ERROR: beende Programm.");
                return;
            }
        }
        while (ageReadAndSetSuccessfully == false); // so lange es nicht funktioniert


        System.out.println("Age von Peter: " + peter.getAge());
        System.out.println("Übung \"Pensionsantritt\" ENDE");
    }
}