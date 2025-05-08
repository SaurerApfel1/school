package Schule.Kapitel._04_Arrays;

import java.util.Random;
import java.util.Scanner;

public class StadtLandFluss {



    public static int checkCapital(String kategorie, String buchstabe, int j){
        if (kategorie.contains(buchstabe)){
            j+=1;
        }
        else{
            System.out.println("***Falscher Buchstabe!***");
        }return j;
    }


    public static int addPoints(String answer, int punkte, String kategorie){
        Scanner scanCheck = new Scanner(System.in);
        System.out.println(kategorie+": "+answer);
        System.out.println("Ist das richtig? (y/n) ");
        String check = scanCheck.nextLine();

        if (check.equals("y")){
            System.out.println("Punkte = +5");
            punkte+=5;
        }
        else if (check.equals("n")) {
            System.out.println("Punkte = +0");
        }
        else {
            System.out.println("***Falsches Zeichen!***");
        }
        return punkte;
    }


    public static void main(String[] args) {


        String stadt = "";
        String land = "";
        String fluss = "";

        String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s"
        , "t", "u", "v", "w", "x", "y", "z"};

        Random rand = new Random();
        Scanner scan = new Scanner(System.in);

        boolean run = true;

        while (run){
            int punkte = 0;
            boolean run1 = true;
            int i = rand.nextInt(0, 25+1);

            String buchstabe = letters[i];
            buchstabe = buchstabe.toUpperCase();

            System.out.println("Anfangsbuchstabe: "+buchstabe);


            int count = 1;
            while (count<=3){
                if (count==1){
                    System.out.print("Stadt: ");
                    stadt = scan.nextLine();
                    count = checkCapital(stadt, buchstabe, count);
                }
                if (count==2){
                    System.out.print("Land: ");
                    land = scan.nextLine();
                    count = checkCapital(land, buchstabe, count);
                }
                if (count==3){
                    System.out.print("Fluss: ");
                    fluss = scan.nextLine();
                    count = checkCapital(fluss, buchstabe, count);
                }
            }

            System.out.println();

            while (run1){
                punkte = addPoints(stadt, punkte, "Stadt");
                punkte = addPoints(land, punkte, "Land");
                punkte = addPoints(fluss, punkte, "Fluss");

                System.out.println("Gesamtpunkte: "+punkte);

                System.out.println("Willst du nochmal spielen? (y/n) ");
                String again = scan.nextLine();
                if (again.equals("y")){
                    run1=false;
                }
                else {
                    run=false;
                }
            }
        }
    }
}
