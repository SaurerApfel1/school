package Schule.Kapitel._07_OOP._01_ErsteKlassen;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Bank_Main {

    public static String[] actions = {"Account erstellen", "Account wechseln", "Einzahlen", "Auszahlen", "Verlassen"};
    public static Scanner scanner = new Scanner(System.in);
    public static User user = new User("Skibidi Khoi", 50000, new ArrayList<>());
    public static int currentAccountIndex = 0, nextAccountIndex;

    public static void main(String[] args) {
        boolean isRunning = true;
        while (isRunning){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Willkommen bei der Bank, "+user.getName()+"! Was wollen Sie machen?\n");
            printActions();
            String action = scanner.nextLine();
            action = fixInput(action);
            switch (action){
                case "1": createAccount();break;
                case "2": switchAccounts();break;
                case "3": deposit();break;
                case "4": withdraw();break;
                case "5": isRunning = false;break;
                default:
                    System.out.println("❌ Falsche Eingabe!");
            }
        }
    }

    public static void createAccount(){
        user.getAccountsList().add(new Account(createAccountNumber(), 0, user));
        System.out.println("✅ Account erstellt!");
        printAccountDetails(nextAccountIndex);
        nextAccountIndex += 1;
    }

    public static void switchAccounts(){
        if (user.hasAccounts()){
            System.out.println("Zu welchen Account wollen Sie wechseln?");
            user.listAccounts();
            int switchAccountIndex = scanner.nextInt() - 1;
            if (switchAccountIndex >= user.getAccountsList().size()){
                System.out.println("❌ Diesen Account gibt es nicht!");
            }
            else{
                currentAccountIndex = switchAccountIndex;
                System.out.println("✅ Account gewechselt!");
                printAccountDetails(currentAccountIndex);
            }
        }
        else {
            System.out.println("❌ Sie haben keine Accounts!");
        }
    }

    public static void deposit(){
        if (user.hasAccounts()){
            System.out.println("Dein Geld: "+user.getMoney()+"€\nKontostand: "+user.getAccount(currentAccountIndex).getAccountBalance()+"€");
            System.out.println("Wie viel Geld wollen Sie einzahlen?");
            int depositAmount = scanner.nextInt();
            user.getAccount(currentAccountIndex).deposit(depositAmount);
        }
        else {
            System.out.println("❌ Sie haben keine Accounts!");
        }
    }

    public static void withdraw(){
        if (user.hasAccounts()){
            System.out.println("Dein Geld: "+user.getMoney()+"€\nKontostand: "+user.getAccount(currentAccountIndex).getAccountBalance()+"€");
            System.out.println("Wie viel Geld wollen Sie abheben?");
            int withdrawAmount = scanner.nextInt();
            user.getAccount(currentAccountIndex).withdraw(withdrawAmount);
        }
        else {
            System.out.println("❌ Sie haben keine Accounts!");
        }
    }

    public static void printActions(){
        int i=1;
        for (String s : actions){
            System.out.println(i+"."+s);
            i++;
        }
        System.out.print(">");
    }

    public static void printAccountDetails(int index){
        System.out.println("Kontobesitzer: "+user.getAccount(index).getAccountUser().getName());
        System.out.println("Kontostand: "+user.getAccount(index).getAccountBalance()+"€");
        System.out.println("Kontonummer: "+user.getAccount(index).getAccountNumber()+"\n");
    }

    public static String fixInput(String input){
        if (input.isEmpty()){
            System.out.println("❌ Eingabe darf nicht leer sein!");
        }
        input = input.trim();
        input = input.toLowerCase();
        return input;
    }

    public static String createAccountNumber(){
        Random random = new Random();
        String accountNumber = "";
        for (int i=0;i<10;i++){
            accountNumber+=random.nextInt(0,9);
        }
        return accountNumber;
    }
}
//System.out.println("Account: "+user.getAccount(currentAccountIndex).getAccountNumber()+" ("+user.getAccount(currentAccountIndex).getAccountBalance()+"€)");
