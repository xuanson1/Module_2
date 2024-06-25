package Manager;

import Employee.*;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public abstract class EmployeeManager {
    private static final String CSV_FILE_PATH = "data.csv";
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static List<Employee> employees = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void showMenu() {
        int choice;
        do {
            System.out.println("====== Employee Management System ======");
            System.out.println("1. Thêm mới nhân viên");
            System.out.println("2. Xóa nhân viên");
            System.out.println("3. Xem danh sách nhân viên");
            System.out.println("4. Tìm kiếm nhân viên");
            System.out.println("5. Sắp xếp nhân viên theo tên");
            System.out.println("6. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addNewEmployee();
                    break;
                case 2:
                    deleteEmployee();
                    break;
                case 3:
                    displayEmployees();
                    break;
                case 4:
                    searchEmployee();
                    break;
                case 5:
                    sortEmployeesByName();
                    displayEmployees();
                    break;
                case 6:
                    System.out.println("Đã thoát chương trình.");
                    saveEmployees();
                    break;
                default:
                    System.out.println("Chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 6);
    }

    private static void addNewEmployee() {
        System.out.println("Thêm mới nhân viên:");

        System.out.print("Nhập mã nhân viên : ");
        String employeeId = scanner.nextLine();

        System.out.print("Nhập tên nhân viên: ");
        String name = scanner.nextLine();

        LocalDate dateOfBirth;
        while (true) {
            try {
                System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
                dateOfBirth = LocalDate.parse(scanner.nextLine(), dateFormatter);
                break;
            } catch (Exception e) {
                System.out.println("Định dạng ngày tháng không hợp lệ. Vui lòng nhập lại.");
            }
        }

        System.out.print("Nhập địa chỉ: ");
        String address = scanner.nextLine();

        System.out.print("Nhân viên toàn thời gian? (Yes/No): ");
        String isFullTimeInput = scanner.nextLine();
        boolean isFullTime = isFullTimeInput.equalsIgnoreCase("yes");

        Employee newEmployee;
        if (isFullTime) {
            System.out.print("Nhập lương: ");
            double salary = scanner.nextDouble();
            scanner.nextLine();
            newEmployee = new FullTimeEmployee(employeeId, name, dateOfBirth, address, salary);
        } else {
            System.out.print("Nhập lương theo giờ: ");
            double hourlyRate = scanner.nextDouble();
            System.out.print("Nhập số giờ làm việc: ");
            int hoursWorked = scanner.nextInt();
            scanner.nextLine();
            newEmployee = new PartTimeEmployee(employeeId, name, dateOfBirth, address, hourlyRate, hoursWorked);
        }

        employees.add(newEmployee);
        System.out.println("Thêm mới nhân viên thành công.");
        saveEmployees();
    }

    private static void deleteEmployee() {
        System.out.print("Nhập mã nhân viên cần xóa: ");
        String employeeId = scanner.nextLine();
        boolean found = false;
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getEmployeeId().equals(employeeId)) {
                found = true;
                System.out.print("Bạn có chắc chắn muốn xóa nhân viên này? (Yes/No): ");
                String confirm = scanner.nextLine();
                if (confirm.equalsIgnoreCase("yes")) {
                    iterator.remove();
                    System.out.println("Đã xóa nhân viên.");
                    displayEmployees();
                    saveEmployees();
                } else {
                    System.out.println("Không xóa nhân viên.");
                }
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy mã nhân viên để xóa.");
        }
    }

    private static void displayEmployees() {
        System.out.println("Danh sách nhân viên:");
        System.out.printf("%-15s %-20s %-15s %-20s %-15s\n", "Mã NV", "Tên NV", "Ngày sinh", "Địa chỉ", "Lương");
        for (Employee employee : employees) {
            System.out.printf("%-15s %-20s %-15s %-20s %-15.2f\n", employee.getEmployeeId(), employee.getName(),
                    employee.getDateOfBirth().format(dateFormatter), employee.getAddress(), employee.calculateSalary());
        }
    }

    private static void searchEmployee() {
        System.out.print("Nhập mã nhân viên cần tìm: ");
        String employeeId = scanner.nextLine();
        Employee employee = searchEmployeeById(employeeId);
        if (employee != null) {
            System.out.println("Thông tin nhân viên: " + employee);
        } else {
            System.out.println("Không tìm thấy nhân viên.");
        }
    }

    private static Employee searchEmployeeById(String employeeId) {
        for (Employee employee : employees) {
            if (employee.getEmployeeId().equals(employeeId)) {
                return employee;
            }
        }
        return null;
    }

    public static void sortEmployeesByName() {
        employees.sort(Comparator.comparing(Employee::getName));
    }


    public static void loadEmployees() {
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String line;
            boolean isFirstLine = true;
            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] fields = line.split(",");
                if (fields.length == 5) {
                    String employeeId = fields[0];
                    String name = fields[1];
                    LocalDate dateOfBirth = LocalDate.parse(fields[2], dateFormatter);
                    String address = fields[3];
                    double salary = Double.parseDouble(fields[4]);
                    employees.add(new FullTimeEmployee(employeeId, name, dateOfBirth, address, salary));
                } else if (fields.length == 6) {
                    String employeeId = fields[0];
                    String name = fields[1];
                    LocalDate dateOfBirth = LocalDate.parse(fields[2], dateFormatter);
                    String address = fields[3];
                    double hourlyRate = Double.parseDouble(fields[4]);
                    int hoursWorked = Integer.parseInt(fields[5]);
                    employees.add(new PartTimeEmployee(employeeId, name, dateOfBirth, address, hourlyRate, hoursWorked));
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file dữ liệu: " + e.getMessage());
        }
    }

    private static void saveEmployees() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE_PATH))) {
            writer.write("Mã NV,Tên NV,Ngày sinh,Địa chỉ,Lương/Số giờ làm việc,Lương theo giờ\n");
            for (Employee employee : employees) {
                writer.write(employee.toString() + "\n");
            }
            System.out.println("Đã lưu danh sách nhân viên vào file CSV.");
        } catch (IOException e) {
            System.out.println("Lỗi khi lưu file dữ liệu: " + e.getMessage());
        }
    }
}
