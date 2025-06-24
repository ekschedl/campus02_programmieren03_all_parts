package _EXCEPTIONS____.ChainingDemo;

public class MeineException extends Exception {

    // Konstruktor für Exception mit zusätzlicher Ursache
    public MeineException(String message, Throwable cause) {
        super(message, cause);  // übergibt Nachricht und Original-Fehler an die Basisklasse
    }
}
/* Zusammenfassung

✅ Du fängst eine Exception (z. B. FileNotFoundException)
✅ Du wirfst eine neue eigene Exception (MeineException), die aber den alten Fehler speichert
✅ Dadurch bleibt die komplette Fehlerkette erhalte*/