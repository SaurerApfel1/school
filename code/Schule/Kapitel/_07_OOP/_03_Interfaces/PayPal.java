package Schule.Kapitel._07_OOP._03_Interfaces;

public class PayPal implements Zahlungsmethode {
    String email;
    double kontostand = 0;

    public PayPal(String email) {
        this.email = email;
    }

    @Override
    public void bezahlen(double betrag) {
        // TODO Auto-generated method stub
        if (istGueltig(betrag)) {
            kontostand += betrag;
            System.out.println("Bezahlung mit PayPal: " + betrag + "€ auf dein Konto");
            System.out.println("Neuer Kontostand: " + kontostand + "€");
            System.out.println();
        }
    }

    @Override
    public boolean istGueltig(double betrag) {
        if (betrag < 0) {
            System.out.println("Betrag muss positiv sein!");
            return false;
        } else if (betrag > 10000) {
            System.out.println("Betrag zu hoch!");
            return false;
        } else {
            System.out.println("Betrag ist gültig!");
            
            return true;
        }
        // TODO Auto-generated method stub
        
    }

    @Override
    public void besitzerDetails() {
        // TODO Auto-generated method stub
        System.out.println("PayPal-Besitzer: " + email);
        System.out.println("Kontostand: " + kontostand + "€");
       
    }

}
