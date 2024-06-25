package Employee;

import java.time.LocalDate;

public class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public PartTimeEmployee(String employeeId, String name, LocalDate dateOfBirth, String address, double hourlyRate, int hoursWorked) {
        super(employeeId, name, dateOfBirth, address);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
}
