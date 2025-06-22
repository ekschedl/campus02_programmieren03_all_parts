package _FILE____IO.ue_11_Product____ich_im_campus;

import java.io.*;
import java.util.ArrayList;

public class ProductManager {
    ArrayList<Product> products = new ArrayList<>();


    // Methode zum Hinzufügen eines Produkts
    public void add(Product product) {
        products.add(product);
    }

    public void saveToFile(String filepath) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter((filepath));

        for (Product product : products) {
            writer.println(product.toString());
        }
        writer.flush();
        writer.close();
    }

    // Methode zum Anzeigen aller Produkte
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Product product : products) {
            sb.append("Produkt: ").append(product.getProductName())
                    .append(", Preis: ").append(product.getPrice())
                    .append(", Kategorie: ").append(product.getProductCategory()).append("\n");
        }
        return sb.toString();
    }

    public void readFromFile(String filepath) throws IOException {

        System.out.println("-------lese File----------");
        BufferedReader reader = new BufferedReader(new FileReader(filepath));
        String s = "", line = null;
        while ((line = reader.readLine()) != null) {
            s = s + line;//+ System.lineSeparator();
        }
        System.out.println(s);




    }


}

