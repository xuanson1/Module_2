public class Student extends Person {
    protected String group;
    protected Student(String name, int age, String group){
        super(name, age);
        this.group = group;
    }
    public String getInfo(){
        return "Student: { name:"+name+", age:"+age+", group:"+group+"}";
    }


}
