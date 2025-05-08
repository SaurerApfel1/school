package Schule.Kapitel._07_OOP._03_Interfaces;

public class KreditKarte implements Zahlungsmethode{
    String kreditkartenNummer;
    String besitzer;
    double kontostand = 0;

    public KreditKarte(String kreditkartenNummer, String besitzer) {
        this.kreditkartenNummer = kreditkartenNummer;
        this.besitzer = besitzer;
    }

    @Override
    public void bezahlen(double betrag) {
        if (istGueltig(betrag)) {
            kontostand += betrag;
            System.out.println("Du zahlst " + betrag + "€ auf dein Konto ein.");
            System.out.println("Neuer Kontostand: " + kontostand + "€");    
            System.out.println();

        }
    }

    @Override
    public boolean istGueltig(double betrag) {
        // TODO Auto-generated method stub

        if (betrag < 0) {
            System.out.println("Betrag muss positiv sein!");
            return false;
        } else if (betrag > 10000) {
            System.out.println("Betrag zu hoch!");
            return false;
        } else {
            System.out.println("Betrag ist gültig!");
            return true;
        }    }

    @Override
    public void besitzerDetails() {
        // TODO Auto-generated method stub
        System.out.println("Besitzer: " + besitzer);
        System.out.println("Kreditkarten-Nummer: " + kreditkartenNummer);
        System.out.println("Kontostand: " + kontostand + "€");
    }

}
