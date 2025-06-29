package inheritance.collectionAPI.Bookstore;

public class Book implements Comparable<Book> {
    private String bookName;
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName.toLowerCase();
    }
    @Override
    public int compareTo(Book o) {
        return this.bookName.compareToIgnoreCase(o.bookName);
    }

    
}
