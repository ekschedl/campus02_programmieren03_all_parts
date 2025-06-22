package _FILE____IO;

import java.io.*;

public class _Ser_Beispiel02__SerializePerson____________Ser {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person katja = new Person("Katja", 30);

        // Objekt speichern
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("serialize_person.ser"));
        oos.writeObject(katja);
        oos.close();
        System.out.println("✅ Person-Objekt gespeichert");

        // Objekt wieder laden
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("serialize_person.ser"));
        Person geladen = (Person) ois.readObject();
        ois.close();
        System.out.println("📦 Gelesen: " + geladen.name + " ist " + geladen.alter + " Jahre alt.");
    }

    // Klasse muss Serializable implementieren
    static class Person implements Serializable {
        String name;
        int alter;

        public Person(String name, int alter) {
            this.name = name;
            this.alter = alter;
        }
    }

}
