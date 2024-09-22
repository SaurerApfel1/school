package Privat;

import javax.swing.*;

public class Gui {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        boolean run = true;

        String name = JOptionPane.showInputDialog("Gib deinen Namen ein");
        while (run) {
            String passwort = JOptionPane.showInputDialog("Gib dein Passwort ein");
            if (passwort.length()>=13 || passwort.length()<5) {
                JOptionPane.showMessageDialog(null, "Das Passwort muss mindestens 5 Charaktere lang sein und darf maximal 13 Charaktere lang sein.");
            }
            else {
                JOptionPane.showMessageDialog(null, "Hallo "+name+". Ihr passwort lautet \""+passwort+"\".");
                run = false;
            }
        }
    }
}
