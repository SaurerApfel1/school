package Schule.Kapitel._07_OOP._03_Interfaces;

public class Run {
    public static void main(String[] args) {
        Zahlungsmethode kreditKarte = new KreditKarte("1234-5678-9012-3456", "Paul Klaßen");
        Zahlungsmethode payPal = new PayPal("skibidiKhoi@gmail.com");

        Zahlungsmethode[] zahlungsmethoden = {kreditKarte, payPal};

        for( Zahlungsmethode methoden : zahlungsmethoden){
            System.out.println("-------------------------------");
            methoden.bezahlen(100);
            methoden.besitzerDetails();
        }
    }
}
