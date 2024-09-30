package Schule.Kapitel._02_DatentypenVariablen;

import java.util.Scanner;

public class Taschenrechner {
    public static void main(String[] args) {


        System.out.println("<<Taschenrechner>> \n");
        System.out.println("Folgende Programme stehen zur auswahl: \n 1.Addition \n 2.Subtraktion \n 3.Multiplikation \n 4.Division \n 5.Weiter");
        Scanner scan = new Scanner(System.in);
        System.out.print("Gib eine Zahl zur passenden Ausführung ein:");
        int program = scan.nextInt();


        if (program == 1) {
            System.out.print("Zahl 1:");
            int a = scan.nextInt();
            System.out.print("Zahl 2:");
            int b = scan.nextInt();
            System.out.println("Ergebnis: "+a+"+"+b+"="+(a+b));
        }
        else if (program == 2) {
            System.out.print("Zahl 1:");
            int a = scan.nextInt();
            System.out.print("Zahl 2:");
            int b = scan.nextInt();
            System.out.println("Ergebnis: "+a+"-"+b+"="+(a-b));
        }
        else if (program == 3) {
            System.out.print("Zahl 1:");
            int a = scan.nextInt();
            System.out.print("Zahl 2:");
            int b = scan.nextInt();
            System.out.println("Ergebnis: "+a+"*"+b+"="+(a*b));
        }
        else if (program == 4) {
            System.out.print("Zahl 1:");
            int a = scan.nextInt();
            System.out.print("Zahl 2:");
            int b = scan.nextInt();
            System.out.println("Ergebnis: "+a+"/"+b+"="+(a/b));
        }
        else if (program == 5) {
            System.out.println("weiter...");
        }
        else {
            System.out.println("Gib eine gültige Eingabe ein...");
        }


        System.out.println("<<Durchschnittsverbrauch>> \n");
        System.out.print("Geben Sie die gefahrenen Kilometer ein z.B. 200,5 oder 50:");
        float km = scan.nextFloat();
        while (km<=0) {
            System.out.println("Die Kilometer müssen mehr als 0 sein...");
            System.out.print(">");
            km = scan.nextInt();
        }


        System.out.print("Geben Sie die verbrauchten Liter ein:");
        float l = scan.nextFloat();
        while (l<=0) {
            System.out.println("Der Verbrauch muss mehr als 0 sein...");
            System.out.print(">");
            l = scan.nextInt();
        }
        float durchschnittV = l/km * 100;
        System.out.println("Du verbrauchst auf 100km "+durchschnittV+"L.");
    }
}
