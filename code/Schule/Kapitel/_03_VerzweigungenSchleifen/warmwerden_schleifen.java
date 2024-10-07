package Schule.Kapitel._03_VerzweigungenSchleifen;

import java.util.Random;
import java.util.Scanner;

public class warmwerden_schleifen {

    public static void main(String[] args) {
        boolean run = true;

        Scanner scan = new Scanner(System.in);

        while (run){

            System.out.println("1. Zähler\n2. Zufällige Zahlen\n\"q\" um das programm zu beenden");
            System.out.print("Geben Sie ein Befehl ein: ");
            String i = scan.nextLine();

            switch (i){
                case "1" :
                    System.out.print("Geben Sie den Start ein: ");
                    int z1 = scan.nextInt();
                    System.out.println("Geben Sie den Endpunkt ein: ");
                    int z2 = scan.nextInt();

                    while (z1<=z2){
                        System.out.println(z1);
                        z1++;
                    }
                    break;
                case "2" :
                    Random rand = new Random();
                    System.out.println("Wie viele Zahlen: ");
                    int zahl = scan.nextInt();

                    int j = 0;

                    while (j<zahl){
                        System.out.println(rand.nextInt(1, 10));

                        j++;
                    }
                    break;


                case "q" :
                    System.out.println("Programm wird beendet...");
                    run = false;
                    break;
            }
        }
    }

}
