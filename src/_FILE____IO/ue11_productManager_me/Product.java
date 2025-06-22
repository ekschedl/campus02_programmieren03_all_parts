package _FILE____IO.ue11_productManager_me;

public class Product {
    private String productName;
    private double price;
    private String productCategory;

    public Product(String productName, double price, String productCategory) {
        this.productName = productName;
        this.price = price;
        this.productCategory = productCategory;
    }

    // Getter für späteren Zugriff
    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public String getProductCategory() {
        return productCategory;
    }

    // Schön formatierte Darstellung
    @Override
    public String toString() {
        return productName + ";" + price + ";" + productCategory;
    }
}