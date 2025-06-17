package ue_11_with_exceptions;

public class Product {
    private String productName;
    private double price;
    private String productCategory;

    public Product(String name, double price, String cat) {
        this.productName = name;
        this.price = price;
        this.productCategory = cat;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                ", productCategory='" + productCategory + '\'' +
                '}';
    }
}

