package Privat.Klassen.Autovermietung;

import java.util.Scanner;

public class AutoSport extends Auto {

    int autoGeschwindigkeit;

    AutoSport(String autoMarke, String autoModell, int autoBaujahr, double autoPreis, int autoGeschwindigkeit) {
        super(autoMarke, autoModell, autoBaujahr, autoPreis);
        this.autoGeschwindigkeit = autoGeschwindigkeit;
    }

    public static AutoSport createAuto(){

        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);

        System.out.println("Geben Sie die Attribute ein");
        System.out.print("Marke: ");
        String marke = scanner.nextLine();

        System.out.print("Modell: ");
        String modell = scanner.nextLine();

        System.out.print("Baujahr: ");
        int baujahr = scanner.nextInt();

        System.out.println("Preis: ");
        double preis = scanner.nextDouble();

        System.out.print("Geschwindigkeit: ");
        int geschwindigkeit = scanner1.nextInt();

        return new AutoSport(marke, modell, baujahr,preis, geschwindigkeit);
    }

}
