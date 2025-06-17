//package ue_16;
//
//import java.io.*;
//
//public class ue_16 {
//
//    public static void main(String[] args) throws IOException, ClassNotFoundException {
////        //
////        //Variant GPT
////        1. Ein String-Objekt vorbereiten
////        String text = "Hello Welt";
////
////        // 2. FileOutputStream öffnen für die Datei
////        FileOutputStream fileOut = new FileOutputStream("object.dat");
////
////        // 3. ObjectOutputStream erstellen
////        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
////
////        // 4. Objekt (text) serialisieren und in Datei schreiben
////        objectOut.writeObject(text);
////
////        // 5. Streams schließen
////        objectOut.close();
////        fileOut.close();
////
////        System.out.println("Objekt wurde serialisiert und in object.dat gespeichert.");
//        String message = "Hello Welt";
//        FileOutputStream fileOut = new FileOutputStream("string_serialisierung.dat");
//        ObjectOutputStream oos = new ObjectOutputStream(fileOut);
//        oos.writeObject(message);
//
//        byte[] b = {'a', 'x', 'a', 'm', 'b'};
//        oos.writeObject(b);
//
//        oos.flush();
//        oos.close();
//
//        //lesen GPT Variante
////        // 1. FileInputStream öffnen
////        FileInputStream fileInputStream = new FileInputStream("string_serialisierung.dat");
////
////        // 2. ObjectInputStream erzeugen
////        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
////
////        // 3. Objekt lesen und casten (Typ anpassen je nachdem, was gespeichert wurde)
////        String string1 = (String) objectInputStream.readObject();
////        System.out.println("Gelesener String: " + string1);
////
////        // Beispiel: Wenn danach ein Byte-Array gespeichert wurde:
////        // byte[] myByteArray = (byte[]) objectInputStream.readObject();
////        // System.out.println("Byte-Array Länge: " + myByteArray.length);
////
////        // 4. Streams schließen
////        objectInputStream.close();
////        fileInputStream.close();
//
//        //zwei Objekte zu deserialisieren:
////        FileInputStream fileInputStream = new FileInputStream("string_serialisierung.dat");
////        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//
///// /zuerst String1  und dan String2
////        String string1 = (String) objectInputStream.readObject();
////        System.out.println("Gelesener String: " + string1);
////
////        byte[] myByteArray = (byte[]) objectInputStream.readObject();
////        String string2 = new String(myByteArray);
////        System.out.println("Gelesener String: " + string2);
//
//        try {
//            FileInputStream fileInputStream = new FileInputStream("object.dat");
//            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//
//            byte[] myByteArray = (byte[]) objectInputStream.readObject();
//            String string2 = new String(myByteArray);
//            System.out.println("Gelesener String: " + string2);
//
//            String string1 = (String) objectInputStream.readObject();
//            System.out.println("Gelesener String: " + string1);
//        } catch (IOException) {
//            // Обработка исключений
//            System.out.println("Fehler beim Lesen der Datei:");
//
//        }
//    }
//}