package inheritance.collectionAPI.ProductStock;

import java.util.Scanner;

public class StockManager {
    public static void main(String[] args) {
        Stock stock = new Stock();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Product Stock Managment ---");
            System.out.println("1. Add product under a category");
            System.out.println("2. Remove product from a category");
            System.out.println("3. Display products from a category");
            System.out.println("4. Display the entire stock grouped by categories");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            String categoryName;
            String productName;
            switch (choice) {
                case 1:
                    Category category = new Category();
                    System.out.print("Enter category name: ");
                    category.setCategoryName(scanner.nextLine().trim().toLowerCase());
                    System.out.print("Enter number of products to add: ");
                    int n = scanner.nextInt();
                    scanner.nextLine();
                    for (int i = 0; i < n; i++) {
                        Product product = new Product();
                        System.out.print("Enter product name: ");
                        product.setProductName(scanner.nextLine().trim().toLowerCase());
                        stock.addProduct(category, product);
                    }
                    break;

                case 2:
                    System.out.print("Enter category name: ");
                    categoryName = scanner.nextLine().trim().toLowerCase();
                    System.out.print("Enter product name: ");
                    productName = scanner.nextLine().trim().toLowerCase();
                    stock.removeProduct(categoryName, productName);
                    break;

                case 3:
                    System.out.print("Enter category name: ");
                    categoryName = scanner.nextLine().trim().toLowerCase();
                    stock.displayProducts(categoryName);
                    break;

                case 4:
                    stock.displayAllProducts();
                    break;

                case 5:
                    System.out.println("exiting....");
                    scanner.close();
                    return;

                default:
                    System.out.println("Enter a valid choice");
                    break;
            }
        }
    }
}
