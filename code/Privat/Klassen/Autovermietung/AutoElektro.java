package Privat.Klassen.Autovermietung;

import java.util.Scanner;

public class AutoElektro extends Auto{

    int autoReichweite; //in km

    AutoElektro(String autoMarke, String autoModell, int autoBaujahr, double autoPreis, int autoReichweiteKM) {
        super(autoMarke, autoModell, autoBaujahr, autoPreis);
        this.autoReichweite = autoReichweiteKM;
    }

    public static AutoElektro createAuto(){

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

        System.out.print("Reichweite: ");
        int reichweite = scanner1.nextInt();

        return new AutoElektro(marke, modell, baujahr, preis,  reichweite);
    }

}
