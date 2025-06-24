package _EXCEPTIONS____.Note_Stack_beispiel_folien;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack(2);

        try {
            stack.push(new Note("2025-06-24", "TODO", "Erster Eintrag"));
            stack.push(new Note("2025-06-24", "TODO", "Zweiter Eintrag"));
            System.out.println("gelöscht:" + stack.pop());
            System.out.println("gelöscht:" + stack.pop());

            stack.pop(); // Hier wird bewusst StackEmptyException geworfen
        } catch (StackEmptyException e) {
            e.printStackTrace();
        } catch (StackFullException e) {
            e.printStackTrace();
        }
    }
}
/*Der Unterschied:
	•	Mit System.out.println(stack.pop()); siehst du das entfernte Element.
	•	Mit stack.pop(); wird nur entfernt, aber nicht angezeigt.*/