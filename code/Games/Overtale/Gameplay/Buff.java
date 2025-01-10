package Games.Overtale.Gameplay;

import Games.Overtale.Entities.Player;

import javax.swing.*;
import java.util.Random;

public class Buff {

    String buffType; //"Health", "Damage" etc.
    int buffAmount;
    String buffRarity;

    public Buff(String buffType, int buffAmount, String rarity){
        this.buffType = buffType;
        this.buffAmount = buffAmount;
        this.buffRarity = rarity;
    }

    public String getBuffType() {return buffType;}
    public int getBuffAmount() {return buffAmount;}
    public String getRarity() {return buffRarity;}

    public static Buff createBuff(){
        Random random = new Random();
        String[] buffTypes = {"Health", "Damage", "Crit", "Stamina"};
        String buffName = buffTypes[random.nextInt(0, buffTypes.length)];
        int buffAmount = random.nextInt(5, 20);
        String buffRarity;
        if (buffAmount>15){
            buffRarity = "Epic";
        }
        else if(buffAmount>10){
            buffRarity = "Rare";
        }
        else {
            buffRarity = "Common";
        }
        return new Buff(buffName, buffAmount, buffRarity);
    }

    public static void displayBuffs(Buff buff, JTextArea textArea){
        switch (buff.getBuffType()){
            case "Health":
                textArea.setText("\n\n+"+buff.getBuffAmount()+" max Health\n+30% life recovery");break;
            case "Damage":
                textArea.setText("\n\n+"+buff.getBuffAmount()+" Damage\n+10% parry chance");break;
            case "Crit":
                textArea.setText("\n\n+"+buff.getBuffAmount()+" crit Damage\n+3% crit chance");break;
            case "Stamina":
                textArea.setText("\n\n+"+buff.getBuffAmount()+" max Stamina\n+100% stamina recovery");break;
        }
    }

    public static void applyHealthBuff(Player target, Buff buff){
        target.maxHP+= buff.getBuffAmount();
        target.hp+= (target.maxHP/100) * 30;
        target.updateHpBar(target.hpBar);
    }

    public static void applyDamageBuff(Player target, Buff buff){
        target.damage+= buff.getBuffAmount();
        target.counterChance += 10;
    }
    public static void applyCritBuff(Player target, Buff buff){
        target.critDamage += buff.getBuffAmount();
        target.critChance += 3;
    }
    public static void applyStaminaBuff(Player target, Buff buff){
        target.maxStam+= buff.getBuffAmount();
        target.setStamina(target.maxStam);
        target.updStamBar(target.stamBar);
    }
}
