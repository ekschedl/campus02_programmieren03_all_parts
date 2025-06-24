package _EXCEPTIONS____.BookStack_me;

public class StackFullException extends Exception {
    public StackFullException(String message) {
        super(message);
    }
}

/*
✅ Eigene Exception mit mehreren Konstruktoren (Überladung):
// Benutzerdefinierte Exception für vollen Stack
public class StackFullException extends Exception {

    // Standard-Konstruktor ohne Nachricht
    public StackFullException() {
        super("Der Stack ist voll!");
    }

    // Konstruktor mit eigener Nachricht
    public StackFullException(String message) {
        super(message);
    }

    // Konstruktor mit Ursache (Chaining)
    public StackFullException(String message, Throwable cause) {
        super(message, cause);
    }
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

