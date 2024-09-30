package Privat.GUI.main;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.black);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(400, 300, 200, 100);
        buttonPanel.setBackground(Color.blue);
        buttonPanel.setVisible(true);
        frame.add(buttonPanel);
    }
}
