public class User extends Person implements IDesign {
    protected User(String name, int age){
        super(name, age);
    }
    @Override
public String getInfo(){
        return "User : {name: "+name+", age: "+age+"}";
}
    @Override
    public String getName(){
        return "";
    }
}
