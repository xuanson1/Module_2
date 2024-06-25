package Employee;

import java.time.LocalDate;

public abstract class Employee {
    private String employeeId;
    private String name;
    private LocalDate dateOfBirth;
    private String address;

    public Employee(String employeeId, String name, LocalDate dateOfBirth, String address) {
        this.employeeId = employeeId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return employeeId + "," + name + "," + dateOfBirth + "," + address + "," + calculateSalary();
    }
}
