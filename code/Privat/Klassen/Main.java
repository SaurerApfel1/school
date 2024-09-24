package Privat.Klassen;

public class Main {
    public static void main(String[] args) {

        System.out.println("<<Übung Klassen>>\n");
        Angestellter a1 = new Angestellter("Johnny", "Polizist", 3600);

        double netto = a1.getNetto(a1.lohn);
        double lohnRaised = a1.raiseLohn(a1.lohn, 100);
        System.out.println("Name: "+a1.name+"\nBeruf: "+a1.beruf+"\nLohn Brutto: "+a1.lohn+"\nLohn Netto: "+netto+"\nLohn erhöht: "+lohnRaised);


        Angestellter a2 = new Angestellter("Peter", "Fachinformatiker", 4000);

    }
}
