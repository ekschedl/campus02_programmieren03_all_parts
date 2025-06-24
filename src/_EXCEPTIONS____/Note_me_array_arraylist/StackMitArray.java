package _EXCEPTIONS____.Note_me_array_arraylist;

public class StackMitArray {

    // Array für die gespeicherten Notizen (fester Speicherplatz)
    private Note[] stackArray;

    // Index des aktuellen obersten Elements im Stack
    // -1 bedeutet: Stack ist leer, noch kein Element gespeichert
    private int top = -1;

    // Konstruktor: Legt die maximale Größe des Stacks fest
    public StackMitArray(int maxSize) {
        stackArray = new Note[maxSize];
    }

    // Methode zum Hinzufügen eines Elements (oben auf den Stack)
    public void push(Note n) throws StackFullException {
        // Prüfen: Ist der Stack voll?
        if (top >= stackArray.length - 1) {
            throw new StackFullException("Stack ist voll!");
        }
        // Element hinzufügen, danach top erhöhen
        stackArray[++top] = n;
    }

    // Methode zum Entfernen und Zurückgeben des obersten Elements
    public Note pop() throws StackEmptyException {
        // Prüfen: Ist der Stack leer?
        if (top < 0) {
            throw new StackEmptyException("Stack ist leer!");
        }
        // Oberstes Element zurückgeben, danach top verringern
        return stackArray[top--];
    }
}