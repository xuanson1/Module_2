public abstract class Customer extends Person {
    protected String email;
    public Customer(String name,int age,String email) {
        super(name,age);
        this.email = email;
    }
    public String getInfo(){
        return "Customer {name: "+ name+", age: "+ age+", email: "+ email+"}";
    }
}
