package Privat.Klassen.String;

public class Main {
    public static void main(String[] args) {

        String name = "Jonathon";
        String trim = "          Jonathon          ";

        //boolean result = name.equalsIgnoreCase("jonathon");
        //int result = name.length();
        //char result = name.charAt(0);
        //int result = name.indexOf("o");
        //boolean result = name.isEmpty();
        //String result = name.toUpperCase();
        //String result = name.toLowerCase();
        String trimResult = trim.trim();
        String result = name.replace('o', '!');

        System.out.println(trimResult);
        System.out.println(result);

    }
}
