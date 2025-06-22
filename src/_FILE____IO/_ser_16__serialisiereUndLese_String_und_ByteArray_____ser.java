package _FILE____IO;

import java.io.*;

public class _ser_16__serialisiereUndLese_String_und_ByteArray_____ser {
/*
    Schreiben Sie ein Programm, das ein String- Objekt „Hallo Welt“ in eine
    Datei „object.dat“ serialisiert und anschließend aus dieser wieder ausliest und auf die
     Konsole schreibt.
    Verwenden Sie die Klassen FileOutputStream und ObjectOutputStream sowie
    FileInputStream und ObjectInputStream
    Verwenden Sie für das Schreiben die Methode writeObject(…), für das Lesen
     die Methode readObject(). Beim Lesen müssen Sie das Ergebnis in einen String casten
    Betrachten Sie die Datei in einem Editor (Notepad, Notepad++)
     */

    public static void main(String[] args) {

        String s = "Hello World";
        byte[] b = {'e', 'x', 'a', 'm', 'p', 'l', 'e'};

        try {
            File file = new File("object_ue16_fuchs.dat");
            // Teil 1 - Schreibe Objekt(e) in Datei
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            // write something in the file
            objectOutputStream.writeObject(s);
            objectOutputStream.writeObject(b);
            objectOutputStream.flush();
            objectOutputStream.close();

            // create an ObjectInputStream for the file we created before
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            // System.out.println(objectInputStream.readObject()); -> Cast is missing!
            // read and print an object and cast it as string
            System.out.println("STRING: " + (String) objectInputStream.readObject());

            // read and print an object and cast it as string
            byte[] text2 = (byte[]) objectInputStream.readObject();
            String s2 = new String(text2);
            System.out.println("BYTE[]: " + s2);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

/*
FileInputStream fis = new FileInputStream("outputFile");
ArrayList<Object> objectsList = new ArrayList<>();
boolean cont = true;
while (cont) {
  try (ObjectInputStream input = new ObjectInputStream(fis)) {
    Object obj = input.readObject();
    if (obj != null) {
      objectsList.add(obj);
    } else {
      cont = false;
    }
  } catch (Exception e) {
    // System.out.println(e.printStackTrace());
  }
}



------

von herrn fuchs

package _FILE____IO;

import java.io.*;

public class _ser_16_fuchs_Serialisierung______ser {

    /*
     🔄 Dieses Programm speichert ein String-Objekt ("Hello World")
     und ein Byte-Array als binäre Datei ("object_16eu_fuchs.dat") im Serialisierungsformat.
     Danach wird beides wieder ausgelesen und korrekt zurück in String bzw. Byte[] konvertiert.


public static void main(String[] args) {

    // 🔡 Ein einfacher String
    String s = "Hello World";

    // 🔢 Ein Beispiel-Byte-Array (entspricht z.B. "example")
    byte[] b = {'e', 'x', 'a', 'm', 'p', 'l', 'e'};

    try {
        // 📁 Datei, in die gespeichert werden soll
        File file = new File("object_16eu_fuchs.dat");

        // 📝 Objekt speichern – Teil 1: Serialisieren
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(s); // speichert String-Objekt
        objectOutputStream.writeObject(b); // speichert Byte[]-Objekt

        objectOutputStream.flush(); // (optional, aber sauber)
        objectOutputStream.close();

        // 📥 Objekt lesen – Teil 2: Deserialisieren
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        // 🧾 Erstes Objekt: wieder als String casten
        String gelesen = (String) objectInputStream.readObject();
        System.out.println("STRING: " + gelesen);

        // 🧾 Zweites Objekt: als Byte[] lesen und in String konvertieren
        byte[] gelesenBytes = (byte[]) objectInputStream.readObject();
        String wiederhergestellt = new String(gelesenBytes); // → aus Byte[] zurück in String
        System.out.println("BYTE[]: " + wiederhergestellt);

        objectInputStream.close();

    } catch (Exception ex) {
        ex.printStackTrace();
    }
}
}
 */
