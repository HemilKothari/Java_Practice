import java.util.Scanner;

public class PrimeInRange {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter lower range: ");
        int low = scanner.nextInt();

        System.out.println("Enter higher range: ");
        int high = scanner.nextInt();
        
        while (low < high) {
            int i = 2;
            while (i < low) {
                if (low % i == 0)
                    break;
                i++;
            }

            if (i == low)
                System.out.println(low);

            low++;
        }

        scanner.close();
    }
}
