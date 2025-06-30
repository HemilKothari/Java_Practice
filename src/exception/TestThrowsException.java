package exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestThrowsException {
    
    int divide(int a, int b) throws ArithmeticException{
        return a/b;
    }

    void readFile() throws FileNotFoundException  {
        try (FileReader fileReader = new FileReader("some-file")) {
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        TestThrowsException testThrowsException = new TestThrowsException();
        testThrowsException.divide(10, 10);
        testThrowsException.readFile();
    }
}
