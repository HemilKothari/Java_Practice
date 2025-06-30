package exception.custom;

import java.util.Scanner;

public class PasswordChecker {

    boolean checkPassword(String password) throws PasswordFormatException {
        if (password.length() < 6)
            throw new PasswordFormatException("Min length should be 6.");

        boolean hasDigit = false;
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) >= '0' && password.charAt(i) <= '9') {
                hasDigit = true;
                break;
            }
        }
        if (!hasDigit) {
            throw new PasswordFormatException("Password does not contain 1 number.");
        }

        boolean hasCapital = false;
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') {
                hasCapital = true;
                break;
            }
        }
        if (!hasCapital) {
            throw new PasswordFormatException("Password does not contain 1 Uppercase Character.");
        }

        return true;
    }

    public static void main(String[] args) {
        PasswordChecker passwordChecker = new PasswordChecker();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        boolean isValid;
        try {
            isValid = passwordChecker.checkPassword(password);
            System.out.println(isValid);
        } catch (PasswordFormatException e) {
            System.out.println(e.getMessage());
        }
        scanner.close();
    }
}
