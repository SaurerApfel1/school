package Privat.Klassen.Autovermietung;

import java.util.Scanner;

public class AutoStandard extends Auto{

    String autoFarbe;

    AutoStandard(String autoMarke, String autoModell, int autoBaujahr, double autoPreis, String autoFarbe) {
        super(autoMarke, autoModell, autoBaujahr, autoPreis);
        this.autoFarbe = autoFarbe;
    }

    public static AutoStandard createAuto(){

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

        System.out.print("Farbe: ");
        String farbe = scanner1.nextLine();

        return new AutoStandard(marke, modell, baujahr, preis, farbe);
    }

}
