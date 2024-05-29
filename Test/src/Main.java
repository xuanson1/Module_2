import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // viet chuong trinh tim danh sach cac uoc cua 1 so n bat ki
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập một số bất kỳ: ");
        int number = input.nextInt();
        System.out.print("Các uớc của " + number + ": ");
        for(int i = 1;i <= number; i++){
            if(number % i == 0){
                System.out.print(i + "\t ");
            }

        }
    }
}