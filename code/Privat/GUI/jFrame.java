package Privat.GUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class jFrame {
    public static void main(String[] args) {

        ImageIcon image = new ImageIcon("C:\\Users\\kamog\\IdeaProjects\\school\\code\\Privat\\GUI\\dark-forest.jpg");

        JFrame frame = new JFrame(); // Fenster wird gemacht
        frame.setTitle("Krasses Fenster");
        frame.setSize(900, 1000);
        frame.setVisible(true);
        frame.setResizable(true);

        Border border = BorderFactory.createLineBorder(Color.BLUE, 5);

        JLabel label = new JLabel();
        label.setText("Blue Forest");
        label.setIcon(image);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setIconTextGap(-200);
        label.setForeground(new Color(0, 0, 255));
        label.setFont(new Font("Arial Bold", Font.PLAIN, 30));
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBorder(border);
        label.setBackground(Color.BLUE);
        label.setOpaque(true);
        frame.add(label);
        frame.pack();
    }
}
