package Schule.Kapitel._05_Methoden;

import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) {
        int words = calcWordAmount(getSatz());
        System.out.println("Ihr Satz ist "+words+" Wörter lang.");
    }


    public static int calcWordAmount(String satz) {
        char[] letters = satz.toCharArray();
        int words = 0;
        for (int i=0; i<satz.length(); i++) {
            if (satz.charAt(i) == ' ' || satz.charAt(i) == '?' || satz.charAt(i) == '!' || satz.charAt(i) == '.'){
                words+=1;
            }
        }
        return words;
    }

    public static String getSatz() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Gebe einen Satz ein der mit \".\", \"!\" oder \"?\" endet ein: ");
        return scan.nextLine();
    }
}
