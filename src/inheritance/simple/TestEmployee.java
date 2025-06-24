package inheritance.simple;

public class TestEmployee {
    public static void main(String[] args) {
        
    PermanentEmployee permanentEmployee = new PermanentEmployee();
    permanentEmployee.id = 101;
    permanentEmployee.name = "John Doe";
    permanentEmployee.basicSalary = 25000f;

    permanentEmployee.calculateSalary();
    permanentEmployee.display();

    }
}
