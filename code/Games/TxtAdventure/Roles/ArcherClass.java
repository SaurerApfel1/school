package Games.TxtAdventure.Roles;

import Games.TxtAdventure.Player;

import java.util.Random;

public class ArcherClass extends Player {

    public ArcherClass(String name, int hp, int damage) {
        super(name, hp, damage+5);
        System.out.println("Du bist nun ein Bogenschütze.");
    }

    public static void attackWin(String enemyName){
        Random random = new Random();
        int randAttack = random.nextInt(1,3+1);

        if (randAttack==1){
            System.out.println("Du schießt mit deinem Bogen \""+enemyName+"\"ab und vergiftest ihn!");
        }
        else if(randAttack==2){
            System.out.println("Du holst deine Dolche raus und erlegst \""+enemyName+"\" mit Stichen in den Hals.");
        }
        else if(randAttack==3){
            System.out.println("Du hast keine Zeit deine Waffen rauszuholen und erledigst den \""+enemyName+"\" mit einem Genickbruch");
        }
    }

}
