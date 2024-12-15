package Games.TxtAdventure;

import Games.TxtAdventure.Roles.ArcherClass;
import Games.TxtAdventure.Roles.KnightClass;
import Games.TxtAdventure.Roles.MageClass;

import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        int playerHp = 10;
        int playerDamage = 0;

        System.out.println("-------------------------------------------------------------------Prolog---------------------------------------------------------------------------");
        Thread.sleep(2000);
        System.out.print("*** Der Krieg hat das Königreich Eldoria in Flammen gesetzt. ");
        Thread.sleep(2000);
        System.out.println("Banditen durchstreifen die Welt und die Dunkelheit breitet sich über das Land aus. ***");
        Thread.sleep(3500);
        System.out.print("*** Du bist ein Abenteurer, der von einer Prophezeiung auserwählt wurde das Königreich zu retten");
        Thread.sleep(3500);
        System.out.println(" – oder in Chaos zu stürzen. ***");
        Thread.sleep(2000);


        Player player = createClass(playerHp, playerDamage);

        boolean run = true;

        String currentPlace = "wald";

        while (run){
            switch (currentPlace){
                case "wald": currentPlace = wald(player);break;

            }


        }


    }


    public static Player createClass(int playerHp, int playerDamage) throws InterruptedException {

        System.out.println("\nDu stehst vor einem alten Weisen, der dir drei Schriftrollen zeigt.");
        Thread.sleep(2000);
        System.out.println("Jede Schriftrolle beschreibt einen Pfad, den du einschlagen kannst.");
        Thread.sleep(2000);

        System.out.println("------------------------------------------------------------Charaktererstellung---------------------------------------------------------------------");
        System.out.print("Gebe den Namen deines Helden ein: ");
        String name = scan.nextLine();
        System.out.println("Wähle eine Schriftrolle: ");
        Thread.sleep(700);System.out.println("1. Schriftrolle der Ritter (13HP, 3MG)");
        Thread.sleep(700);System.out.println("2. Schriftrolle der Bogenschützen (10HP, 5DMG)");
        Thread.sleep(700);System.out.println("3. Schriftrolle der Magier (8HP, 7DMG)");
        System.out.print(">");
        String chosenClass = scan.nextLine();
        chosenClass = chosenClass.toLowerCase();

        Player[] currentClass = new Player[1];

        switch (chosenClass) {
            case "1", "ritter":
                KnightClass knight = new KnightClass(name, playerHp, playerDamage); currentClass[0] = knight ;break;
            case "2", "bogenschütze":
                ArcherClass archer = new ArcherClass(name, playerHp, playerDamage); currentClass[0] = archer ;break;
            case "3", "magier":
                MageClass mage = new MageClass(name, playerHp, playerDamage); currentClass[0] = mage ;break;
            default: System.out.println("Falsche Eingabe...");break;
        }
        System.out.println("---------------------------------------------------Viel Glück auf deiner Reise, "+name+"---------------------------------------------------------\n");
        return currentClass[0];
    }


    public static String wald(Player player){
        System.out.println("""
                Du betrittst einen düsteren Wald. Die Äste knarren im Wind, und das Unterholz raschelt unheilvoll.
                Plötzlich springt ein Wolf auf dich zu.
                Was tust du?
                
                A) Angreifen        B) Weglaufen
                C) Verteidigen      D) Nichts""");

        String antwort = scan.nextLine();
        antwort = antwort.toUpperCase();

        switch (antwort){
            case "A": break;
        }


        return "dorf";
    }
}
