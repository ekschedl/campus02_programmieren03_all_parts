package _EXCEPTIONS____.Note_Stack_beispiel_folien;

public class Note {
    private String date;
    private String title;
    private String description;

    public Note(String date, String title, String description) {
        this.date = date;
        this.title = title;
        this.description = description;
    }

    @Override
    public String toString() {
        return "[" + date + "] " + title + ": " + description;
    }
}
