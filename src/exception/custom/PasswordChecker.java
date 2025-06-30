package exception.custom;

import java.util.Scanner;

public class PasswordChecker {

    void checkPassword(String password) throws PasswordFormatException {
        if (password.length() < 6)
            throw new PasswordFormatException("Min length should be 6.");

        boolean hasDigit = false;
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasSpecial = false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i)))
                hasDigit = true;
            if (Character.isLowerCase(password.charAt(i)))
                hasUpperCase = true;
            if (Character.isUpperCase(password.charAt(i)))
                hasLowerCase = true;
            if (!Character.isLetterOrDigit(password.charAt(i)))
                hasSpecial = true;
            if (Character.isWhitespace(password.charAt(i)))
                throw new PasswordFormatException("Password should not contain whitespace.");

        }
        if (!hasDigit)
            throw new PasswordFormatException("Password should contain a number.");
        if (!hasLowerCase)
            throw new PasswordFormatException("Password should contain a Lowercase character.");
        if (!hasUpperCase)
            throw new PasswordFormatException("Password should contain a Uppercase character.");
        if (!hasSpecial)
            throw new PasswordFormatException("Password should contain a special character.");

    }

    public static void main(String[] args) {
        PasswordChecker passwordChecker = new PasswordChecker();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        try {
            passwordChecker.checkPassword(password);
            System.out.println(password + " is valid.");
        } catch (PasswordFormatException e) {
            System.out.println(e.getMessage());
        }
        scanner.close();
    }
}
