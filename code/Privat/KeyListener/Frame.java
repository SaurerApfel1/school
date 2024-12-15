package Privat.KeyListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class Frame extends JFrame implements KeyListener{

    JLabel label;
    ImageIcon icon;

    Frame(){
        this.setSize(2000, 1000);
        this.addKeyListener(this);
        this.setLayout(null);
        this.setVisible(true);

        icon = new ImageIcon("C:\\Users\\kamog\\OneDrive - gymhueck\\Bilder\\IMG_0987.jpg");

        label = new JLabel();
        label.setBounds(0, 0, 1700, 2200);
        label.setIcon(icon);
        //label.setBackground(Color.black);
        //label.setOpaque(true);

        this.add(label);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case 37: label.setLocation(label.getX()-10, label.getY());break;
            case 38: label.setLocation(label.getX(), label.getY()-10);break;
            case 40: label.setLocation(label.getX(), label.getY()+10);break;
            case 39: label.setLocation(label.getX()+10, label.getY());break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("released Key char: "+e.getKeyChar());
        System.out.println("released Key code: "+e.getKeyCode());
        System.out.println();
    }
}
