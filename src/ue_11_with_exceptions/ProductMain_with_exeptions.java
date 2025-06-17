package ue_11_with_exceptions;

import ue_11_Product.Product;
import ue_11_Product.ProductManager;

import java.io.IOException;

public class ProductMain_with_exeptions {
    public static void main(String[] args) {
        System.out.println("UE 11: Save and Load from file");
        ProductManager pm = new ProductManager();
        Product p1 = new Product("Name 1", 1.0, "Kategorie 1");
        Product p2 = new Product("Name 2", 2.0, "Kategorie 2");
        //System.out.println("Product 1: " + p1);
        pm.add(p1);
        pm.add(p2);

        try {
            pm.saveToFile("C:\\Users\\b50394\\IdeaProjects\\PR3_local\\" +
                    "test\\Produkte.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            pm.readFromFile("C:\\Users\\b50394\\IdeaProjects\\PR3_local\\" +
                    "test\\Produkte.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

