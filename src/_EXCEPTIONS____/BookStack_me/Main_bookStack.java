package _EXCEPTIONS____.BookStack_me;

public class Main_bookStack {
    public static void main(String[] args) {

        BookStack stack = new BookStack(2); // Maximal 2 Bücher erlaubt

        try {
            stack.push("Buch A");
            stack.push("Buch B");

            // ➡️ Hier kommt Exception, weil Stack voll ist:
            stack.push("Buch C");
        } catch (StackFullException e) {
            System.out.println("❌ Fehler: " + e.getMessage());
        }

        try {
            System.out.println("📚 Entnommen: " + stack.pop());
            System.out.println("📚 Entnommen: " + stack.pop());

            // ➡️ Hier kommt Exception, weil Stack leer ist:
            System.out.println("📚 Entnommen: " + stack.pop());
        } catch (StackEmptyException e) {
            System.out.println("❌ Fehler: " + e.getMessage());
        }
    }
}

