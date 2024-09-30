package Schule.Kapitel._02_DatentypenVariablen;

import java.util.Scanner;

public class Verkaufspreis {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Einkaufspreis in €: ");
        double einkaufsPreis = scan.nextDouble();

        double selbstkostenPreis = calcSteuern(einkaufsPreis, 1.40);
        double bruttoPreis = calcSteuern(selbstkostenPreis, 1.05);
        double nettoPreis = calcSteuern(bruttoPreis, 1.19);

        System.out.printf("Selbstkosten: %.2f€\n", selbstkostenPreis);
        System.out.printf("Bruttopreis: %.2f€\n", bruttoPreis);
        System.out.printf("Nettopreis: %.2f€", nettoPreis);


    }
    public static double calcSteuern(double betrag, double percent) {
        return betrag * percent;
    }
}