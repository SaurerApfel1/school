package Privat.Switch;

import java.util.Random;
import java.util.Scanner;

public class Switch {
    public static void main(String[] args) {
        Random random = new Random();

        int wuerfel = random.nextInt(7);

        System.out.println("Sie sind der Lehrer und würfeln eine Note...");

        switch (wuerfel) {
            case 1:
                System.out.println("Note: 1");break;
            case 2:
                System.out.println("Note: 2");break;
            case 3:
                System.out.println("Note: 3");break;
            case 4:
                System.out.println("Note: 4");break;
            case 5:
                System.out.println("Note: 5");break;
            case 6:
                System.out.println("Note: 6");break;


        }
        boolean guessed = false;

        while (!guessed) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Schüler erratet seine Note: ");
            int guess = scan.nextInt();
            if (guess==wuerfel) {
                System.out.println("Erraten!!!");
                guessed = true;
            }
            else {
                System.out.println("Falsch");
            }

        }
    }
}
