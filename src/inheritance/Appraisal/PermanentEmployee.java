package inheritance.Appraisal;

public class PermanentEmployee extends Employee {
    float basicSalary;
    float hra;
    float da;

    public PermanentEmployee() {
        System.out.println("Permanent Employee");
    }

    public PermanentEmployee(int id, String name, float basicSalary) {
        super(id, name);
        this.basicSalary = basicSalary;
    }

    @Override
    void calculateSalary() {
        hra = basicSalary * 0.12f;
        da = basicSalary * 0.1f;
        salary = basicSalary + hra + da;
    }

    void display() {
        super.display();
        System.out.println("Basic Salary: " + basicSalary);
        System.out.println("HRA: " + hra);
        System.out.println("DA: " + da);
    }

    @Override
    public String toString() {
        return "PermanentEmployee [id=" + id + ", name=" + name + ", basicSalary=" + basicSalary + ", salary=" + salary
                + ", hra=" + hra + ", da=" + da + "]";
    }

}