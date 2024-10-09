package Schule.Kapitel._03_VerzweigungenSchleifen.Aufgabe_01;

import java.util.Scanner;

public class Monate {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        boolean run = true;
        boolean check = false;

        while (run) {
            System.out.println("Was wollen Sie tun?\n\n1.Beliebigen Monat\n2.Programm beenden");
            System.out.print(">");
            int i = scan.nextInt();

            switch (i){
                case 1 :
                    System.out.println("Monate eingeben in Zahlenform: ");
                    System.out.print(">");
                    int input = scan.nextInt();
                    while (input<=0 || input>12){

                        System.out.println(" ");

                        System.out.println("Geben Sie eine Zahl von 1-12 ein.");
                        System.out.println("Monate eingeben in Zahlenform: ");
                        System.out.print(">");
                        input = scan.nextInt();
                    }
                    calcMonat(input);break;
                case 2 : run = false;break;
            }
        }
    }

    public static void calcMonat(int input){

        switch (input){

            case 1:
                System.out.println("Monat: Januar\nTage: 31");break;
            case 2:
                System.out.println("Monat: Februar\nTage: 28");break;
            case 3:
                System.out.println("Monat: März\nTage: 31");break;
            case 4:
                System.out.println("Monat: April\nTage: 30");break;
            case 5:
                System.out.println("Monat: Mai\nTage: 31");break;
            case 6:
                System.out.println("Monat: Juni\nTage: 30");break;
            case 7:
                System.out.println("Monat: Juli\nTage: 31");break;
            case 8:
                System.out.println("Monat: August\nTage: 31");break;
            case 9:
                System.out.println("Monat: September\nTage: 30");break;
            case 10:
                System.out.println("Monat: Oktober\nTage: 31");break;
            case 11:
                System.out.println("Monat: November\nTage: 30");break;
            case 12:
                System.out.println("Monat: Dezember\nTage: 31");break;
        }
    }
}
