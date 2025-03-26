package Schule.Kapitel._07_OOP.HA_2_Polymorhpie;

import java.util.Scanner;

public class Run {

    public static void main(String[] args) {
        User user = null;
        Scanner scan = new Scanner(System.in);
        System.out.println("1.User, 2.Admin, 3.Gast");
        String rolle = scan.nextLine();
        switch(rolle){
            case "1": user = new User("KhoiAlphaWolf", "123", true);break;
            case "2": user = new Admin("KhoiAlphaWolf", "123", true);break;
            case "3": user = new Gast("KhoiAlphaWolf", "123", true);break;
            default: user = new User("KhoiAlphaWolf", "123", true);break;
        }
        System.out.println(user.userName);

        User paul = new User("PaulDerKrasse", "123", true);
    
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print(">");
            String message = scanner.nextLine();
            switch (message) {
                case "login": user.login();
                break;
                case "logout": user.logout();
                break;
                case "delete": user.nutzerEntfernen(paul);
                default:
                    break;
            }
        }
    }
}
