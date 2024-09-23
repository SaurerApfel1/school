package Privat.Klassen;

import java.util.Scanner;

public class Methoden {
    public static void main(String[] args) {

        boolean run = true;
        System.out.println("<<Willkommen zu unseren Anmeldeprogramm>>");
        String[] logInfo = signUp();

        while (run) {



            Scanner scan = new Scanner(System.in);
            int choice = runProgramm();


            if (choice==1) {
                boolean check = login(logInfo[1]);
                if (check) {
                    System.out.println("Erfolgreich angemeldet.");
                }
                else {
                    System.out.println("Falsches Passwort...");
                }
            }
            else if (choice==2) {
                logInfo[1] = changePasswort();
                System.out.println("Passwort erfolgreich geändert");
            }
            else if (choice==3) {
                System.out.println("Name: "+logInfo[0]+"\nPasswort: "+logInfo[1]);
            }
            else if (choice==4) {
                run = endProgramm();
            }
            else {
                System.out.println("Gib eine gültige Zahl ein...");
            }
        }
    }




    public static String[] signUp(){

        Scanner scan = new Scanner(System.in);

        System.out.println("Geben Sie Ihren Benutzernamen ein: ");
        String name = scan.nextLine();
        System.out.println("Eingabe zum fortfahren...");
        scan.nextLine();
        System.out.println("Geben Sie Ihr Passwort ein: ");
        String passwort = scan.nextLine();

        String[] logInfo = new String[2];
        logInfo[0] = name;
        logInfo[1] = passwort;

        return logInfo;
    }


    public static String changePasswort() {

        Scanner scan = new Scanner(System.in);

        System.out.print("neues Passwort: ");
        return scan.nextLine();
    }


    public static int runProgramm() {

        Scanner scan = new Scanner(System.in);

        System.out.println("\n<<Unsere Programme>>\n");
        System.out.println("1.Login \n2.Passwort ändern \n3.Daten anzeigen \n4.Programm beenden\n");
        System.out.println("Zahl eingeben:");
        System.out.print(">");
        return scan.nextInt();

    }


    public static boolean endProgramm() {

        System.out.println("Programm wird beendet...");
        return false;

    }


    public static boolean login(String passwort) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Geben Sie Ihr passwort ein: ");
        String p = scan.nextLine();

        return p.equals(passwort);
    }
}
