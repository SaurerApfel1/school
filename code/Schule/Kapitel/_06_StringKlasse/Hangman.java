package Schule.Kapitel._06_StringKlasse;

import java.util.Random;
import java.util.Scanner;

public class Hangman {

    static int versuche;

    public static void main(String[] args) {

        Random random = new Random();

        String[] wordPool = {"Skibidi", "Ratio", "Those who know", "German Stare", "Balkan rage", "Still water", "Mango Mango", "Jonkler", "fein", "Steel Ball Run", "Vinland", "Aizen", "Bleach", "One Piece"};
        int randInt = random.nextInt(0, wordPool.length);

        Scanner scan = new Scanner(System.in);
        String word = wordPool[randInt];
        word = word.toUpperCase();
        String hiddenWord = "*".repeat(word.length());

        char[] wordArray = word.toCharArray();
        char[] hiddenWordArray = hiddenWord.toCharArray();
        boolean guessed = false;

        System.out.println("--Hangman Game--");
        System.out.print("Geben Sie einen Buchstaben ein:");

        while (!guessed){
            System.out.print("\n>");
            char guess = Character.toUpperCase(scan.next().charAt(0));
            versuche += 1;
            guessed = solveGuess(wordArray, hiddenWordArray, guess);
            printArray(hiddenWordArray);
        }
        if (versuche<=7){
            System.out.println("\nWOW, du hast es in "+versuche+" Versuchen geschafft.");
        }
        else if (versuche<=9){
            System.out.println("\nStark, du hast es in "+versuche+" Versuchen geschafft.");
        }
        else{
            System.out.println("\nBOO, du hast es in "+versuche+" Versuchen geschafft.");
        }

    }

    public static void printArray(char[] array){
        System.out.print("Wort: ");
        for (char c : array) {
            System.out.print(c);
        }
    }

    public static boolean solveGuess(char[] wordArray, char[] hiddenWordArray, char guess){
        boolean guessed = true;
        for (int i=0; i<wordArray.length; i++){
            if (wordArray[i]==guess){
                hiddenWordArray[i] = guess;
            }
            if (wordArray[i]==' '){
                hiddenWordArray[i] = '_';
            }
            if (hiddenWordArray[i]=='*'){
                guessed = false;
            }
        }
        return guessed;
    }
}

