package inheritance.collectionAPI.DeliverService;

public class DuplicateCityException extends Exception{
    public DuplicateCityException(String message) {
        super(message);
    }
}
