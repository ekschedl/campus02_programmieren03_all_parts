package _FILE____IO.ue_11_with_exceptions___ich_im_campus;

import java.io.*;
import java.util.ArrayList;

public class ProductManager {
    ArrayList<Product> products = new ArrayList<>();

    public void add(Product product) {
        products.add(product);
    }

    public void saveToFile(String filepath) {
        //öffnen das File

        PrintWriter writer = null;
        try {
            PrintWriter writer2 = new PrintWriter(filepath);
            PrintWriter writer3 = new PrintWriter(filepath);
        } catch (FileNotFoundException e) {
            System.out.println("Error;path is not found");
//            return;
            throw new RuntimeException();
        }

        //Schreiben
        //writer.println("Test Schreiben");
        for (Product product : products) {
            writer.println(product.toString());
        }
        //flush + close
        writer.flush();
        writer.close();
    }

    public void readFromFile(String path) {
        System.out.println("--------- LESE FILE ---------");
        String meineZeile;
        // VON UE 7 ----------------------------
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        //Variante 1 mit WHILE
        int i = 0;
        try {
            while ((meineZeile = br.readLine()) != null){
                System.out.println("Zeile " + i + ": '" + meineZeile + "'");
                i++;
            }
        } catch (IOException e) {
            System.err.println("Pfad ungültig");
        }
    }
}


