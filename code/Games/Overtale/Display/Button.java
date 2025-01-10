package Games.Overtale.Display;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button extends JButton implements ActionListener {

    public static Font buttonFont = new Font("Arial Black", Font.PLAIN, 30);

    public Button(){
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this){
            System.out.println("nice");
        }
    }

    public static Button createButton(String message){
        Button button = new Button();
        message = message.toUpperCase();
        button.setText(message);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.ORANGE);
        button.setFont(buttonFont);
        button.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 4));
        button.setFocusPainted(false);
        return button;
    }
}
