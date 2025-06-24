package _EXCEPTIONS____.BookStack_me;

public class BookStack {
    private String[] stack;
    private int top = -1; // Index des obersten Elements
    private int maxSize;

    // Konstruktor: Größe vorgeben
    public BookStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new String[maxSize];
    }

    // Element oben drauf legen
    public void push(String bookTitle) throws StackFullException {
        if (top >= maxSize - 1) {
            throw new StackFullException("Stack ist voll! Maximale Größe: " + maxSize);
        }
        stack[++top] = bookTitle;
    }

    // Oberstes Element entfernen und zurückgeben
    public String pop() throws StackEmptyException {
        if (top < 0) {
            throw new StackEmptyException("Stack ist leer! Kein Element zum Entfernen.");
        }
        return stack[top--];
    }

    public int getCount() {
        return top + 1;
    }
}
