public class Student {
    public int id;
    public String name;
    public String email;
    public double GPA;



    public Student(int id, String name, String email, double GPA) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.GPA = GPA;
    }
    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getEmail(){
        return this.email;
    }
    public double getGPA(){
        return this.GPA;
    }

    public String getInfo(){
        return "ID: " + this.id + " Name: " + this.name + " Email: " + this.email + " GPA: " + this.GPA;

    }
    public void setId(int id){}
    public void setName(String name){
        this.name = name;
    }
    public void setEmail(String email){this.email = email;}
    public void setGPA(double GPA){this.GPA = GPA;}
}
