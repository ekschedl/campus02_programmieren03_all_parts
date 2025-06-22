package _FILE____IO.ue_11_Product____ich_im_campus;

import java.io.IOException;

public class ProductMain {

    public static void main(String[] args) throws IOException {
        ProductManager pm = new ProductManager();
        // Füge ein Produkt hinzu
//        pm.add(new Product("Laptop", 1200.00, "Electronics"));
        // Zeige alle Produkte an, um zu überprüfen, ob das Produkt hinzugefügt wurde


        Product p1 = new Product("Laptop2", 12000.00, "Electronics2");
        Product p2 = new Product("Laptop2", 12000.00, "Electronics2");
        Product p3 = new Product("Laptop2", 12000.00, "Electronics2");
        pm.add(p1);
        pm.add(p2);
        pm.add(p3);

        System.out.println(pm.toString());

        pm.saveToFile("/Users/kaaatkina/CAMPUS02_2025/Programmieren_3/test.txt");
//        String path = "/Users/kaaatkina/CAMPUS02_2025/Programmieren_3/eins/zwei/drei/vier/five";
//        File file1 = new File(path + "/file.txt");
//        file1.createNewFile();
        pm.saveToFile("/Users/kaaatkina/CAMPUS02_2025/Programmieren_3/test2.txt");
        pm.readFromFile("/Users/kaaatkina/CAMPUS02_2025/Programmieren_3/test2.txt");
    }
}
