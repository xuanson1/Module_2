import File.User;

public class UserMain {
    public static void main(String[] args) {
        User<Integer,Integer > user = new User<>(1,"Son", 12);
        User<String, Integer> user1 = new User<>("ST01","Luan",12 );
    }
}
