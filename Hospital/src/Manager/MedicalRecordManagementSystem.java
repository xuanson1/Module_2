package Manager;

import MedicalRecord.*;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class MedicalRecordManagementSystem {
    private static final String CSV_FILE_PATH = "data.csv";
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static List<MedicalRecord> medicalRecords = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void showMenu() {
        int choice;
        do {
            System.out.println("====== CHƯƠNG TRÌNH QUẢN LÝ BỆNH ÁN ======");
            System.out.println("1. Thêm mới bệnh án");
            System.out.println("2. Xóa bệnh án");
            System.out.println("3. Xem danh sách bệnh án");
            System.out.println("4. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addNewMedicalRecord();
                    break;
                case 2:
                    deleteMedicalRecord();
                    break;
                case 3:
                    displayMedicalRecords();
                    break;
                case 4:
                    System.out.println("Đã thoát chương trình.");
                    saveMedicalRecords();
                    break;
                default:
                    System.out.println("Chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 4);
    }

    private static void addNewMedicalRecord() {
        System.out.println("Thêm mới bệnh án:");

        System.out.print("Nhập mã bệnh án (BA-XXX): ");
        String recordCode = scanner.nextLine();

        if (!isValidRecordCode(recordCode)) {
            System.out.println("Mã bệnh án không hợp lệ. Vui lòng nhập lại.");
            return;
        }

        String patientCode;
        do {
            System.out.print("Nhập mã bệnh nhân (BN-XXX, với XXX là số 3 chữ số): ");
            patientCode = scanner.nextLine();
            if (!isValidPatientCode(patientCode)) {
                System.out.println("Mã bệnh nhân không hợp lệ. Vui lòng nhập lại.");
            }
        } while (!isValidPatientCode(patientCode));

        System.out.print("Nhập tên bệnh nhân: ");
        String patientName = scanner.nextLine();

        LocalDate admissionDate;
        LocalDate dischargeDate;
        do {
            System.out.print("Nhập ngày nhập viện (dd/MM/yyyy): ");
            admissionDate = LocalDate.parse(scanner.nextLine(), dateFormatter);

            System.out.print("Nhập ngày ra viện (dd/MM/yyyy): ");
            dischargeDate = LocalDate.parse(scanner.nextLine(), dateFormatter);

            if (dischargeDate.isBefore(admissionDate)) {
                System.out.println("Ngày ra viện phải sau ngày nhập viện. Vui lòng nhập lại.");
            }
        } while (dischargeDate.isBefore(admissionDate));

        System.out.print("Nhập lý do nhập viện: ");
        String reasonForAdmission = scanner.nextLine();


        System.out.print("Bệnh án VIP? (Yes/No): ");
        String isVipInput = scanner.nextLine();
        boolean isVipPatient = isVipInput.equalsIgnoreCase("yes");

        MedicalRecord newRecord;
        if (isVipPatient) {

            System.out.print("Loại VIP: ");
            String vipType = scanner.nextLine();

            System.out.print("Ngày hết hạn VIP (dd/MM/yyyy): ");
            LocalDate vipValidity = LocalDate.parse(scanner.nextLine(), dateFormatter);

            newRecord = new VIPMedicalRecord(recordCode, patientCode, patientName, admissionDate, dischargeDate,
                    reasonForAdmission, vipType, vipValidity);
        } else {

            System.out.print("Chi phí bệnh viện: ");
            double hospitalFee = Double.parseDouble(scanner.nextLine());

            newRecord = new RegularMedicalRecord(recordCode, patientCode, patientName, admissionDate, dischargeDate,
                    reasonForAdmission, hospitalFee);
        }

        medicalRecords.add(newRecord);
        System.out.println("Thêm mới bệnh án thành công.");

    }



    private static void deleteMedicalRecord() {
        System.out.println("Xóa bệnh án:");
        System.out.print("Nhập mã bệnh án cần xóa: ");
        String deleteRecordCode = scanner.nextLine();

        boolean found = false;
        for (MedicalRecord record : medicalRecords) {
            if (record.getRecordCode().equals(deleteRecordCode)) {
                found = true;
                System.out.print("Bạn có chắc chắn muốn xóa bệnh án này? (Yes/No): ");
                String confirm = scanner.nextLine();
                if (confirm.equalsIgnoreCase("yes")) {
                    medicalRecords.remove(record);
                    System.out.println("Đã xóa bệnh án.");
                    displayMedicalRecords();
                    saveMedicalRecords();
                    break;
                } else {
                    System.out.println("Không xóa bệnh án.");
                    break;
                }
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy mã bệnh án để xóa.");
        }
    }

    private static void displayMedicalRecords() {
        System.out.println("Danh sách bệnh án:");
        System.out.printf("%-10s %-15s %-15s %-20s %-20s %-20s %-20s\n", "STT", "Mã BA", "Mã BN", "Tên BN",
                "Ngày nhập viện", "Ngày ra viện", "Lý do nhập viện");
        for (MedicalRecord record : medicalRecords) {
            System.out.printf("%-10d %-15s %-15s %-20s %-20s %-20s %-20s\n", record.getRecordNumber(),
                    record.getRecordCode(), record.getPatientCode(), record.getPatientName(),
                    record.getAdmissionDate().format(dateFormatter),
                    record.getDischargeDate().format(dateFormatter),
                    record.getReasonForAdmission());
        }
    }

    public static void loadMedicalRecords() {
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String line;
            boolean isFirstLine = true;
            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] fields = line.split(",");
                if (fields.length == 7) {
                    int recordNumber = Integer.parseInt(fields[0]);
                    String recordCode = fields[1];
                    String patientCode = fields[2];
                    String patientName = fields[3];
                    LocalDate admissionDate = LocalDate.parse(fields[4], dateFormatter);
                    LocalDate dischargeDate = LocalDate.parse(fields[5], dateFormatter);
                    String reasonForAdmission = fields[6];

                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file dữ liệu: " + e.getMessage());
        }
    }

    public static void saveMedicalRecords() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE_PATH))) {
            writer.write("STT,Mã BA,Mã BN,Tên BN,Ngày nhập viện,Ngày ra viện,Lý do nhập viện\n");
            for (MedicalRecord record : medicalRecords) {
                writer.write(record.getRecordNumber() + "," +
                        record.getRecordCode() + "," +
                        record.getPatientCode() + "," +
                        record.getPatientName() + "," +
                        record.getAdmissionDate().format(dateFormatter) + "," +
                        record.getDischargeDate().format(dateFormatter) + "," +
                        record.getReasonForAdmission() + "\n");
            }
            System.out.println("Đã lưu danh sách bệnh án vào file CSV.");
        } catch (IOException e) {
            System.out.println("Lỗi khi lưu file dữ liệu: " + e.getMessage());
        }
    }

    private static boolean isValidRecordCode(String recordCode) {
        return recordCode.matches("^BA-\\d{3}$");
    }
    private static boolean isValidPatientCode(String patientCode) {
        return patientCode.matches("^BN-\\d{3}$");
    }
}
