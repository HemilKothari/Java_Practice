package inheritance.interfaces;

public class PermanentEmployee extends Employee implements IncomeTax, ProvidentFund{
    float basicSalary;
    float hra;
    float da;

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
    public void openAccount() {
        System.out.println("Account Opened.");
    }

    @Override
    public void deposit() {
        System.out.println("Amount Deposited.");
    }

    @Override
    public void withdraw() {
        System.out.println("Amount Withdrawn.");
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