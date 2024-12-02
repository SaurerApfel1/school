package Privat.Klassen.Autovermietung;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Willkommen im Autohaus!");


        ArrayList<Auto> autos = getAutos();
        ArrayList<Auto> inventar = new ArrayList<>();

        double geld = 55000;

        Scanner scan = new Scanner(System.in);
        boolean run = true;


        while (run){
            System.out.println("""
                 
                    Was darf's sein?
                    **********************************
                    1.Lager anzeigen
                    2.Auto kaufen
                    3.Auto verkaufen
                    4.Auto hinzufügen
                    5.Auto entfernen
                    6.Autohaus verlassen
                    """);

            System.out.print(">");
            byte aktion = scan.nextByte();

            switch (aktion){

                case 1: {
                    lagerAusgeben(autos);
                    break;
                }
                case 2: {
                    autoKaufen(autos, geld, inventar);
                    break;
                }
                case 4: {
                    addAuto(autos);
                    break;
                }
                case 5: {
                    removeAuto(autos);
                    break;
                }

                case 6: {
                    System.out.println("Danke für Ihren Besuch und empfehlen Sie uns weiter!");
                    run = false;
                    break;
                }
            }

        }
    }




    private static ArrayList<Auto> getAutos() {
        ArrayList<Auto> autos = new ArrayList<>();

        AutoStandard autoBMW = new AutoStandard("BMW", "X5", 2018, 30000, "Schwarz");
        AutoStandard autoAudi = new AutoStandard("Audi", "A4", 2017, 40000, "dunkel Blau");
        AutoStandard autoToyota = new AutoStandard("Toyota", "RAV4", 2015, 20000, "Rot");
        AutoSport autoFerrari = new AutoSport("Ferrari", "488", 2020, 60000, 340);
        AutoElektro autoTesla = new AutoElektro("Tesla", "Model S", 2021, 50000, 600);

        autos.add(autoBMW);
        autos.add(autoAudi);
        autos.add(autoToyota);
        autos.add(autoFerrari);
        autos.add(autoTesla);
        return autos;
    }




    public static void printError(){
        System.out.println("Geben Sie eine gültige Antwort ein...");
    }




    public static void lagerAusgeben(ArrayList<Auto> autos){
        System.out.println("Lager");
        System.out.println("*********************************");
        for (Auto auto : autos) {
            System.out.println("-" + auto.autoMarke + " " + auto.autoModell + " gebaut " + auto.autoBaujahr);
        }
    }


    public static void addAuto(ArrayList<Auto> autos){

        Scanner scan = new Scanner(System.in);

        System.out.println("""
                            Was für ein Auto wollen Sie hinzufügen?
                            ***************************************
                            -Standard
                            -Sport
                            -Elektro
                            """);

        String autoArt = scan.nextLine();
        autoArt = autoArt.toLowerCase(Locale.ROOT);

        switch (autoArt) {
            case "standard" : {
                AutoStandard createdAuto = AutoStandard.createAuto();
                autos.add(createdAuto);

                System.out.println("\n-Marke: "+ createdAuto.autoMarke+"\n-Modell: "+createdAuto.autoModell+"\n-Baujahr: "+createdAuto.autoBaujahr+"\n-Farbe: "+createdAuto.autoFarbe+"\nin das Lager hinzugefügt.");
                break;
            }
            case "sport" : {
                AutoSport createdAuto = AutoSport.createAuto();
                autos.add(createdAuto);

                System.out.println("\n-Marke: "+ createdAuto.autoMarke+"\n-Modell: "+createdAuto.autoModell+"\n-Baujahr: "+createdAuto.autoBaujahr+"\n-Geschwindigkeit: "+createdAuto.autoGeschwindigkeit+" km/h"+"\nin das Lager hinzugefügt.");
                break;
            }
            case "elektro" : {
                AutoElektro createdAuto = AutoElektro.createAuto();
                autos.add(createdAuto);

                System.out.println("\n-Marke: "+ createdAuto.autoMarke+"\n-Modell: "+createdAuto.autoModell+"\n-Baujahr: "+createdAuto.autoBaujahr+"\n-Reichweite: "+createdAuto.autoReichweite+" km"+"\nin das Lager hinzugefügt.");
                break;
            }
            default : printError(); break;
        }
    }



    public static void removeAuto(ArrayList<Auto> autos){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welches Auto wollen Sie entfernen?");
        int i = 0;
        for (Auto auto : autos){
            i++;
            System.out.println(i+"."+auto.autoMarke+" "+auto.autoModell);
        }

        int auswahl = scanner.nextInt();
        autos.remove(autos.get(auswahl-1));
        System.out.println("Auto erfolgreich entfernt.");

    }



    public static void autoKaufen(ArrayList<Auto> autos, double geld, ArrayList<Auto> inventar){
        Scanner scan = new Scanner(System.in);
        int i = 0;
        System.out.println("Welches Auto wollen Sie kaufen?");
        for (Auto auto : autos){
            i++;
            System.out.println(i+"."+auto.autoMarke+" "+auto.autoModell+": "+auto.autoPreis+"€");
        }
        System.out.print(">");
        int carIndex = (scan.nextInt());
        carIndex -= 1;

        if (geld<autos.get(carIndex).autoPreis) {
            System.out.println("Zu wenig Geld.\nEs fehlen Ihnen "+(autos.get(carIndex).autoPreis-geld)+"€.");
        }
        else {
            inventar.add(autos.get(carIndex));

            System.out.println(autos.get(carIndex).autoMarke+" "+autos.get(carIndex).autoModell+" erfolgreich gekauft.");
            geld -= autos.get(carIndex).autoPreis;
            System.out.println("Neuer Kontostand: "+geld);
            autos.remove(autos.get(carIndex));
        }
    }
}
