package Schule.Kapitel._05_Methoden;

import java.util.Scanner;

public class Tarif {
    static Scanner scan = new Scanner(System.in);


    public static double tarif1(double time, String tarifChoice){
        double grundKosten = 11.75;
        double kostenProMin = 0.50;

        System.out.println("Danke, dass Sie sich für Vodafone entschieden haben.");

        listCosts(kostenProMin, grundKosten, tarifChoice);

        return time * kostenProMin + grundKosten;
    }

    public static double tarif2(double time, String tarifChoice){
        double grundKosten = 19.25;
        double kostenProMin = 0.25;

        System.out.println("Danke, dass Sie sich für Telekom entschieden haben.");

        listCosts(kostenProMin, grundKosten, tarifChoice);

        return time * kostenProMin + grundKosten;
    }

    public static double tarif3(double time, String tarifChoice){
        double grundKosten;
        double kostenProMin;
        double gesKosten;

        if (time>=30){
            grundKosten = 22.75;
            kostenProMin = 0.375;
            gesKosten = grundKosten + (kostenProMin*time - kostenProMin*30);
        } else {
            grundKosten = 22.75;
            kostenProMin = 0.0;
            gesKosten = grundKosten + kostenProMin*time;
        }

        System.out.println("Danke, dass Sie sich für 1&1 entschieden haben.");

        listCosts(kostenProMin, grundKosten, tarifChoice);

        return gesKosten;
    }

    public static void listCosts(double kostenProMin, double grundKosten, String tarifChoice){

        if (tarifChoice.equals("1")||tarifChoice.equals("1&1")){
            double time = 0;

            for (int i=10; i<=100; i+=10){
                if (i<=30){
                    System.out.println(i+" Minuten:   "+ (grundKosten+kostenProMin*0));
                } else {
                    time+=10;
                    System.out.println(i+" Minuten:   "+ (grundKosten+kostenProMin*time));
                }
            }
        }
        else {
            for (int i=10; i<=100; i+=10){
                System.out.println(i+" Minuten:   "+ (grundKosten+kostenProMin*i));
            }
        }
    }



    public static void main(String[] args) {

        System.out.println("Wir haben 3 Tarife zur Auswahl: \n--Vodafone (Guter Deal!)--\n--Telekom (Toll für Gespräche!)--\n--1&1 (Absoluter Bestseller!)--\n");
        System.out.print("Welcher Tarif spricht Ihnen zu? (V/Vodafone, T/Telekom, 1/1&1): ");

        String tarifChoice = scan.nextLine();

        tarifChoice = tarifChoice.toUpperCase();

        switch (tarifChoice) {
            case "V", "VODAFONE" : {
                double tarif1Kosten = tarif1(50, tarifChoice);break;
            }
            case "T", "TELEKOM" : {
                double tarif2Kosten = tarif2(50, tarifChoice);break;
            }
            case "1", "1&1" : {
                double tarif3Kosten = tarif3(50, tarifChoice);break;
            }
            default : System.out.println("Sind Sie blöd? Den Tarif \"" + tarifChoice + "\" gibt es nicht.");break;
        }
    }
}
