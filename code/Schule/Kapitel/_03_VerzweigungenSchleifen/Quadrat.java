package Schule.Kapitel._03_VerzweigungenSchleifen;

import java.util.Scanner;

public class Quadrat {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Geben Sie ein Zeichen ein: ");
        String zeichen = scan.next();

        System.out.print("Geben Sie die Reihen an: ");
        int reihe = scan.nextInt();

        System.out.print("Geben Sie die Spalten an: ");
        int spalte = scan.nextInt();

        for (int i = 0; i < reihe;) {
            i++;
            System.out.println();
            for (int j =0; j < spalte;) {
                j++;
                System.out.print(zeichen);
            }
        }

    }
}
