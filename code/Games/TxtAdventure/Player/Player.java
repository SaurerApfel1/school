package Games.TxtAdventure.Player;

import Games.TxtAdventure.Main;
import Games.TxtAdventure.Monster.Monster;

import java.util.Random;

public abstract class Player {

    public String name;
    public int hp;
    public int damage;
    public double ultCharge;
    public int startHP;
    public static Random random = new Random();

    public Player(String name, int hp, int damage, double ultCharge){
        this.name = name;
        this.hp = hp;
        this.damage = damage;
        this.ultCharge = ultCharge;
        this.startHP = hp;
    }

    abstract public void ultimate();

    public void dealDamage(Monster target, int amount){
        System.out.println("Du greifst \""+target.name+"\" an und verursachst "+amount+" Schaden!");
        target.hp -= amount;
        target.checkIfDead();
        this.ultCharge += this.damage;
    }

    public void heal(){
        if (hp>=startHP-1){
            System.out.println("Der Heilzauber wirkte nicht... (Du darfst höchstens "+(startHP-2)+" HP haben!)");
        }
        else {
            System.out.println("Du benutzt einen Heilungszauber.\nDu heilst 2 HP!");
            this.hp +=2;
        }
    }

    public void doUltimate(Monster target){
        this.roundUltCharge();
        double ultDamage = 0;
        if (this.ultCharge==100){
            ultDamage = 50;
            this.ultimate();
            this.dealDamage(target, (int) ultDamage);
        }
        else {
            for (double i=0; i<=ultCharge;i+=0.5)
                ultDamage += 0.20;
            System.out.println("Du führst eine schwache Ultimative Attacke aus!");
            this.dealDamage(target, (int) ultDamage);
        }
        this.ultCharge = 0;
    }

    public void roundUltCharge(){
        if (this.ultCharge>=100){
            this.ultCharge = 100;
        }
    }

    public void flee(){
        int randInt = random.nextInt();
        if (randInt<=25){
            System.out.println("Du versuchst zu fliehen aber scheiterst...");
        }
        else {
            System.out.println("Du fliehst vor dem Kampf!");
            Main.fighting = false;
        }
    }

    public void checkIfDead(){
        if (this.hp<=0){
            System.out.println("Du bist nicht am Ziel...\nIch warte auf dich bis du es geschafft hast!\nDu bist gestorben...");
            Main.run = false;
        }
    }

}
