package fileHandling.caesercipher;

public class InvalidShiftKeyException extends Exception{
    public InvalidShiftKeyException(String msg) {
        super(msg);
    }
}
