import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Width: ");
        double width = sc.nextDouble();
        System.out.println("Enter the Height: ");
        double height = sc.nextDouble();
        Rectangle rectangle = new Rectangle(width, height);
        System.out.println("Your rectangle is: " + rectangle.display());
        System.out.println("Perimeter of the Rectangle is: " + rectangle.getPerimeter());
        System.out.println("Area of the Rectangle is: " + rectangle.getArea());
    }
}