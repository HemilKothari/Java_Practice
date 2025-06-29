package inheritance.collectionAPI.ProductStock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Stock {
    private HashMap<Category, ArrayList<Product>> stockList;

    public Stock() {
        stockList = new HashMap<>();
    }

    public void addProduct(Category category, Product product) {
        stockList.putIfAbsent(category, new ArrayList<>());
        stockList.get(category).add(product);
        System.out.println(product.getProductName() + " added in " + category.getCategoryName());
    }

    public void removeProduct(String category, String product) {
        boolean categoryFound = false;
        for (Map.Entry<Category, ArrayList<Product>> entry : stockList.entrySet()) {
            if (entry.getKey().getCategoryName().equals(category)) {
                categoryFound = true;
                ArrayList<Product> products = entry.getValue();
                boolean productFound = false;

                for (int i = 0; i < products.size(); i++) {
                    if (products.get(i).getProductName().equals(product)) {
                        products.remove(i);
                        productFound = true;
                        System.out.println(product + " removed from " + category);
                        break;
                    }
                }

                if (!productFound) {
                    System.out.println(product + " not present in " + category);
                }

                break;
            }
        }

        if (!categoryFound) {
            System.out.println(category + " does not exist.");
        }
    }

    public void displayProducts(String category) {
        boolean found = false;
        for (Category category2 : stockList.keySet()) {
            if (category2.getCategoryName().equals(category)) {
                System.out.println("Producst in " + category + " are: ");
                for (Product product : stockList.get(category2)) {
                    System.out.println(product.getProductName());
                }
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println(category + " does not exist.");
        }
    }

    public void displayAllProducts() {
        if (stockList.isEmpty()) {
            System.out.println("Stock List is empty.");
            return;
        }

        for (Category category : stockList.keySet()) {
            System.out.println("Category: " + category.getCategoryName());
            System.out.print("Products: ");
            for (Product product : stockList.get(category)) {
                System.out.print(product.getProductName() + " ");
            }
            System.out.println();
            System.out.println("---------------");
        }
    }
}
