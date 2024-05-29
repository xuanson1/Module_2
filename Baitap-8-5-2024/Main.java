public class Main {
    public static void main(String[] args) {
        // Class Student: id, name, email, GPA
        // Method: getInfo(), set/get
        // tai Main:
        /*
         * - Tao 1 mang co 5 phan tu Student
         * - them 10 object cho mang moi tao
         * - in ra thong tin cua moi phan tu trong mang
         * - in ra so luong hoc vien co GPA > 8.0 */
        Student Ngoc = new Student(1,"Ngoc","ngoc@gmail.com",8.5);
        Student Nam = new Student(2,"Nam","nam@gmail.com",8.2);
        Student Quan = new Student(3,"Quan","quan@gmail.com",8.1);
        Student Thu = new Student(4,"Thu","thu@gmail.com",8.0);
        Student Khoa = new Student(5,"Khoa","khoa@gmail.com",1.0);
        Student[] listStudent = new Student[5];
        listStudent[0] = Ngoc;
        listStudent[1] = Nam;
        listStudent[2] = Quan;
        listStudent[3] = Thu;
        listStudent[4] = Khoa;
        System.out.println("Danh sách học viên");
        for (Student u : listStudent) {
            if (u != null) {
                System.out.println(u.getInfo());
            }
        }
        int count = 0;
        System.out.println("Các học viên đạt 8.0 GPA: ");
        for (Student student : listStudent) {
            if(student.getGPA() >= 8.0){
                count++;
                System.out.println( student.getInfo());
            }
        }
        System.out.println("Số lượng học viên đạt 8.0 GPA :"+count);
    }
}

