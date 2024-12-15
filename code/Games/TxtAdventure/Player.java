package Games.TxtAdventure;

public abstract class Player {

    String name;
    int hp;
    int damage;

    public Player(String name, int hp, int damage){
        this.name = name;
        this.hp = hp;
        this.damage = damage;
    }

}
