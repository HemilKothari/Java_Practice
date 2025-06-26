package inheritance.Appraisal;

import java.util.Scanner;

public class TestEmployee {
    public static void main(String[] args) {

        // PermanentEmployee permanentEmployee = new PermanentEmployee();
        // permanentEmployee.id = 101;
        // permanentEmployee.name = "John Doe";
        // permanentEmployee.basicSalary = 25000f;

        // permanentEmployee.calculateSalary();
        // permanentEmployee.display();

        // PermanentEmployee permanentEmployee = new PermanentEmployee(111, "John Doe",
        // 25000);
        // permanentEmployee.calculateSalary();
        // permanentEmployee.display();

        // ContractEmployee contractEmployee = new ContractEmployee(111, "Jae Doe",
        // 22.8f);
        // contractEmployee.calculateSalary();
        // contractEmployee.display();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter total number of employees:");
        Employee[] totalEmployees = new Employee[scanner.nextInt()];

        for (int i = 0; i < totalEmployees.length; i++) {
            System.out.println("Enter Employee Type ( 1->Permanent Employee 2->Contract Employee): ");
            switch (scanner.nextInt()) {
                case 1:
                    PermanentEmployee permanentEmployee = new PermanentEmployee();
                    System.out.println("Enter employee id: ");
                    permanentEmployee.id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter employee name: ");
                    permanentEmployee.name = scanner.nextLine();
                    System.out.println("Enter employee basic salary: ");
                    permanentEmployee.basicSalary = scanner.nextFloat();

                    permanentEmployee.calculateSalary();
                    totalEmployees[i] = permanentEmployee;
                    break;

                case 2:
                    ContractEmployee contractEmployee = new ContractEmployee();
                    System.out.println("Enter employee id: ");
                    contractEmployee.id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter employee name: ");
                    contractEmployee.name = scanner.nextLine();
                    System.out.println("Enter rate per hour: ");
                    contractEmployee.ratePerHour = scanner.nextInt();
                    System.out.println("Enter total hours worked: ");
                    contractEmployee.hoursWorked = scanner.nextFloat();
                    contractEmployee.calculateSalary();
                    totalEmployees[i] = contractEmployee;
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }
        scanner.close();

        System.out.println("===Employee Details===");
        for (Employee employee : totalEmployees) {
            System.out.println("Employee Type: " + employee.getClass().getSimpleName());
            employee.display();
            System.out.println("-----------------------");
        }

        Appraisal appraisal = new Appraisal();
        for (Employee employee : totalEmployees) {
            //appraisal.calculateAppraisal(employee);
            appraisal.calculateAppraisalByType(employee);
        }

    }
}
