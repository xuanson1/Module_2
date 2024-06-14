public class User {
    public String name;
    public double money;

    public User(String name,double money) {
        this.name = name;
        this.money = money;
    }
    public void pay(double money){
        if(this.money >= money){
            this.money -= money;
            System.out.println("You payed " + money + " money");
        }
    }
    public String getName() {
        return name;
    }
}
