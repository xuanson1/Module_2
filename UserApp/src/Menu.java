import java.util.Scanner;

public class Menu {
    public Menu(){

    }
    public void showMenu(){
        System.out.println("------Welcome to UserManager App------");
        System.out.println("------Please enter number to use for the app------");
        System.out.println("1. Show List of users");
        System.out.println("2. Add User");
        System.out.println("3. Delete User");
        System.out.println("4. Update User");
        System.out.println("5. Exit");
        System.out.println("------------------------------------");
        System.out.println("Please enter number to use for the app------");
        int choice = getChoice();
        handleChoice(choice);
    }
    public int getChoice(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    public void handleChoice(int choice){
        switch(choice){
            case 1:
                userManager.showList();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            default:
        }
    }
}

