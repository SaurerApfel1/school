package Schule.Kapitel._02_DatentypenVariablen;

import java.util.Scanner;

public class Steigung {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("<<Steigungsberechnung>>");

        System.out.println("Geben Sie die Koordinaten des ersten Punktes an (x1, y1): ");
        System.out.print("x1:");
        int x1 = scan.nextInt();
        System.out.print("y1:");
        int y1 = scan.nextInt();


        System.out.println("Geben Sie die Koordinaten des zweiten Punktes an (x2, y2): ");
        System.out.print("x2:");
        int x2 = scan.nextInt();
        System.out.print("y2:");
        int y2 = scan.nextInt();


        int steigung = (y2-y1)/(x2-x1);

        System.out.println("Die Steigung der Grade beträgt "+steigung+".");
        }
    }
