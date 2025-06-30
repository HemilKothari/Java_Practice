package inheritance.collectionAPI.Bookstore;

public class GenreNotFoundException extends Exception{
    public GenreNotFoundException(String message) {
        super(message);
    }
}
