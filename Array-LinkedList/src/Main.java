import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import File.Student;
public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("1: Create new student");
        System.out.println("2: Show list student");
        System.out.println("3: Remove students");
        System.out.println("4: Show student by index: ");
        System.out.println("5: Edit student: ");
        System.out.println("6: Exit");
        int choice = 0;
        while (choice != 6) {
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Enter id: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter age: ");
                    int age = Integer.parseInt(scanner.nextLine());
                    Student student = new Student(id, name, age);
                    students.add(student);
                    break;
                case 2:
                    for (Student item : students) {
                        System.out.println(item);
                    }
                    break;
                case 3:
                    System.out.println("Enter index: ");
                    int indexRemove = Integer.parseInt(scanner.nextLine());
                    students.remove(indexRemove);
                    break;
                case 4:
                    System.out.println("Enter index: ");
                    int indexShow = Integer.parseInt(scanner.nextLine());
                    Student studentShow = students.get(indexShow);
                    System.out.println(studentShow);
                    break;
                case 5:
                    System.out.println("Enter index student update: ");
                    int indexUpdate = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter id: ");
                    int idNew = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter name: ");
                    String nameNew = scanner.nextLine();
                    System.out.println("Enter age: ");
                    int ageNew = Integer.parseInt(scanner.nextLine());
                    Student studentUpdate = new Student(idNew,nameNew,ageNew);
                    students.set(indexUpdate,studentUpdate);
                    break;
                default:
                    break;
            }
            System.out.println("1: Create new student");
            System.out.println("2: Show list student");
            System.out.println("3: Remove Students");
            System.out.println("4: Show student by index: ");
            System.out.println("5: Update Students: ");
            System.out.println("6: Exit");
        }
    }
}