package inheritance.hp;

public class Product {
    private String modelNumber;
    private double price;

    public Product(String modelNumber, double price) {
        this.modelNumber = modelNumber;
        this.price = price;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
