package _EXCEPTIONS____.Note_me_array_arraylist;

import java.time.LocalDate;

public class Main_for_Arraylist {
    public static void main(String[] args) {

        StackMitArraylist stack = new StackMitArraylist(3); // Maximal 3 Notizen erlaubt

        try {
            // Normal: Elemente hinzufügen
            stack.push(new Note(LocalDate.now(), "Wichtig", "Erste Notiz"));
            stack.push(new Note(LocalDate.now(), "Test", "Zweite Notiz"));
            stack.push(new Note(LocalDate.now(), "Deadline", "Dritte Notiz"));

            // Fehlerfall: Noch ein Element hinzufügen → Stack ist voll!
            stack.push(new Note(LocalDate.now(), "Überlauf", "Stack zu voll"));

        } catch (StackFullException e) {
            System.out.println("Fehler beim Hinzufügen: " + e.getMessage());
            e.printStackTrace();
        }

        try {
            // Normal: Elemente entfernen
            System.out.println("Entfernt: " + stack.pop());
            System.out.println("Entfernt: " + stack.pop());
            System.out.println("Entfernt: " + stack.pop());

            // Fehlerfall: Noch ein Element entfernen → Stack ist leer!
            System.out.println("Entfernt: " + stack.pop());

        } catch (StackEmptyException e) {
            System.out.println("Fehler beim Entfernen: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
