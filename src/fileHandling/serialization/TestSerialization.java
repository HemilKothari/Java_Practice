package fileHandling.serialization;

import java.io.*;

public class TestSerialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student student = new Student(1, "John", 85.2f);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("\\C:\\Users\\HEMIL\\OneDrive\\Desktop\\write.txt"));
        System.out.println("Serializing....");
        objectOutputStream.writeObject(student);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("\\C:\\Users\\HEMIL\\OneDrive\\Desktop\\write.txt"));
        System.out.println("De Serializing");
        Student objectFromFile = (Student) objectInputStream.readObject();
        objectFromFile.printDetails();
        objectInputStream.close();
    }
}
