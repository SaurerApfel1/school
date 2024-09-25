package Schule.unterricht;

import java.util.Scanner;

public class Verkaufspreis {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Einkaufspreis: ");
        double einkaufsPreis = scan.nextDouble();

        double selbstkostenPreis = calcSelbstkostenpreis(einkaufsPreis);
        double bruttoPreis = calcBruttopreis(selbstkostenPreis);
        double nettoPreis = calcNettopreis(bruttoPreis);

        System.out.printf("Selbstkosten: %.2f€\n", selbstkostenPreis);
        System.out.printf("Bruttopreis: %.2f€\n", bruttoPreis);
        System.out.printf("Nettopreis: %.2f€", nettoPreis);


    }

    public static double calcSelbstkostenpreis(double einkaufsPreis) {
        return einkaufsPreis*1.4;
    }
    public static double calcBruttopreis(double selbstkosten) {
        return selbstkosten*1.05;
    }
    public static double calcNettopreis(double brutto) {
        return brutto*1.19;
    }
}
