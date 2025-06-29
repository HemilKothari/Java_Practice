package inheritance.collectionAPI.DeliverService;

import java.util.Scanner;

public class DeliverService {
    public static void main(String[] args) {

        CityManager cityManager = new CityManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- City Delivery Service ---");
            System.out.println("1. Add City");
            System.out.println("2. Display city list.");
            System.out.println("3. Check if delivering to a city.");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter city's name to mark present: ");
                    cityManager.addCity(scanner.nextLine());
                    break;

                case 2:
                    cityManager.displayCity();
                    break;

                case 3:
                    System.out.println("Enter city's name to check from list: ");
                    cityManager.checkCity(scanner.nextLine());
                    break;

                case 4:
                    scanner.close();
                    return;

                default:
                    System.out.println("Enter from given choice only.");
                    break;
            }
        }
    }
}
