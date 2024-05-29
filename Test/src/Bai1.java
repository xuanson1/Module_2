import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        // Nhập vào giá trị a và b; b>a
        // tim ước chung lớn nhất của a và b
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập một số a: ");
        int a = input.nextInt();
        System.out.print("Nhập một số b: ");
        int b = input.nextInt();
        int c = 1;
        for(int i = 1; i <= a; i++){
            if(a%i==0 && b%i==0){
                c = i;
            }
        }
        System.out.print("Ước chung lớn nhất của " + a + " và " + b + " là : " + c);
    }
}
