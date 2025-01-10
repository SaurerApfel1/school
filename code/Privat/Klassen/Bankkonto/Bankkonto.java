package Privat.Klassen.Bankkonto;
import java.util.Random;

public class Bankkonto {
    String kontoNummer;
    double kontoStand;

    public Bankkonto(String kontoNummer, double kontoStand){
        this.kontoNummer = kontoNummer;
        this.kontoStand = kontoStand;
    }

    public String createAccNum(){
        Random random = new Random();
        int accNumLength = 10;
        String accNum = "";
        for (int i=0; i<accNumLength; i++){
            int randInt = random.nextInt(0,9);
            accNum += randInt;
        }
        return accNum;
    }

    public void printStats(){
        System.out.println("---------------------------------------------------------");
        System.out.printf("Kontonummer: "+this.kontoNummer+"\nKontostand: %.2f€%n", this.kontoStand);
        System.out.println("---------------------------------------------------------");
    }

    public void einzahlen(double betrag){
        this.kontoStand += betrag;
        System.out.printf("Erfolgreich eingezahlt!\nKontostand: %.2f€%n", this.kontoStand);
    }

    public void abheben(double betrag){
        if (betrag>this.kontoStand){
            System.out.println("Ihr Kontostand ist zu niedrig...");
        }
        else {
            this.kontoStand -= betrag;
            System.out.printf("Erfolgreich abgehoben!\nKontostand: %.2f€%n", this.kontoStand);
        }
    }

}
