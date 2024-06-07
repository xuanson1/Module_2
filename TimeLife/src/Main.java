import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDate birthDate = null;

        while (birthDate == null) {
            try {
                System.out.print("Nhập ngày sinh: ");
                int day = scanner.nextInt();
                if (day < 1 || day > 31) {
                    throw new IllegalArgumentException("Ngày phải từ 1 đến 31.");
                }

                System.out.print("Nhập tháng sinh: ");
                int month = scanner.nextInt();
                if (month < 1 || month > 12) {
                    throw new IllegalArgumentException("Tháng phải từ 1 đến 12.");
                }

                System.out.print("Nhập năm sinh: ");
                int year = scanner.nextInt();
                if (year > LocalDate.now().getYear()) {
                    throw new IllegalArgumentException("Năm không được quá năm hiện tại.");
                }

                birthDate = LocalDate.of(year, month, day);

                // Check if the day is valid for the given month and year
                if (birthDate.getMonthValue() != month || birthDate.getDayOfMonth() != day) {
                    throw new IllegalArgumentException("Ngày, tháng, năm không hợp lệ.");
                }

            } catch (Exception e) {
                System.out.println("Lỗi: " + e.getMessage());
                scanner.nextLine(); // Clear the buffer
            }
        }

        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(birthDate, currentDate);
        long daysLived = period.toTotalMonths() * 30 + period.getDays(); // Approximation of days lived
        System.out.println("Số ngày đã sống: " + daysLived);
    }
}
