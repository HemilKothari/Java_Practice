package inheritance.collectionAPI.StudentAttendanceTracker;

import java.util.ArrayList;

public class StudentList{
    private ArrayList<Student> attendanceList;

    public StudentList() {
        attendanceList = new ArrayList<>();
    }

    public void addStudent(Student student) {
        attendanceList.add(student);
        System.out.println(student.getName() + " is marked present.");
    }

    public void removeStudent(int id) {
        boolean removed = attendanceList.removeIf(student -> {
            if (student.getId() == id) {
                System.out.println(student.getName() + " is marked absent.");
                return true;
            }
            return false;
        });

        if (!removed) {
            System.out.println(id + " is not present in the list.");
        }
    }

    public void displayList() {
        System.out.println("===Attendance List===");
        if (attendanceList.isEmpty())
            System.out.println("No students are present.");
        else
            System.out.println(attendanceList);
    }

    public void checkStudent(String name) {
        boolean found = attendanceList.stream()
                .anyMatch(student -> student.getName().equals(name));

        if (found) {
            System.out.println(name + " is present in list.");
        } else {
            System.out.println(name + " is not present in list.");
        }
    }
}
