package fileHandling.caesercipher;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CaesarCipher {

    private String fileData = "";

    public void readFile() throws IOException {
        FileReader fileReader = new FileReader("C:\\Users\\HEMIL\\CN_CRTP\\Parctice\\src\\fileHandling\\caesercipher\\input.txt");
        StringBuilder content = new StringBuilder();
            int ch = 0;

            System.out.println("Reading data from the file...");

            while ((ch = fileReader.read()) != -1)
                content.append((char) ch);
            fileReader.close();
            fileData = content.toString();
    }

    public void encryptFile(int shiftKey) throws IOException, InvalidShiftKeyException {
        if (shiftKey <= 0 || shiftKey >= 6) 
            throw new InvalidShiftKeyException("Enter valid shiftKey key.");

        if(fileData.isEmpty())  
            throw new IOException("Input file is empty");
        
        StringBuilder encryptedData = new StringBuilder();

        for (Character c : fileData.toCharArray()) {
            if (Character.isUpperCase(c))
                encryptedData.append((char) ((c - 'A' + shiftKey) % 26 + 'A'));
            else if (Character.isLowerCase(c))
                encryptedData.append((char) ((c - 'a' + shiftKey)%26 + 'a'));
            else
                encryptedData.append(c);
        }
        fileData = encryptedData.toString();

        FileWriter fileWriter =new FileWriter("C:\\Users\\HEMIL\\CN_CRTP\\Parctice\\src\\fileHandling\\caesercipher\\encrypted.txt");
        System.out.println("File is encrypted.");
        fileWriter.write(fileData);
        fileWriter.close();
    }

    public void readEncryptedFile() throws IOException {
        FileReader fileReader = new FileReader("C:\\Users\\HEMIL\\CN_CRTP\\Parctice\\src\\fileHandling\\caesercipher\\encrypted.txt");
        StringBuilder content = new StringBuilder();
        int ch = 0;

        System.out.println("Reading data from the file");

        while ((ch = fileReader.read()) != -1)
            content.append((char) ch);
        fileReader.close();
        fileData = content.toString();
    }

    public void decryptData(int shiftKey) throws IOException {
        StringBuilder encryptedData = new StringBuilder();

        for (Character c : fileData.toCharArray()) {
            if (Character.isUpperCase(c))
                encryptedData.append((char) ((c - 'A' - shiftKey + 26) % 26 + 'A'));
            else if (Character.isLowerCase(c))
                encryptedData.append((char) ((c - 'a' - shiftKey + 26) % 26 + 'a'));
            else
                encryptedData.append(c);
        }
        fileData = encryptedData.toString();

        FileWriter fileWriter = new FileWriter("C:\\Users\\HEMIL\\CN_CRTP\\Parctice\\src\\fileHandling\\caesercipher\\decrypted.txt");
        System.out.println("File is decrypted.");
        fileWriter.write(fileData);
        fileWriter.close();
    }

}
