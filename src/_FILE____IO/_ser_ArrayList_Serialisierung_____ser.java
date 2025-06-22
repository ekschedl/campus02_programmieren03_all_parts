package _FILE____IO;



import java.io.*;
import java.util.ArrayList;

    // 🧠 Klasse Person ist serialisierbar (wird gespeichert/laden)
    class Person implements Serializable {

        private static final long serialVersionUID = 1L; // Versions-ID schützt beim Laden

        private String name;
        private int alter;

        public Person(String name, int alter) {
            this.name = name;
            this.alter = alter;
        }

        @Override
        public String toString() {
            return name + ", " + alter + " Jahre";
        }
    }

public class _ser_ArrayList_Serialisierung_____ser {


        // 🔹 Speichert eine ArrayList<Person> in Datei
        public static void arrayListSpeichern(ArrayList<Person> liste, String dateiname) throws IOException {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dateiname));
            oos.writeObject(liste); // gesamte Liste speichern
            oos.close();
            System.out.println("✅ Liste gespeichert in Datei: " + dateiname);
        }

        // 🔹 Lädt eine ArrayList<Person> aus Datei
        public static ArrayList<Person> arrayListLaden(String dateiname) throws IOException, ClassNotFoundException {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dateiname));
            ArrayList<Person> geladeneListe = (ArrayList<Person>) ois.readObject();
            ois.close();
            return geladeneListe;
        }

        public static void main(String[] args) {
            try {
                // 🔸 Liste erstellen und füllen
                ArrayList<Person> personen = new ArrayList<>();
                personen.add(new Person("Katja", 25));
                personen.add(new Person("Lena", 30));
                personen.add(new Person("Mira", 28));

                // 🔸 Speichern
                arrayListSpeichern(personen, "personen_liste.ser");

                // 🔸 Laden
                ArrayList<Person> geladen = arrayListLaden("personen_liste.ser");

                // 🔸 Ausgabe
                System.out.println("📂 Geladene Personenliste:");
                for (Person p : geladen) {
                    System.out.println("🔹 " + p);
                }

            } catch (Exception e) {
                System.out.println("❌ Fehler: " + e.getMessage());
            }
        }
    }
