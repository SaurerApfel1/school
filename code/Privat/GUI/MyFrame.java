package Privat.GUI;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    MyFrame() {

        JFrame frame = new JFrame(); // Fenster wird gemacht
        frame.setTitle("Krasses Fenster");
        frame.setSize(420, 420);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(200,200,255));

    }
}
