package Schule.Kapitel._03_VerzweigungenSchleifen.Aufgabe_03;

import java.util.Random;
import java.util.Scanner;

public class Zahlenraten {
    public static void main(String[] args) {

        System.out.println("<<Zahlenraten>>");

        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        double geld = 100;
        int highScore = 0;

        boolean run1 = true;

        while (run1){

            int versuche = 0;
            int zahl = rand.nextInt(1, 100+1);
            boolean run2 = true;

            System.out.println("\nWat willste machen?\n-1.Zahlenraten-\n-2.Geld setzen-\n-3.Regeln-\n-4.Highscore-\n-5.Quit-");
            System.out.print(">");
            int choice = scan.nextInt();

            switch (choice){
                case 1:break;
                case 2:
                    System.out.println("Geld: "+geld+"€");
                    System.out.println("Setzen Sie den Betrag fest: ");
                    System.out.print(">");
                    geld = scan.nextInt();
                    System.out.println("Neuer Betrag: "+geld+"€");
                    run2 = false;break;
                case 3:
                    System.out.println("\n*Ziel*: Errate eine zufällige zahl von 1 bis 100\n*Twist*: Jeder versuch kostet dich 10.0€\n*Lose*: Du verlierst bei 0.0€\n");
                    run2 = false;break;
                case 4:
                    System.out.println("\nHighscore: "+highScore);
                    run2 = false;break;
                case 5:run1=false;run2=false;break;
                default:
                    System.out.println("\nFalsche Eingabe...");
                    run2 = false;break;
            }

            while (run2){
                System.out.println("Geld: "+geld+"€");
                if (geld==0){
                    System.out.println("Du bist bankrott...");
                    geld = 0;
                    run2 = false;
                }
                else {
                    System.out.println("Zahl erraten:");
                    System.out.print(">");
                    int guess = scan.nextInt();
                    versuche++;

                    if (guess == zahl){
                        System.out.println("\n**WoW du hast die Zahl erraten und 200.00€ gewonnen!!**\nBenötigte Versuche: "+versuche);
                        geld += 200;

                        if (versuche<highScore){
                            highScore = versuche;
                        }
                        else if(highScore==0){
                            highScore = versuche;
                        }


                        run2 = false;
                    }
                    else {
                        geld -= 10;
                        if (guess<zahl){
                            System.out.println("\nDie gesuchte Zahl ist größer!");
                        }
                        else {
                            System.out.println("\nDie gesuchte Zahl ist kleiner!");
                        }
                    }
                }
            }
        }
    }
}
