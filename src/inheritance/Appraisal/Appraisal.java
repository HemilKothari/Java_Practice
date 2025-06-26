package inheritance.Appraisal;

public class Appraisal {

    void calculateAppraisal(Employee employee) {
        employee.salary = employee.salary * 1.02f;
        System.out.println("====After Appraisal====");
        employee.display();
    }

    void calculateAppraisalByType(Employee employee) {
        if (employee instanceof PermanentEmployee) {
            ((PermanentEmployee) employee).basicSalary *= 1.05f;
            ((PermanentEmployee) employee).calculateSalary();
        }
        else {
            if (((ContractEmployee) employee).hoursWorked > 100)
                employee.salary *= 1.1f;
        }
        System.out.println("====After Appraisal====");
        employee.display();
    }

}
