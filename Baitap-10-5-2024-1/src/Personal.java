public class Personal {
    private int id;
    private String name;
    private String email;
    private String address;
    private int role;

    public Personal(int id, String name, String email, String address, int role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getInfo(){
        return "ID: " + this.id + " Name: " + this.name + " Email: " + this.email + " Address: " + this.address + " Role: " + this.role;
    }
}
