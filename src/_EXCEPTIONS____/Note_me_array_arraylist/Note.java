package _EXCEPTIONS____.Note_me_array_arraylist;

import java.time.LocalDate;

public class Note {

    // über Notiz
    private LocalDate date;
    private String title;
    private String description;

    // Konstruktor zum Erzeugen einer neuen Notiz mit Datum, Titel und Beschreibung
    public Note(LocalDate date, String title, String description) {
        this.date = date;
        this.title = title;
        this.description = description;
    }

    // Gibt die Notiz als formatierten Text zurück, z. B. [2025-06-24] Wichtig: Inhalt
    @Override
    public String toString() {
        return "[" + date + "] " + title + ": " + description;
    }
}