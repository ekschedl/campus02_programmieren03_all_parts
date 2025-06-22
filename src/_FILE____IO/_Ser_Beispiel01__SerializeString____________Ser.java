package _FILE____IO;

import java.io.*;
//🧪 Einfachstes Beispiel mit String (geht, weil String schon Serializable ist)
public class _Ser_Beispiel01__SerializeString____________Ser {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 1. Objekt speichern
        String text = "Hallo Katja!";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ausgabe/text.ser"));
        oos.writeObject(text);
        oos.close();
        System.out.println("✅ String serialisiert!");

        // 2. Objekt laden
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ausgabe/text.ser"));
        String gelesen = (String) ois.readObject();
        ois.close();
        System.out.println("📦 Deserialisiert: " + gelesen);
    }
}
