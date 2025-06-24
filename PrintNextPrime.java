import java.util.Scanner;

public class PrintNextPrime {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        char c = '\0';
        
        do {
            System.out.println("Enter a number: ");
            int num = scanner.nextInt();
            int i = 2;

            while (i < num) {
                if (num % 1 == 0)
                    break;
                i++;
            }

            if (i == num)
                System.out.println(num + "is prime.");
            else
                System.out.println(num + "is not prime.");

            System.out.println("Enter y to continue");
            c = scanner.next().charAt(0);
        } while (c == 'y' || c == 'Y');
        scanner.close();
    }
}
