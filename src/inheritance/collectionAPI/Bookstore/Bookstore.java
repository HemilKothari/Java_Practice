package inheritance.collectionAPI.Bookstore;

import java.util.Scanner;

public class Bookstore {
    public static void main(String[] args) {
        StoreList storeList = new StoreList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Bookstore Managment ---");
            System.out.println("1. Add book under a genre");
            System.out.println("2. Remove book from a genre");
            System.out.println("3. Display books from a genre");
            System.out.println("4. Display the entire stock grouped by genres");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            String genreName;
            String bookName;

            switch (choice) {
                case 1:
                    Genre genre = new Genre();
                    System.out.print("Enter genre name: ");
                    genre.setGenreName(scanner.nextLine());
                    System.out.print("Enter number of books to add: ");
                    int n = scanner.nextInt();
                    scanner.nextLine();
                    for (int i = 0; i < n; i++) {
                        Book book = new Book();
                        System.out.print("Enter book name: ");
                        book.setBookName(scanner.nextLine());
                        try {
                            storeList.addBook(genre, book);
                        } catch (GenreNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;

                case 2:
                    System.out.print("Enter genre name: ");
                    genreName = scanner.nextLine().toLowerCase();
                    System.out.print("Enter book name: ");
                    bookName = scanner.nextLine().toLowerCase();
                    try {
                        storeList.removeBook(genreName, bookName);
                    } catch (GenreNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Enter genre name: ");
                    genreName = scanner.nextLine().toLowerCase();
                    try {
                        storeList.displayBooks(genreName);
                    } catch (GenreNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    storeList.displayAllBooks();
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
