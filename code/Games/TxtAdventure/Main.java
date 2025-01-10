package Games.TxtAdventure;

import Games.TxtAdventure.Monster.Monster;
import Games.TxtAdventure.Monster.Wolf;
import Games.TxtAdventure.Player.ArcherClass;
import Games.TxtAdventure.Player.KnightClass;
import Games.TxtAdventure.Player.MageClass;
import Games.TxtAdventure.Player.Player;

import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);
    public static boolean run;
    public static boolean fighting;

    public static void main(String[] args) throws InterruptedException {
        int playerHp = 10;
        int playerDamage = 0;

      /* System.out.println("-------------------------------------------------------------------Prolog---------------------------------------------------------------------------");
        Thread.sleep(2000);
        System.out.print("*** Der Krieg hat das Königreich Eldoria in Flammen gesetzt. ");
        Thread.sleep(2000);
        System.out.println("Banditen durchstreifen die Welt und die Dunkelheit breitet sich über das Land aus. ***");
        Thread.sleep(3500);
        System.out.print("*** Du bist ein Abenteurer, der von einer Prophezeiung auserwählt wurde das Königreich zu retten");
        Thread.sleep(3500);
        System.out.println(" – oder in Chaos zu stürzen. ***");
        Thread.sleep(2000);
*/

        Player player = createClass(playerHp, playerDamage);

        String currentPlace = "wald";
        run = true;
        while (run) {
            switch (currentPlace) {
                case "wald":
                    Wolf wolf = new Wolf("Wolf", 100, 1);
                    currentPlace = wald(player, wolf);
                    break;
                case "dorf":
                    currentPlace = dorf(player);
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
        Thread.sleep(700);
        System.out.println("1. Schriftrolle der Ritter (13HP, 3DMG)");
        Thread.sleep(700);
        System.out.println("2. Schriftrolle der Bogenschützen (10HP, 5DMG)");
        Thread.sleep(700);
        System.out.println("3. Schriftrolle der Magier (8HP, 7DMG)");
        System.out.print(">");
        String chosenClass = scan.nextLine();
        chosenClass = chosenClass.toLowerCase();

        Player[] currentClass = new Player[1];

        switch (chosenClass) {
            case "1",
                 "ritter":
                KnightClass knight = new KnightClass(name, playerHp, playerDamage, 0);
                currentClass[0] = knight;
                break;
            case "2",
                 "bogenschütze":
                ArcherClass archer = new ArcherClass(name, playerHp, playerDamage, 0);
                currentClass[0] = archer;
                break;
            case "3",
                 "magier":
                MageClass mage = new MageClass(name, playerHp, playerDamage, 0);
                currentClass[0] = mage;
                break;
            default:
                System.out.println("Falsche Eingabe...");
                break;
        }
        System.out.println("---------------------------------------------------Viel Glück auf deiner Reise, " + name + "---------------------------------------------------------\n");
        Thread.sleep(1000);
        return currentClass[0];
    }

    public static void fightSequence(Player player, Monster monster, boolean run) {
        fighting = true;
        System.out.println("Du kämpfst gegen \"" + monster.name + "\":");
        while (fighting) {
            player.roundUltCharge();
            System.out.println("--------------------------------------------------------------");
            System.out.println("Deine HP: " + player.hp + "  "+monster.name +" HP: " + monster.hp + "   Ult: " + player.ultCharge + "%");
            System.out.println("""
                    Was tust du?
                    
                    A) angreifen        B) heilen (+2)
                    C) ULTIMATE         D) fliehen""");

            String antwort = scan.nextLine();
            antwort = antwort.toUpperCase();
            switch (antwort) {
                case "A":
                    player.dealDamage(monster, player.damage);
                    monster.dealDamage(player, monster.damage);
                    break;
                case "B":
                    player.heal();
                    monster.dealDamage(player, monster.damage);
                    break;
                case "C":
                    player.doUltimate(monster);
                    monster.dealDamage(player, monster.damage);
                    break;
                case "D":
                    player.flee();
                    monster.dealDamage(player, monster.damage);
                    break;
                default:
                    System.out.println("Falsche Eingabe...");
                    break;
            }
        }
    }

    public static void gastHof() {
        System.out.println("""
                Du betrittst den örtlichen Gasthof.
                Eine betrunkene Frau steht hinter der Theke und versucht, ihre Gäste zu beruhigen.
                
                Spieler: „Wirtin, ich suche nach Informationen über die Drachenplage. Was weißt du darüber?“
                Wirtin: „Drachen, hah! Diese Mistviecher machen uns das Leben schwer!
                        Seit Wochen trau ich mich nicht, Vorräte zu holen – die Biester lauern überall!“
                Spieler: „Weißt du, wo sie herkommen?“
                Wirtin: (nippt an einem Krug) „Jemand hat gesagt, sie kommen aus den Nebelbergen im Westen.
                        Ein alter Drachenhort soll dort sein. Aber geh bloß nicht dahin – du bist schneller gegrillt,
                        als du 'Drachenbraten' sagen kannst.“
                """);
    }

    public static String wald(Player player, Monster monster) {
        Scanner scan = new Scanner(System.in);
        System.out.println("-----------------------------------Kapitel 1-----------------------------------");
        System.out.println("""
                Du betrittst einen düsteren Wald. Die Äste knarren im Wind, und das Unterholz raschelt unheilvoll.
                Du siehst einen Wolf in der Ferne.
                Was tust du?
                
                A) In den Kampf!        B) Weglaufen""");

        String antwort = scan.nextLine();
        antwort = antwort.toUpperCase();

        switch (antwort) {
            case "A":
                fightSequence(player, monster, run);
                break;
            case "B":
                player.flee();
                break;
            default:
                System.out.println("Falsche Eingabe");break;
        }
        return "dorf";
    }

    public static String dorf(Player player) {
        Scanner scan = new Scanner(System.in);
        String nextPlace = "";
        System.out.println("-----------------------------------Kapitel 2-----------------------------------");
        System.out.println("""
                Auf deinem Weg kommst du im Dorf an und siehst verbrannte Häuser sowie verstörte Dorfbewohner.
                Eine alte Frau fleht dich an, ihr bei der Suche nach ihrem Sohn zu helfen,
                der in den Ruinen verschwunden ist.
                Was tust du?
                
                A) der Frau helfen       B) nach dem Schmied suchen
                C) In den Gasthof gehen""");
        String antwort = scan.nextLine();
        antwort = antwort.toUpperCase();

        switch (antwort) {
            case "A":
                break;
            case "B":
            case "C": gastHof();break;

        }
        return nextPlace;
    }
}