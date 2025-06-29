package inheritance.collectionAPI.EmployeeDirectory;

import java.util.HashMap;

public class EmployeeManager {
    private HashMap<Integer, String> employeeList;

    public EmployeeManager() {
        employeeList = new HashMap<>();
    }

    public void addEmployee(int id, String employeeName) {
        employeeList.put(id, employeeName);
    }

    public void removeEmployee(int id) {
        if (employeeList.remove(id) != null)
            System.out.println("Employee " + id + " removed.");
        else
            System.out.println("Employee " + id + " not present in directory.");
    }

    public void displayEmployeeList() {
        if (employeeList.isEmpty())
            System.out.println("Employee List is empty.");
        else {
            System.out.println("---- Employee List -----");
            employeeList.forEach((id, employeeName) -> System.out.println("Id: " + id + " Name: " + employeeName));
        }
    }

    public void checkEmployee(int id) {
        if (employeeList.containsKey(id))
            System.out.println("Employee name: " + employeeList.get(id));
        else
            System.out.println("Employee " + id + " is present in directory.");
    }

}
