package Privat.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class arrays {
    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        String[] sortiment = {"apfel", "birne", "orange", "banane"};
        double[] preis = {0.30, 0.75, 0.50, 0.99};
        double kontostand = 100;
        int sortimentLength = sortiment.length;

        System.out.println("<<Sortiment>>");


        int i = 0;

        while (i<sortimentLength) {
            System.out.println("-"+sortiment[i]+" ("+preis[i]+"€ Pro Stück)");
            i++;
        }


        List<String> sortimentList = Arrays.asList(sortiment);
        System.out.println(" ");
        System.out.println("Ihr Kontostand beträgt "+kontostand+"€.");

        boolean run = true;
        while (run){
            System.out.println("\nWas wollen Sie kaufen?");
            String produkt = scan.nextLine();
            produkt = produkt.toLowerCase();
            if (!sortimentList.contains(produkt)) {
                System.out.println("Dat gibts net");
            }

            else {
                System.out.println("Wie viele wollen Sie kaufen?");
                int menge = scan.nextInt();
                double kosten = preis[sortimentList.indexOf(produkt)] * menge;
                if ((kontostand - kosten)<0) {
                    System.out.println("Kostet: "+kosten);
                    System.out.println("Konto: "+kontostand);
                    System.out.println("Ihnen fehlen "+(kosten-kontostand)+"€.");
                }

                else {
                    kontostand = kontostand - kosten;
                    System.out.println("Sie haben "+menge+" mal "+produkt+" gekauft.");
                    System.out.println("Neuer Kontostand: "+kontostand+"€");
                    System.out.print(">");
                    scan.nextLine();
                    System.out.println("Beliebige Eingabe zum fortfahren oder 'q' zum verlassen");
                    String eingabe = scan.nextLine();

                    if (eingabe.equals("q")) {
                        run = false;
                    }

                    else {
                        System.out.println(" ");
                    }
                }
            }
            System.out.print(">");
            scan.nextLine();
        }
    }
}
