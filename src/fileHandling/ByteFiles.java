package fileHandling;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteFiles {

    void readFile() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("\\C:\\Users\\HEMIL\\OneDrive\\Desktop\\read.txt");

        // byte[] fileBytes = fileInputStream.readAllBytes();

        // for (byte fileByte : fileBytes) {
        // System.out.print((char)fileByte); } only when file is fully correct.
        int ch = 0;
        
        System.out.println("Reading data from the file");

        while ((ch = fileInputStream.read()) != -1)
            System.out.print((char) ch);

        fileInputStream.close();
    }

    void writeFile() throws IOException {
        String msg = "This is data.";
        FileOutputStream fileOutputStream = new FileOutputStream("\\C:\\Users\\HEMIL\\OneDrive\\Desktop\\write.txt");
        System.out.println("\nWriting data to the file.");
        fileOutputStream.write(msg.getBytes());

        fileOutputStream.close();
    }

    public static void main(String[] args) throws IOException {
        ByteFiles byteFiles = new ByteFiles();
        byteFiles.readFile();
        byteFiles.writeFile();
    }
}
