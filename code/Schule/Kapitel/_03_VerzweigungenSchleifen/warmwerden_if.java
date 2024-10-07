package Schule.Kapitel._03_VerzweigungenSchleifen;

import java.util.Scanner;

public class warmwerden_if {
    public static void main(String[] args) {
        System.out.print("Geben Sie ihr Budget ein: ");
        Scanner scanner = new Scanner(System.in);
        double geld = scanner.nextDouble();

        double ApfelKosten = 2;
        double BananeKosten = 5;
        double KartoffelKosten = 10;

        System.out.println("Ware:\n-Apfel: "+ApfelKosten+"€\n-Banane: "+BananeKosten+"€\n-Kartoffel: "+KartoffelKosten+"€");
        System.out.println("\nIhr Budget: "+geld+"€");
        System.out.println("Was wollen Sie kaufen? ");

        Scanner scan = new Scanner(System.in);
        String choice = scan.nextLine();


        if (choice.equals("Apfel")){
            if (geld<2) {
                System.out.println("Zu wenig Geld");
                System.out.println("Fehlt: "+(ApfelKosten-geld)+"€");
            }
            else {
                System.out.println(choice+" gekauft.");
                System.out.println("Neuer Kontostand: "+(geld-ApfelKosten)+"€");
            }
        }
        else if (choice.equals("Banane")){
            if (geld<5) {
                System.out.println("Zu wenig Geld");
                System.out.println("Fehlt: "+(BananeKosten-geld));
            }
            else {
                System.out.println(choice+" gekauft.");
                System.out.println("Neuer Kontostand: "+(geld-BananeKosten)+"€");
            }
        }
        else if (choice.equals("Kartoffel")){
            if (geld<10) {
                System.out.println("Zu wenig Geld");
                System.out.println("Fehlt: "+(KartoffelKosten-geld)+"€");
            }
            else {
                System.out.println(choice+" gekauft.");
                System.out.println("Neuer Kontostand: "+(geld-KartoffelKosten)+"€");
            }
        }
        else {
            System.out.println("Gibts net");
        }


    }
}
