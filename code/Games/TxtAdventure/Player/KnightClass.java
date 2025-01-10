package Games.TxtAdventure.Player;

import java.util.Random;

public class KnightClass extends Player {

    public KnightClass(String name, int hp, int damage, double ultCharge) {
        super(name, hp+2, damage+3, ultCharge);
        System.out.println("Du bist nun ein Ritter.");
    }

    @Override
    public void ultimate() {
        System.out.println("***ULT: DU FÜHRST EINEN RIESENHIEB AUS!***");
    }
}
