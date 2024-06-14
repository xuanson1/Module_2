public class Bank implements Runnable {
    public String name;
    public User user;

    public Bank(String name) {
        this.name = name;
    }

    public void registerUser(User user) {
        this.user = user;
    }

    public void banking(double amount){
        this.user.pay(amount);
        System.out.println("Money: " + user.money);
    }
    @Override
    public synchronized void run(){
        banking(100);
    }
}
