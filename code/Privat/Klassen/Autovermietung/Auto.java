package Privat.Klassen.Autovermietung;

public abstract class Auto {

    String autoMarke;
    String autoModell;
    int autoBaujahr;
    double autoPreis;

    public Auto(String autoMarke, String autoModell, int autoBaujahr, double autoPreis) {
        this.autoMarke = autoMarke;
        this.autoModell = autoModell;
        this.autoBaujahr = autoBaujahr;
        this.autoPreis = autoPreis;
    }
}
