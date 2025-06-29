package inheritance.collectionAPI.ProductStock;

public class Category {
    private String categoryName;
    
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName.toLowerCase();
    }
    
    @Override
    public String toString() {
        return "CategoryName: " + categoryName;
    }
    

    
}
