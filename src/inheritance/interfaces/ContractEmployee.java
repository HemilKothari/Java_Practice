package inheritance.interfaces;

public class ContractEmployee extends Employee implements IncomeTax, GoodAndServicesTax {
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
    public void payGST() {
        if (salary > EXEMPT_GST) {
            System.out.println("GST Paid.");
        } else {
            System.out.println("GST Not Applicable.");
        }
    }

    @Override
    public void payTax() {
        if (salary > EXEMPT_AMOUNT) {
            System.out.println("Tax Paid.");
        } else {
            System.out.println("Tax Not Applicable.");
        }
    }

}