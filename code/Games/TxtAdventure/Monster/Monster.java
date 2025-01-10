package Games.TxtAdventure.Monster;

import Games.TxtAdventure.Main;
import Games.TxtAdventure.Player.Player;

public abstract class Monster {

    public String name;
    public int hp;
    public int damage;

    public Monster(String name, int hp, int damage){
        this.name = name;
        this.hp = hp;
        this.damage = damage;
    }

    public void dealDamage(Player player, int amount){
        System.out.println("\""+this.name+"\" hat dich angegriffen und "+this.damage+" Schaden verursacht!");
        player.hp -= amount;
        player.checkIfDead();
        player.ultCharge += this.damage*2;
    }

    public void checkIfDead(){
        if (this.hp<=0){
            System.out.println("\""+this.name+"\" ist gestorben.");
            Main.fighting = false;
        }
    }

}
