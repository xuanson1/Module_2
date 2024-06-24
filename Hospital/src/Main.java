import static Manager.MedicalRecordManagementSystem.*;
public class Main {
public static void main(String[] args) {
        loadMedicalRecords();

        showMenu();

        saveMedicalRecords();

        System.out.println("Đã thoát chương trình.");
    }
}