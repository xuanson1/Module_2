//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Personal Ngoc = new Personal(1,"Ngoc","ngoc@gmail.com","11dsa",1);
        Personal Nam = new Personal(2,"Nam","nam@gmail.com","11dsa",2);
        Personal Quan = new Personal(3,"Quan","quan@gmail.com", "11dsa",3);
        Personal Thu = new Personal(4,"Thu","thu@gmail.com", "11dsa",4);
        Personal Bui = new Personal(5,"Bui","khoa@gmail.com","11dsa",2 );
        Personal[] listPersonal = new Personal[5];
        listPersonal[0] = Ngoc;
        listPersonal[1] = Nam;
        listPersonal[2] = Quan;
        listPersonal[3] = Thu;
        listPersonal[4] = Bui;
        for(Personal personal : listPersonal){
            if(personal.getRole() == 2){
                System.out.println(personal.getInfo());
            }
        }
        }
    }
