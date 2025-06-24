package _EXCEPTIONS____.Note_me_array_arraylist;

import java.time.LocalDate;

public class Main_for_Array {
    public static void main(String[] args) {

        int numNotes = 3;  // Maximale Anzahl an Notizen, die der Stack speichern darf
        StackMitArray stack = new StackMitArray(numNotes);  // Neuer Stack wird erstellt

        try {
            // ✅ Normale Nutzung: 3 Elemente hinzufügen, das ist erlaubt
            stack.push(new Note(LocalDate.now(), "Wichtig", "Erste Notiz")); // wird als erstes hinzugefügt
            stack.push(new Note(LocalDate.now(), "Test", "Zweite Notiz"));   // kommt oben drauf
            stack.push(new Note(LocalDate.now(), "Deadline", "Dritte Notiz")); // liegt ganz oben

            // ❌ Noch ein Element hinzufügen → Stack ist voll, es wird Exception geworfen
            stack.push(new Note(LocalDate.now(), "Überlauf", "Stack zu voll"));

        } catch (StackFullException e) {
            // Wird ausgelöst, wenn zu viele Elemente eingefügt werden
            System.out.println("⚠️ Fehler beim Hinzufügen: " + e.getMessage());
            e.printStackTrace();  // Zusätzliche technische Infos für Entwickler
        }

        try {
            // ✅ Normale Nutzung: Elemente werden entfernt (immer das oberste zuerst → LIFO-Prinzip)
            System.out.println("Entfernt: " + stack.pop());  // entfernt "Dritte Notiz"
            System.out.println("Entfernt: " + stack.pop());  // entfernt "Zweite Notiz"
            System.out.println("Entfernt: " + stack.pop());  // entfernt "Erste Notiz"

            // ❌ Noch ein Element entfernen → Stack ist leer, es wird Exception geworfen
            System.out.println("Entfernt: " + stack.pop());

        } catch (StackEmptyException e) {
            // Wird ausgelöst, wenn vom leeren Stack entfernt werden soll
            System.out.println("⚠️ Fehler beim Entfernen: " + e.getMessage());
            e.printStackTrace();  // Zusätzliche technische Infos für Entwickler
        }
    }
}