package Games.Overtale.Entities;

import Games.Overtale.Display.Frame;
import Games.Overtale.Game;
import Games.Overtale.Gameplay.SoundEffect;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Player extends Entity{

    public JProgressBar hpBar;
    public JProgressBar stamBar = this.createStamBar();
    public int counterChance = 20, critChance = 5, critDamage = this.damage*2;
    public int maxHP = 100, maxStam = 100;
    public SoundEffect damageSound = new SoundEffect(), critSound = new SoundEffect();
    public String damageSoundPath = "resource\\sounds\\damageSound.wav", critSoundPath = "resource\\sounds\\Crit Sound.wav";

    public Player(int hp, int damage, int stamina,  String name) {
        super(hp, damage, stamina, name);
        stamBar.setBounds(100, 100, 250, 45);

        this.updStamBar(stamBar);
    }

    public void attack(Enemy target, JTextArea textArea){
        if (this.getStamina()>=10){
            if (hasCrit()){
                dealDamage(target, this.getDamage() + this.critDamage);
                textArea.setText("Du führst einen kritischen Treffer aus\nund fügst \""+target.getName()+"\" "+this.critDamage+" Schadenspunkte zu!");
            }
            else {
                dealDamage(target, this.damage);
                textArea.setText("Du fügst \""+target.getName()+"\" "+this.damage+" Schadenspunkte zu!\nDu verbrauchst 10 Ausdauerpunkte.");
            }
        }
        else {
            int missingStamina = 10-this.getStamina();
            textArea.setText("Dir fehlen "+missingStamina+" Ausdauerpunkte!");
        }
        target.updateHpBar(target.hpBar);
    }

    public void dealDamage(Enemy target, int amount){
        target.setHp(target.getHp()-amount);
        this.setStamina(getStamina()-10);
    }

    public boolean hasCrit(){
        Random random = new Random();
        boolean crit = random.nextInt(0, 100) <= this.critChance;
        if (crit){
            Game.playSound(this.critSoundPath, critSound);
        }
        else {
            Game.playSound(this.damageSoundPath, this.damageSound);
        }
        return crit;
    }

    public void takeDamage(Entity enemy, JTextArea textArea){
        setHp(this.getHp()-enemy.getDamage());
        textArea.setText("\""+enemy.getName()+"\" fügt dir "+enemy.getDamage()+" Schadenspunkte zu!");
    }

    @Override
    public void setHp(int amount) {
        if (amount < 0) {
            this.hp = 0; // HP kann nicht negativ sein
        } else {
            this.hp = amount; // Setzt nur gültige Werte
        }
        this.updateHpBar(this.hpBar);
    }

    public void setStamina(int amount) {
        this.stamina = amount;
        this.updStamBar(this.stamBar);
    }

    public void defend(Enemy enemy, JTextArea textArea){
        this.setStamina(this.getStamina()+10);
        textArea.setText("Du verteidigst dich und \nregenerierst 10 Ausdauerpunkte!");
    }

    public boolean isCountered(){
        boolean countered;
        Random random = new Random();
        countered = random.nextInt(0, 100) <= this.counterChance;
        return countered;
    }


    @Override
    public void updateHpBar(JProgressBar hpBar) {
        hpBar.setValue(this.hp);
        hpBar.setMaximum(this.maxHP);
        hpBar.setString("PLAYER HP: "+this.hp);
    }


    @Override
    public JProgressBar createHpBar(Frame frame){
        Font barFont = new Font("Arial Black", Font.BOLD, 15);
        JProgressBar hpBar = new JProgressBar(0, this.maxHP);
        hpBar.setFont(barFont);
        hpBar.setStringPainted(true);
        hpBar.setString("PLAYER HP: "+this.hp);
        hpBar.setBackground(Color.RED);
        hpBar.setForeground(Color.GREEN);
        hpBar.setValue(this.maxHP);
        frame.add(hpBar);
        return hpBar;
    }

    public void updStamBar(JProgressBar stamBar){
        if (this.getStamina()>=this.maxStam){
            this.stamina = this.maxStam;
        }
        stamBar.setValue(this.getStamina());
        stamBar.setMaximum(this.maxStam);
        stamBar.setString("STAMINA: "+this.getStamina());
    }

    public JProgressBar createStamBar(){
        Font barFont = new Font("Arial Black", Font.BOLD, 15);
        JProgressBar stamBar = new JProgressBar(0, this.maxStam);
        stamBar.setFont(barFont);
        stamBar.setStringPainted(true);
        stamBar.setString("STAMINA: "+this.getStamina());
        stamBar.setBackground(Color.RED);
        stamBar.setForeground(Color.YELLOW);
        stamBar.setValue(this.maxStam);
        return stamBar;
    }
}
