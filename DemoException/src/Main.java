import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Caculator caculator = new Caculator();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a: ");
        int a = scanner.nextInt();
        System.out.println("Enter b: ");
        int b = scanner.nextInt();
        try {
            System.out.println(caculator.subtract(a,b));
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            System.out.println("End!!!");
        }

//        System.out.println(caculator.add(3,4));
//        System.out.println(caculator.subtract(3,4));
//        System.out.println(caculator.multiply(3,4));
//        try {
//            System.out.println(caculator.divide(3,0));
//            System.out.println(caculator.divide(4,0));
//        }catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
    }
}