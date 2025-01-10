package Games.Overtale;


import Games.Overtale.Display.Frame;
import Games.Overtale.Entities.Enemy;
import Games.Overtale.Entities.Player;
import Games.Overtale.Gameplay.Buff;
import Games.Overtale.Gameplay.SoundEffect;

import javax.swing.*;


public class Game {

    public Buff buff1, buff2, buff3;
    public int enemiesKilled = 0; //in %
    public boolean fighting = true;
    public Enemy enemy = createRandEnemy();
    public Player player = new Player(100, 10, 100, "Kamo");
    public Frame frame;
    public String
            fightSongPath = "resource\\sounds\\Fight-Banger.wav",
            takeDamageSoundPath = "resource\\sounds\\hitsound.wav",
            parrySoundPath = "resource\\sounds\\Parry Sound.wav",
            stamRegenSoundPath = "resource\\sounds\\staminaRegenSound.wav",
            infoSoundPath = "resource\\sounds\\info.wav";
    public SoundEffect
            takeDamageSound = new SoundEffect(), parrySound = new SoundEffect(),
            stamRegenSound = new SoundEffect(), infoSound = new SoundEffect(),
            fightSong = new SoundEffect();

    public Game() {
        this.frame = new Frame(player, enemy, this);
    }

    public void fightLoop(String choice, Enemy enemy) throws InterruptedException {
        buff1 = Buff.createBuff();
        buff2 = Buff.createBuff();
        buff3 = Buff.createBuff();
        switch (choice) {
            case "attack":
                System.out.println("Crit Chance: "+player.critChance); ;actionAttack();break;
            case "defend": actionDefend();break;
            case "item":break;
            case "stat": actionStat();break;
        }
    }
    public void powerButtons(boolean enabled) {
        frame.action1.setEnabled(enabled); // Attack
        frame.action2.setEnabled(enabled); // Defend
        frame.action3.setEnabled(enabled); // Item
        frame.action4.setEnabled(enabled); // Stat
    }

    public void actionAttack(){
        player.attack(this.enemy, frame.textArea);
        this.powerButtons(false);

        if (this.enemy.checkIfDead()){
            enemiesKilled+=1;
            frame.createEnemyDefeatedScreen(); frame.showBuffCardsDetail(buff1, buff2, buff3);
            this.enemy = loadNewEnemy();
            frame.updateEnemyDetails(this.enemy);
        }
        else {
            Timer timer = new Timer(2500, e -> {
                playSound(takeDamageSoundPath, takeDamageSound);
                player.takeDamage(enemy, frame.textArea);
                this.powerButtons(true);
            });
            timer.setRepeats(false); // Nur einmal ausführen
            timer.start();
        }
    }

    public void actionDefend(){
        this.powerButtons(false);
        playSound(stamRegenSoundPath, stamRegenSound);
        player.defend(enemy, frame.textArea);
        Timer timer = new Timer(2500, e -> {
            if (player.isCountered()){
                playSound(parrySoundPath, parrySound);
                enemy.setHp(enemy.getHp()-enemy.getDamage());
                frame.textArea.setText("Du parierst den Angriff und fügst\n\""+enemy.getName()+"\" "+enemy.getDamage()+" Schaden zu!");
            }
            else {
                playSound(takeDamageSoundPath, takeDamageSound);
                player.setHp(player.getHp()-enemy.getDamage()/2);
                frame.textArea.setText("\""+enemy.getName()+"\" fügt dir "+enemy.getDamage()/2+" Schadenspunkte zu!");
            }
            if (enemy.checkIfDead()){
                enemiesKilled+=1;
                frame.createEnemyDefeatedScreen(); frame.showBuffCardsDetail(buff1, buff2, buff3);
                this.enemy = loadNewEnemy();
                frame.updateEnemyDetails(this.enemy);
            }

            this.powerButtons(true);
        });
        timer.setRepeats(false); // Nur einmal ausführen
        timer.start();
    }

    public void actionStat(){
        playSound(infoSoundPath, infoSound);
        frame.textArea.setText("\nDEIN SCHADEN: *"+player.damage +"*\n\""+enemy.getName()+"\" SCHADEN: *" + enemy.damage +"*");
    }

    public static void playSound(String path, SoundEffect soundEffect){
        soundEffect.setFile(path);
        soundEffect.play();
    }

    public static Enemy createRandEnemy(){
        String[] names = {"Goblin", "Golem", "Skelett", "Zombie", "Vampir", "Wolf", "Geist"};
        int randHp = (int) (Math.random() * 50) + 50;
        int randDamage = (int) (Math.random() * 5) + 5;
        String randName = names[(int) (Math.random() * names.length)];
        switch (randName){
            case "Goblin": randHp-=10;break;
            case "Golem": randHp+=20;
                randDamage -=1;break;
            case "Skelett": randHp-=10; randDamage +=1;break;
            case "Wolf": randDamage-=10; randDamage +=5;break;
        }
        return new Enemy(randHp, randDamage, 100, randName);
    }

    public static void applyBuffs(Buff buff, Player player){
        switch (buff.getBuffType()){
            case "Health": Buff.applyHealthBuff(player, buff);break;
            case "Damage": Buff.applyDamageBuff(player, buff);break;
            case "Crit": Buff.applyCritBuff(player, buff);break;
            case "Stamina": Buff.applyStaminaBuff(player, buff);break;
        }
    }

    public Enemy loadNewEnemy() {
        Enemy crazyEnemy = createRandEnemy(); // Aktualisiert die Referenz des aktuellen Feindes

        // Debug-Ausgabe zur Kontrolle
        crazyEnemy.hpBar = crazyEnemy.createHpBar(frame);

        System.out.println(crazyEnemy.getName());
        System.out.println(crazyEnemy.getDamage());
        System.out.println(crazyEnemy.getHp());

        frame.updateEnemy(crazyEnemy);

        return crazyEnemy;
    }
}
