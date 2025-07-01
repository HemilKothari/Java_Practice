package fileHandling;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharFiles {
    void readFile() throws IOException {
        FileReader fileReader = new FileReader("\\C:\\Users\\HEMIL\\OneDrive\\Desktop\\read.txt");

        int ch = 0;
        
        System.out.println("Reading data from the file");

        while ((ch = fileReader.read()) != -1)
            System.out.print((char) ch);
        fileReader.close();
    }

    void writeFile() throws IOException {
        String msg = "This is data.";
        FileWriter fileWriter = new FileWriter("\\C:\\Users\\HEMIL\\OneDrive\\Desktop\\write.txt");
        System.out.println("\nWriting data to the file.");
        fileWriter.write(msg);
        fileWriter.close();
    }

    public static void main(String[] args) throws IOException {
        CharFiles charFiles = new CharFiles();
        charFiles.readFile();
        charFiles.writeFile();
    }
}
