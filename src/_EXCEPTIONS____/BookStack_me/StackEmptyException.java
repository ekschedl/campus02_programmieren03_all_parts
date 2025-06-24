package _EXCEPTIONS____.BookStack_me;

public class StackEmptyException extends Exception {
    public StackEmptyException(String message) {
        super(message);
    }
}


/* Benutzerdefinierte Exception für leeren Stack
public class StackEmptyException extends Exception {

    public StackEmptyException() {
        super("Der Stack ist leer!");
    }

    public StackEmptyException(String message) {
        super(message);
    }

    public StackEmptyException(String message, Throwable cause) {
        super(message, cause);
    }
Vorteile:

        ✔ Du kannst die Exception so verwenden:
throw new StackFullException();                      // Standard-Nachricht
throw new StackFullException("Maximalgröße erreicht"); // Eigene Nachricht
throw new StackFullException("Fehler", cause);        // Mit Ursache verknüpfen


        Beispiel:try {
    throw new NullPointerException("Interner Fehler");
} catch (NullPointerException e) {
    throw new StackFullException("Stackfehler wegen internem Problem", e);
}
        */
