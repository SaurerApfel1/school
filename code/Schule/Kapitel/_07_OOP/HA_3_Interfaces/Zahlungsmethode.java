package Schule.Kapitel._07_OOP.HA_3_Interfaces;

public interface Zahlungsmethode {

    public void bezahlen(double betrag);
    public boolean istGueltig(double betrag); 
    public void besitzerDetails();

}
