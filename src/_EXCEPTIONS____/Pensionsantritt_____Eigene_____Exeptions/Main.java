package _EXCEPTIONS____.Pensionsantritt_____Eigene_____Exeptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Person peter = new Person(64, "Peter");
        //fragen Sie die Benutzerin nach einem neuen Alter
        // und rufen Sie den Setter auf. Wiederholen Sie die Abfrage so lange
        // bis ein korrektes Alter eingegeben wird. Danach beendet sich das Programm.

        Scanner scanner = new Scanner(System.in);
        boolean isNewAgeCorrect = false;
        int petersNewAge = 0;
//        peter=null;  /7 wenn peter gibts nicht
        do {
            System.out.println("Geben Sie das neue Alter ein: ");
            try {
                petersNewAge = scanner.nextInt();
                peter.setAge(petersNewAge);
                isNewAgeCorrect = true;// wenn kein Fehler – Schleife verlassen
                System.out.println("Neues Alter: " + petersNewAge);
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Fehler InputMismatchException: Bitte geben Sie eine gültige Zahl ein.");
                scanner.nextLine();
            } catch (NullPointerException e) {
                System.out.println("Fehler: Ein Fehler ist aufgetreten. " + e.getMessage());
            } catch (ZAMException e) {
                System.out.println("Fehler: " + e.getMessage());
            }

        }
        while (!isNewAgeCorrect);

        System.out.println("Programm beendet sich.");


    }
}
