package _FILE____IO.ue11_without_exceptions;

import java.io.IOException;

public class Main {

    /*
    1. Schreiben Sie eine Klasse Product zur Abbildung von Produkten mit folgenden Attributen.
        String ProductName
        Double Price
        String ProductCategory
        (+ Methoden: Getter / Setter / toString() / Constructor)
    2. Schreiben Sie eine Klasse ProductManager zum Verwalten von Produkten in einer privaten
     Liste und implementieren Sie folgende Methoden
        2.1 public void add(Product p) ➔ fügt ein Produkt zur Liste hinzu
        2.2 public void saveToFile(String path) ➔ speichert die Produkte in der übergebenen Datei. -
            Realisieren Sie dies mittels BufferedWriter und Filewriter.
        2.3 public void readFromFile(String path) ➔ laden Sie den Text von der
        übergebenen Datei und geben Sie den Text auf der Konsole aus.
     */

    public static void main(String[] args) throws IOException {
        ProductManager productManager = new ProductManager();
        String path = "text.txt";
        Product p1 = new Product("Product 1", 1.00, "Test");
        Product p2 = new Product("Product 2", 2.00, "Test 2");
        Product p3 = new Product("Product 3", 3.00, "Test 2");
        productManager.add(p1);
        productManager.add(p2);
        productManager.add(p3);
        productManager.saveToFile(path);
        productManager.readFromFile(path);
    }

}