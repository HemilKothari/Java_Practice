package inheritance.collectionAPI.EmployeeDirectory;

import java.util.Scanner;

public class EmployeeDiectory {
    public static void main(String[] args) {
        EmployeeManager employeeManager = new EmployeeManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Employee Directory ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. Display Employee List");
            System.out.println("4. Check if employee present");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter Employee id: ");
                    int addId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter Employee Name: ");
                    String employeeName = scanner.nextLine();
                    employeeManager.addEmployee(addId, employeeName);
                    break;

                case 2:
                    System.out.println("Enter employee id to remove: ");
                    int removeId = scanner.nextInt();
                    scanner.nextLine();
                    employeeManager.removeEmployee(removeId);
                    break;

                case 3:
                    employeeManager.displayEmployeeList();
                    break;

                case 4:
                    System.out.println("Enter employee id to check from list: ");
                    int findId = scanner.nextInt();
                    scanner.nextLine();
                    employeeManager.checkEmployee(findId);
                    break;

                case 5:
                    scanner.close();
                    return;

                default:
                    System.out.println("Enter from given choice only.");
                    break;
            }
        }
    }
}
