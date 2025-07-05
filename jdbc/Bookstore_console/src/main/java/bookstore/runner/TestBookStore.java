package bookstore.runner;

import bookstore.dao.BookDAO;
import bookstore.dao.BookDAOImpl;
import bookstore.model.Book;

import java.util.List;
import java.util.Scanner;

public class TestBookStore {
    public static void main(String[] args) {
        BookDAO bookDAO = new BookDAOImpl();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("====Book Store====");
            System.out.println("1. Add new book");
            System.out.println("2. Update book");
            System.out.println("3. Delete book by id");
            System.out.println("4. View all books");
            System.out.println("5. Search book by id");
            System.out.println("6. Search books by name");
            System.out.println("7. Exit");
            System.out.print("Enter a choice(1-7): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            int bookId;
            String bookName;
            float bookPrice;

            switch (choice) {
                case 1:
                    //TODO: Insert new book using BookDAO
                    System.out.print("\nEnter book name: ");
                    bookName = scanner.nextLine();
                    System.out.print("\nEnter book price: ");
                    bookPrice = scanner.nextFloat();
                    scanner.nextLine();
                    int insertedRows = bookDAO.insert(new Book(0, bookName, bookPrice));
                    System.out.println();
                    System.out.println(insertedRows + " rows inserted.");
                    break;
                case 2:
                    //TODO: Update book using BookDAO
                    System.out.print("\nEnter book id to update: ");
                    bookId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("\nEnter book name: ");
                    bookName = scanner.nextLine();
                    System.out.print("\nEnter book price: ");
                    bookPrice = scanner.nextFloat();
                    scanner.nextLine();
                    int updatedRows = bookDAO.update(new Book(bookId, bookName, bookPrice));
                    System.out.println();
                    System.out.println(updatedRows + " rows updated.");
                    break;
                case 3:
                    //TODO: Delete book using BookDAO
                    System.out.print("\nEnter book id to delete: ");
                    bookId = scanner.nextInt();
                    scanner.nextLine();
                    int deletedRows = bookDAO.delete(bookId);
                    System.out.println();
                    System.out.println(deletedRows + " rows deleted.");
                    break;
                case 4:
                    //TODO: View all books
                    List<Book> allBooks = bookDAO.view();
                    System.out.println("==========================================");
                    for (Book b : allBooks) {
                        System.out.println(b);
                        System.out.println("-------------------------------------------");
                    }
                    break;
                case 5:
                    //TODO: View book by id using BookDAO
                    System.out.print("\nEnter book id to search: ");
                    bookId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println();
                    System.out.println(bookDAO.view(bookId));
                    break;
                case 6:
                    //TODO: View books by name using BookDAO
                    System.out.print("\nEnter book name to search: ");
                    bookName = scanner.nextLine();
                    System.out.println();
                    List<Book> allBooksByName = bookDAO.view(bookName);
                    for (Book b : allBooksByName)
                        System.out.println(b);
                    break;
                case 7:
                    //TODO: Exit
                    System.out.println("\nExiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("\nEnter a valid choice.");
            }
        }
    }
}
