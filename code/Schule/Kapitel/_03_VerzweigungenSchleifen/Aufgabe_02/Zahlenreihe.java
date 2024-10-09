package Schule.Kapitel._03_VerzweigungenSchleifen.Aufgabe_02;

import java.util.Scanner;

public class Zahlenreihe {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Geben Sie eine Zahl ein um dessen Zahlenreihe auszugeben:");
        System.out.print(">");
        int zahl = scan.nextInt();


        for (int i = 1; i<=zahl; i++){
            System.out.println("Zahl "+i+": "+zahl*i);
        }
    }
}
