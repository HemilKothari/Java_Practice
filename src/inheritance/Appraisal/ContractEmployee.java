package inheritance.Appraisal;

public class ContractEmployee extends Employee {
    int ratePerHour;
    float hoursWorked;

    public ContractEmployee() {
        System.out.println("Contract Employee");
    }

    public ContractEmployee(int id, String name, float hoursWorked, int ratePerHour) {
        super(id, name);
        this.hoursWorked = hoursWorked;
        this.ratePerHour = ratePerHour;
    }

    @Override
    void calculateSalary() {
        salary = ratePerHour * hoursWorked;
    }

    void display() {
        super.display();
        System.out.println("Rate Per Hour: " + ratePerHour);
        System.out.println("Hours Worked: " + hoursWorked);
    }

    @Override
    public String toString() {
        return "ContractEmployee [id=" + id + ", name=" + name + ", ratePerHour=" + ratePerHour + ", salary=" + salary
                + ", hoursWorked=" + hoursWorked + "]";
    }

}