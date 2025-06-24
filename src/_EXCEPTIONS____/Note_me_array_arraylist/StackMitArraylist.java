package _EXCEPTIONS____.Note_me_array_arraylist;

import java.util.ArrayList;

public class StackMitArraylist {

        private ArrayList<Note> stack = new ArrayList<>();
        private int maxSize;  // Maximale Größe des Stacks

        // Konstruktor mit Maximalgröße
        public StackMitArraylist(int maxSize) {
            this.maxSize = maxSize;
        }

        // Hinzufügen oben drauf, nur wenn noch Platz
        public void push(Note note) throws StackFullException {
            if (stack.size() >= maxSize) {
                throw new StackFullException("Stack ist voll!");
            }
            stack.add(note);
        }

        // Entfernt oberstes Element und gibt es zurück
        public Note pop() throws StackEmptyException {
            if (stack.isEmpty()) {
                throw new StackEmptyException("Stack ist leer!");
            }
            return stack.remove(stack.size() - 1);
        }

        // Gibt aktuelle Größe zurück
        public int getCount() {
            return stack.size();
        }
    }