package Employee;

import java.time.LocalDate;

public class FullTimeEmployee extends Employee {
    private double salary;

    public FullTimeEmployee(String employeeId, String name, LocalDate dateOfBirth, String address, double salary) {
        super(employeeId, name, dateOfBirth, address);
        this.salary = salary;
    }

    @Override
    public double calculateSalary() {
        return salary;
    }
}
