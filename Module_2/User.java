public class User {
    // ds các thuộc tính : đặc điểm
    // thuộc tính: id, name, email, password
    public int id;
    public String name;
    public String email;
    public String password;

    // phương thức khởi tạo -> khởi tạo đối tượng
    // đặt giá trị ban đầu cho thuộc tính

    public User(){}

    public User(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }


    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    public String getName(){
        return this.name;
    }
    public String getInfo(){
        return "ID: " + this.id + " Name: " + this.name + " Email: " + this.email + " Password: " + this.password;

    }
    public void setName(String name){
        this.name = name;
    }
}
