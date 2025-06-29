package inheritance.collectionAPI.StudentAttendanceTracker;

import java.util.Scanner;

public class Attendance {
    public static void main(String[] args) {

        StudentList studentList = new StudentList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Student Attendance Tracker ---");
            System.out.println("1. Add student to attendance");
            System.out.println("2. Remove student from attendance");
            System.out.println("3. Display attendance list");
            System.out.println("4. Check if a student attended");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Student student = new Student();
                    System.out.println("Enter student id: ");
                    student.setId(scanner.nextInt());
                    scanner.nextLine();

                    System.out.println("Enter student's name to mark present: ");
                    student.setName(scanner.nextLine());
                    studentList.addStudent(student);

                    break;

                case 2:
                    System.out.println("Enter student's id to remove from list: ");
                    studentList.removeStudent(scanner.nextInt());
                    scanner.nextLine();
                    break;

                case 3:
                    studentList.displayList();
                    break;

                case 4:
                    System.out.println("Enter student's name to check from list: ");
                    studentList.checkStudent(scanner.nextLine());
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
