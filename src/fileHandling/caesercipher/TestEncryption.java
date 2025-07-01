package fileHandling.caesercipher;

import java.io.IOException;
import java.util.Scanner;

public class TestEncryption {
    public static void main(String[] args) throws IOException {
        CaesarCipher caesarCipher = new CaesarCipher();
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nDo you want to read a file(Press y for yes): ");
        String response = scanner.nextLine();
        if (response.isEmpty() || (response.charAt(0) != 'y' && response.charAt(0) != 'Y')) {
            scanner.close();
            return;
        }
        caesarCipher.readFile();

        System.out.print("\nDo you want to encrypt the file(Press y for yes): ");
        response = scanner.nextLine();
        if (response.isEmpty() || (response.charAt(0) != 'y' && response.charAt(0) != 'Y')) {
            scanner.close();
            return;
        }

        System.out.print("\nEnter shift key: ");
        int shiftKey = scanner.nextInt();
        scanner.nextLine();
        try {
            caesarCipher.encryptFile(shiftKey);
        } catch (InvalidShiftKeyException e) {
            System.out.println(e.getMessage());
        }

        System.out.print("\nDo you want to decrypt the file(Press y for yes): ");
        response = scanner.nextLine();
        if (response.isEmpty() || (response.charAt(0) != 'y' && response.charAt(0) != 'Y')) {
            scanner.close();
            return;
        }
        caesarCipher.readEncryptedFile();
        caesarCipher.decryptData(shiftKey);

        scanner.close();

    }
}
