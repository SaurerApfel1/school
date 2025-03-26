package Schule.Kapitel._07_OOP.HA_2_Polymorhpie;

public class Gast extends User{

    public Gast(String userName, String passwort,Boolean isLogged) {
        super(userName, passwort, isLogged);
    }
    @Override
    public void login(){
        System.out.println(userName+" hat sich eingeloggt.");
    }
    
    @Override
    public void logout(){
        System.out.println(userName+" hat sich ausgeloggt.");
        this.isLogged = false;
    }

}
