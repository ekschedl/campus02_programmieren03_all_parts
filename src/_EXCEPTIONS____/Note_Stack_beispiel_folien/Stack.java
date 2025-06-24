package _EXCEPTIONS____.Note_Stack_beispiel_folien;

public class Stack {
    private Note[] notes;
    private int pointer;

    public Stack(int size) {
        notes = new Note[size];
        pointer = -1; // -1 bedeutet: Stack ist leer
    }

    public void push(Note note) throws StackFullException {
        if (pointer >= notes.length - 1) {
            throw new StackFullException("Stack ist voll!");
        }
        notes[++pointer] = note;
    }

    public Note pop() throws StackEmptyException {
        if (pointer == -1) {
            throw new StackEmptyException("Stack ist leer!");
        }
        Note n = notes[pointer];
        notes[pointer] = null; // Optional: Speicher freigeben
        pointer--;
        return n;
    }
}