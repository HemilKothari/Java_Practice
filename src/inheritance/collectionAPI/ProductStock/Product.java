package inheritance.collectionAPI.ProductStock;

public class Product {
    private String productName;
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName.toLowerCase();
    }
    
}
