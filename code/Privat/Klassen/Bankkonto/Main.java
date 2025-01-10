package Privat.Klassen.Bankkonto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String aktion = "";
        Bankkonto bankkonto = new Bankkonto("", 0.0);
        bankkonto.kontoNummer = bankkonto.createAccNum();
        double betrag;

        while (!aktion.equals("q")){
            Scanner scan = new Scanner(System.in);
            System.out.print("\nWillkommen bei der Bank, was wollen Sie tun?\n1.Konto Status\n2.Einzahlen\n3.Abheben\n'q' um das Programm zu beenden\n>");
            aktion = scan.nextLine();
            aktion = aktion.toLowerCase();

            switch (aktion){
                case "1": bankkonto.printStats();break;
                case "2":
                    System.out.println("Wie viel wollen Sie einzahlen?");
                    betrag = scan.nextDouble();
                    bankkonto.einzahlen(betrag);break;
                case "3":
                    System.out.println("Wie viel wollen Sie abheben?");
                    betrag = scan.nextDouble();
                    bankkonto.abheben(betrag);
            }
        }
    }
}
