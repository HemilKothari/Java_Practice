package inheritance.interfaces;

public class Employee {
    int id;
    String name;
    float salary;

    Employee() {
        System.out.println("Employee");
    }

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Employee(int id, String name, float salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    void display() {
        System.out.println("Id: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
    }

    void calculateSalary() {

    }

}
