import java.util.ArrayList;
import java.util.Scanner;

public class CountDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        ArrayList<Integer> digits = new ArrayList<>();

        if (num == 0) {
            digits.add(0); // handle 0 explicitly
        } else {
            while (num > 0) {
                digits.add(num % 10); // extracts last digit
                num /= 10;            // removes last digit
            }
        }

        System.out.println("Digits (in reverse order):");
        for (int digit : digits) {
            System.out.println(digit);
        }

        scanner.close();
    }
}
