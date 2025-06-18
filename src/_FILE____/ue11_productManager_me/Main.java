package _FILE____.ue11_productManager_me;

import java.io.IOException;

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