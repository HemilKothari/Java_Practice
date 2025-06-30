package inheritance.collectionAPI.Bookstore;

import java.util.TreeSet;
import java.util.Map;
import java.util.TreeMap;

public class StoreList {
    private TreeMap<Genre, TreeSet<Book>> storeList;

    public StoreList() {
        storeList = new TreeMap<>();

        Genre fiction = new Genre("Fiction");
        Genre science = new Genre("Science");
        Genre history = new Genre("History");

        storeList.put(fiction, new TreeSet<>());
        storeList.put(science, new TreeSet<>());
        storeList.put(history, new TreeSet<>());

        try {
            addBook(fiction, new Book("The Alchemist"));
            addBook(fiction, new Book("To Kill a Mockingbird"));
            addBook(science, new Book("A Brief History of Time"));
            addBook(history, new Book("Sapiens"));
        } catch (GenreNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addBook(Genre genre, Book book) throws GenreNotFoundException {
        if (!storeList.containsKey(genre)) {
            throw new GenreNotFoundException("Genre " + genre.getGenreName() + " does not exist in catalog.");
        }
        storeList.get(genre).add(book);
        System.out.println(book.getBookName() + " added in " + genre.getGenreName());
    }

    public void removeBook(String genre, String book) throws GenreNotFoundException {
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
            throw new GenreNotFoundException("Genre " + genre + " does not exist in catalog.");
        }
    }

    public void displayBooks(String genre) throws GenreNotFoundException {
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
            throw new GenreNotFoundException("Genre " + genre + " does not exist in catalog.");
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
