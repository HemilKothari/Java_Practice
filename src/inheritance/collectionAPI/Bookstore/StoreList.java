package inheritance.collectionAPI.Bookstore;

import java.util.TreeSet;
import java.util.Map;
import java.util.TreeMap;

public class StoreList {
    private TreeMap<Genre, TreeSet<Book>> storeList;

    public StoreList() {
        storeList = new TreeMap<>();
    }

    public void addBook(Genre genre, Book book) {
        storeList.putIfAbsent(genre, new TreeSet<>());
        storeList.get(genre).add(book);
        System.out.println(book.getBookName() + " added in " + genre.getGenreName());
    }

    public void removeBook(String genre, String book) {
        boolean genreFound = false;
        for (Map.Entry<Genre, TreeSet<Book>> entry : storeList.entrySet()) {
            if (entry.getKey().getGenreName().equals(genre)) {
                genreFound = true;
                TreeSet<Book> books = entry.getValue();
                Book bookToRemove = null;

                for (Book book2 : books) {
                    if (book2.getBookName().equals(book)) {
                        bookToRemove = book2;
                        break;
                    }

                }

                if (bookToRemove != null) {
                    books.remove(bookToRemove);
                    System.out.println(bookToRemove + " removed from " + genre);
                } else
                    System.out.println(book + " not present in " + genre);

                break;
            }
        }

        if (!genreFound) {
            System.out.println(genre + " does not exist.");
        }
    }

    public void displayBooks(String genre) {
        boolean found = false;
        for (Genre genre2 : storeList.keySet()) {
            if (genre2.getGenreName().equals(genre)) {
                System.out.println("Books in " + genre + " are: ");
                for (Book book : storeList.get(genre2)) {
                    System.out.println(book.getBookName());
                }
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println(genre + " does not exist.");
        }
    }

    public void displayAllBooks() {
        if (storeList.isEmpty()) {
            System.out.println("Stock List is empty.");
            return;
        }

        for (Genre genre : storeList.keySet()) {
            System.out.println("Genre: " + genre.getGenreName());
            System.out.print("Books: ");
            for (Book book : storeList.get(genre)) {
                System.out.println(book.getBookName());
            }
            System.out.println("---------------");
        }
    }
}
