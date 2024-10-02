package Schule.Kapitel._03_VerzweigungenSchleifen;

import java.util.Arrays;
import java.util.Scanner;

public class Maximum {
    public static void main(String[] args) {

        int[] zahlen = inputNumbers();

        int max = calcMax(zahlen);
        System.out.println("Die größte Zahl ist "+max);

    }
    public static int[] inputNumbers() {

        Scanner scan = new Scanner(System.in);
        System.out.print("Geben Sie die 1. Zahl ein: ");
        int zahl1 = scan.nextInt();
        System.out.print("Geben Sie die 2. Zahl ein: ");
        int zahl2 = scan.nextInt();
        System.out.print("Geben Sie die 3. Zahl ein: ");
        int zahl3 = scan.nextInt();

        return new int[]{zahl1, zahl2, zahl3};
    }
    public static int calcMax(int[] zahlen){

        Arrays.sort(zahlen);

        int zahlenLength = zahlen.length;
        int i = 0;

        while (i<(zahlenLength-1)){
            i++;
        }

        return zahlen[i];


    }
}
