package Schule.Kapitel._07_OOP._02_Polymorhpie;

import java.util.Scanner;

public class User {

    protected String userName;
    protected String passwort;
    protected boolean isLogged;

    public boolean getIsLogged() {
        return isLogged;
    }

    public User(String userName, String passwort,Boolean isLogged){
        this.userName = userName;
        this.passwort = passwort;

    }

    public void login(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Gib dein Passwort ein: ");
        String temp = scanner.nextLine();
        if (temp.equals(passwort)) {
            System.out.println(userName+" hat sich eingeloggt.");
        }
        else{
            System.out.println("Falsches Passwort eingegeben!");
        }
    }

    public void logout(){
        System.out.println(userName+" hat sich ausgeloggt.");
        this.isLogged = false;
    }

    public void nutzerEntfernen(User user){
        System.out.println("Es fehlt die Berechtigung!");
    }

}

