package Schule.Kapitel._03_VerzweigungenSchleifen;


import java.util.Scanner;

public class Switch {
    public static void main(String[] args) {


        int punkte = 0;

        Scanner scan1 = new Scanner(System.in);
        System.out.println("<<Quiz Multiple-Choice>>\n\n");
        System.out.print("Welcher Datentyp wird verwendet um Ganzzahlen zu speicher:\nA) double  B) float  \nC) int     D) String\nAntwort: ");
        String a1 = scan1.nextLine();
        a1 = a1.toUpperCase();


        switch (a1){
            case "A", "B", "D":
                System.out.println("\nFalsch...\nPunktestand: "+punkte);
                break;
            case "C":
                punkte +=1;
                System.out.println("\nRichtig!!!\nPunktestand: "+punkte);
        }


        Scanner scan2 = new Scanner(System.in);
        System.out.print("\nWie viele H's hat \"Meerschweinchen\"?:\nA) Was ist ein H's?  B) 1  \nC) 2                 D) 3\nAntwort: ");
        String a2 = scan2.nextLine();
        a2 = a2.toUpperCase();


        switch (a2) {
            case "A", "C", "D":
                System.out.println("\nFalsch...\nPunktestand: " + punkte);
                break;
            case "B":
                punkte += 1;
                System.out.println("\nRichtig!!!\nPunktestand: " + punkte);
        }


        Scanner scan3 = new Scanner(System.in);
        System.out.print("\nWie prüft man eine Bedingung?:\nA) switch()  B) if()  \nC) else      D) case\nAntwort: ");
        String a3 = scan3.nextLine();
        a3 = a3.toUpperCase();


        switch (a3) {
            case "A", "C", "D":
                System.out.println("\nFalsch...\nPunktestand: " + punkte);
                break;
            case "B":
                punkte += 1;
                System.out.println("\nRichtig!!!\nPunktestand: " + punkte);
        }


        System.out.println("Du hast "+punkte+" Fragen von 3 richtig beantwortet.");

    }
}
