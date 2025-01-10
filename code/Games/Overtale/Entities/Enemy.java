package Games.Overtale.Entities;

import Games.Overtale.Display.Frame;

import javax.swing.*;
import java.awt.*;

public class Enemy extends Entity{

    public JProgressBar hpBar;
    public int maxHp;

    public Enemy(int hp, int damage, int stamina, String name) {
        super(hp, damage, stamina, name);
        maxHp = this.hp;
    }

    @Override
    public void setHp(int amount) {
        if (this.hp < 0) {
            this.hp = 0; // HP kann nicht negativ sein
        } else {
            this.hp = amount; // Setzt nur gültige Werte
        }
        this.updateHpBar(hpBar);
    }

    @Override
    public void updateHpBar(JProgressBar hpBar) {
        this.hpBar.setMaximum(this.maxHp);
        this.hpBar.setValue(this.hp);
        this.hpBar.setString(this.name+" HP: "+this.hp);
    }

    @Override
    public JProgressBar createHpBar(Frame frame){
        Font barFont = new Font("Arial Black", Font.BOLD, 15);
        JProgressBar hpBar = new JProgressBar(0, this.maxHp);
        hpBar.setFont(barFont);
        hpBar.setStringPainted(true);
        hpBar.setString(this.name+" HP: "+this.hp);
        hpBar.setBackground(Color.RED);
        hpBar.setForeground(new Color(255, 165, 0));
        hpBar.setValue(this.hp);
        frame.add(hpBar);
        return hpBar;
    }
}
