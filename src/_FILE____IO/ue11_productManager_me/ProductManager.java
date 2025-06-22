package _FILE____IO.ue11_productManager_me;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private List<Product> products = new ArrayList<>();

    // Fügt ein Produkt hinzu
    public void add(Product p) {
        products.add(p);
    }

    // Speichert alle Produkte in eine Textdatei (jede Zeile = 1 Produkt)
    public void saveToFile(String path) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        for (Product p : products) {
            writer.write(p.toString());
            writer.newLine();
        }
        writer.flush();
        writer.close();
    }

    // Liest die Datei ein und gibt alles auf der Konsole aus
    public void readFromFile(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String zeile;
        while ((zeile = reader.readLine()) != null) {
            System.out.println(zeile);
        }
        reader.close();
    }
}