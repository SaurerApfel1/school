package Schule.Kapitel._04_Arrays;

import java.util.Random;

public class ZweiDimensionaleArrays {
    public static void main(String[] args) {

        Random random = new Random();
        int[][] zahlen = new int[2][10];

        for (int i=0; i<10; i++){
            int zufallsZahl = random.nextInt(1, 100+1);

            if (zufallsZahl%2==0) {
                zahlen[0][i] = zufallsZahl;
            }
            else {
                zahlen[1][i] = zufallsZahl;
            }
        }


        System.out.println("Gerade Zahlen        Ungerade Zahlen");
        for (int j=0; j<10; j++){
            System.out.println(zahlen[0][j]+"                    "+zahlen[1][j]);
        }

    }
}
