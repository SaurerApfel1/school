package Schule.Kapitel._05_Methoden;

import java.util.Scanner;

public class Seminar {


    public static int setRange(int min, int max, int points, int count){
        if (points>max){
            System.out.println("Deine Punkte können nicht mehr als 10 sein...");
        }
        else if (points<min){
            System.out.println("Deine Punkte können nicht weniger als 0 sein...");
        }
        else {
            count++;
        }return count;
    }


    public static int getGesamtPunkte(int punkteVortrag, int punkteHausarbeit){
        return punkteVortrag*2 + punkteHausarbeit*3;
    }


    public static void main(String[] args) {

        int punkteHausarbeit = 0;
        int punkteVortrag = 0;

        int min = 0;
        int max = 10;


        Scanner scan = new Scanner(System.in);
        int count = 0;

        while (count<=2){

            if (count==0) {

                System.out.print("Wie viele Punkte hast du in der Hausarbeit erreicht (0-10): ");
                punkteHausarbeit = scan.nextInt();

                count = setRange(min, max, punkteHausarbeit, count);
            }

            else if (count==1){

                System.out.print("Wie viele Punkte hast du in dem Vortrag erreicht    (0-10): ");
                punkteVortrag = scan.nextInt();


                count = setRange(min, max, punkteVortrag, count);
            }

            else if (count==2){

                int gesamtPunkte = getGesamtPunkte(punkteVortrag, punkteHausarbeit);
                if (gesamtPunkte>=40){
                    System.out.println("\nSehr gute Arbeit, du hast "+gesamtPunkte+" von 50 Punkten erreicht!");
                }
                else if (gesamtPunkte>=15){
                    System.out.println("\nDu hast "+gesamtPunkte+" von 50 Punkten erreicht.");
                }
                else {
                    System.out.println("\nSchlechte Arbeit, du hast "+gesamtPunkte+" von 50 Punkten erreicht!");
                }
                count++;
            }
        }
    }
}
