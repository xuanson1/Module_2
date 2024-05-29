public class App {
    public static void main(String[] args) {
        User Nam = new User(1, "John", "john@gmail.com");
        // gọi phương thức
//        String name = Nam.getName();
//        System.out.println(name);
//
//        String infoUser1 = Nam.getInfo();
//        System.out.println(infoUser1);
//
//        Nam.setName("Dung");
//
//        String infoUser = Nam.getInfo();
//        System.out.println(infoUser);
        User Son = new User(2, "Son", "son@gmail.com", "123123");


        User[] listUser = new User[3];
        listUser[0] = Nam;
        listUser[1] = Son;
        for (User u : listUser) {
            if (u != null) {
                System.out.println(u.getInfo());
            }
        }
    }
    // Class Student: id, name, email, GPA
    // Method: getInfo(), set/get
    // tai Main:
    /*
    * - Tao 1 mang co 1 phan tu Student
    * - them 10 object cho mang moi tao
    * - in ra thong tin cua moi phan tu trong mang
    * - in ra so luong hoc vien co GPA > 8.0 */
}
