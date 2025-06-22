package _FILE____IO.ue_11_with_exceptions___ich_im_campus;


import java.io.IOException;
//Öffnet die Datei test2.txt im Binärmodus (also byteweise, nicht als Text!).
//        2.	Liest jedes einzelne Byte der Datei, bis zum Ende.
//        3.	Gibt jede gelesene Byte-Zahl (zwischen 0 und 255) mit Leerzeichen getrennt in der Konsole aus.
//        •	Zum Beispiel: 72 101 108 108 111 → Das wäre “Hello” als ASCII-Zahlen.
public class ProductMain_with_exeptions {
    public static void main(String[] args) throws IOException {
        System.out.println("UE 11: Save and Load from file");
        ProductManager pm = new ProductManager();
        Product p1 = new Product("Name 1", 1.0, "Kategorie 1");
        Product p2 = new Product("Name 2", 2.0, "Kategorie 2");
        //System.out.println("Product 1: " + p1);
        pm.add(p1);
        pm.add(p2);

        pm.saveToFile("C:\\Users\\b50394\\IdeaProjects\\PR3_local\\" +
                "test\\Produkte.txt");


        pm.readFromFile("C:\\Users\\b50394\\IdeaProjects\\PR3_local\\" +
                "test\\Produkte.txt");
    }
}

