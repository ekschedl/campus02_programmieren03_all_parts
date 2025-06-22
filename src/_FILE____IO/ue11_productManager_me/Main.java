package _FILE____IO.ue11_productManager_me;

import java.io.IOException;
//Schreiben Sie eine Klasse Product zur Abbildung von Produkten mit folgenden Attributen.
//  - String ProductName
//- Double Price
//- String ProductCategory
//
//Schreiben Sie eine Klasse ProductManager zum Verwalten von Produkten in einer privaten Liste und implementieren Sie folgende Methoden
//public void add(Product p) ➔ fügt ein Produkt hinzu
//public void saveToFile(String path) ➔ speichert die Produkte in der übergebenen Datei. - Realisieren Sie dies mittels BufferedWriter und Filewriter./
//public void readFromFile(String path) ➔ laden Sie den Text von der übergebenen Datei und geben Sie den Text auf der Konsole aus.
//
//ZIEL:
//Die Klasse Main, soll 5 Produkte initialisieren danach als TXT exportieren und danach wieder einlesen und auf die Konsole ausgeben.
//
public class Main {
    public static void main(String[] args) throws IOException {
        ProductManager pm = new ProductManager();

        // 5 Beispielprodukte
        pm.add(new Product("Apfel", 0.89, "Obst"));
        pm.add(new Product("Brot", 2.49, "Backwaren"));
        pm.add(new Product("Milch", 1.19, "Getränke"));
        pm.add(new Product("Zahnpasta", 3.79, "Drogerie"));
        pm.add(new Product("Käse", 2.99, "Milchprodukte"));

        // Pfad zur Datei – passe an, wenn du willst
        String pfad = "produkte_liste.txt";

        // Speichern & Einlesen
        pm.saveToFile(pfad);
        System.out.println("Datei wurde gespeichert.");

        System.out.println("\nProdukte aus Datei:");
        pm.readFromFile(pfad);
    }
}