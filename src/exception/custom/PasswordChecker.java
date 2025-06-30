package exception.custom;

public class PasswordChecker {

    boolean checkPassword(String password) throws PasswordFormatException {
        if (password.length() < 6)
            throw new PasswordFormatException("Min length should be 6.");
        return true;
    }

    public static void main(String[] args) {
        PasswordChecker passwordChecker = new PasswordChecker();
        String password = "abc12";
        boolean isValid;
        try {
            isValid = passwordChecker.checkPassword(password);
            System.out.println(isValid);
        } catch (PasswordFormatException e) {
            System.out.println(e.getMessage());
        }
        
    }
}
