package Games.TxtAdventure.Player;

import java.util.Random;

public class MageClass extends Player {

    public MageClass(String name, int hp, int damage, double ultCharge) {
        super(name, hp-2, damage+7, ultCharge);
        System.out.println("Du bist nun ein Magier.");
    }

    @Override
    public void ultimate() {
        System.out.println("***ULT: DU LÄSST EINEN MAGISCHEN STRAHL LOS!***");
    }
}
