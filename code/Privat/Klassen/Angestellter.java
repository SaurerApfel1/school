package Privat.Klassen;

public class Angestellter {

    String name;
    String beruf;
    double lohn; // im Monat

    public Angestellter(String name, String beruf, double lohn) {

        this.name = name;
        this.beruf = beruf;
        this.lohn = lohn;
    }
    public double getNetto(double lohn) {
        double mehrwertsteuerbetrag = (lohn/100)*19;
        return lohn - mehrwertsteuerbetrag;
    }

    public double raiseLohn(double Lohn, int percent) {
        return lohn + ((lohn/100)*percent);
    }

}
