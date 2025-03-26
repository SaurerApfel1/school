package Schule.Kapitel._07_OOP.HA_2_Polymorhpie;

import java.util.Scanner;

public class Admin extends User{

    public Admin(String userName, String passwort, Boolean isLogged) {
        super(userName, passwort, isLogged);
    }

    @Override
    public void login(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Gib dein Passwort ein: ");
        String temp = scanner.nextLine();
        if (temp.equals(passwort)) {
            System.out.println("Admin: "+userName+" hat sich mit vollen Rechten eingeloggt.");
        }
        else{
            System.out.println("Falsches Passwort eingegeben!");
        }
    }
    @Override
    public void logout(){
        System.out.println("Admin: "+userName+" hat sich mit vollen Berechtigungen ausgeloggt.");
        this.isLogged = false;
    }
    @Override
    public void nutzerEntfernen(User user){
        System.out.println("Admin: "+userName+" hat "+user.userName+" entfernt!");
        user = null;
    }

}
