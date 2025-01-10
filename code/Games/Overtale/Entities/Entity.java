package Games.Overtale.Entities;

import Games.Overtale.Display.Frame;

import javax.swing.*;

public abstract class Entity {

    public int hp;
    public int damage;
    public int stamina;
    public String name;

    public Entity(int hp, int damage, int stamina, String name){
        setDamage(damage);
        this.stamina = stamina;
        setName(name);
        this.hp = hp;
    }

    public boolean checkIfDead(){
        boolean isDead;
        isDead = this.getHp() <= 0;
        if (this.getHp()<0){
            this.setHp(0);
        }
        return isDead;
    }

    public abstract void setHp(int amount);


    public void setDamage(int amount) {
        this.damage = amount;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getHp(){
        return this.hp;
    }

    public int getDamage(){
        return this.damage;
    }

    public int getStamina(){
        return this.stamina;
    }

    public String getName(){
        return this.name;
    }


    public abstract void updateHpBar(JProgressBar hpBar);

    public abstract JProgressBar createHpBar(Frame frame);

}
