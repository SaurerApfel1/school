package Privat.Switch;

import java.util.Random;

public class Switch {
    public static void main(String[] args) {
        Random random = new Random();

        int wuerfel = random.nextInt(6);

        switch (wuerfel) {
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            case 3:
                System.out.println("3");
                break;
            case 4:
                System.out.println("4");
                break;
            case 5:
                System.out.println("5");
                break;
        }
    }
}
