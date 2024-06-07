package File;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private List<Student> students;

    public StudentManager() {
        this.students = new ArrayList<Student>();
    }

    public List<Student> getStudents() {
        return students;
    }

     public void addStudent(Student student) {
        students.add(student);
     }
     public List<Student> searchStudentByName(String keyword) {
        List<Student> data = new ArrayList<>();
        for (Student student : students) {
            if(student.getName().equals(keyword)){
                data.add(student);
            }
        }
        return data;
     }
    public List<Student> searchStudentByID(int id) {
        List<Student> data = new ArrayList<>();
        for (Student student : students) {
            if(student.getId()==id){
                data.add(student);
            }
        }
        return data;
    }
    public List<Student> searchStudentByGender(String gender) {
        List<Student> data = new ArrayList<>();
        for (Student student : students) {
            if(student.getGender().equals(gender)){
                data.add(student);
            }
        }
        return data;
    }
    public List<Student> searchStudentByAge(int age) {
        List<Student> data = new ArrayList<>();
        for (Student student : students) {
            if(student.getAge() == age){
                data.add(student);
            }
        }
        return data;
    }
}
