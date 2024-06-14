//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        User user = new User("Teo", 500);
        Bank bank = new Bank("TPBank");
        bank.registerUser(user);

        Thread pay1 = new Thread(bank);
        Thread pay2 = new Thread(bank);
        pay1.start();
        pay2.start();

        pay1.join();
        pay2.join();

        System.out.println("Total money " + user.money);


    }
}