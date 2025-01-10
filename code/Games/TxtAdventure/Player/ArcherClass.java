package Games.TxtAdventure.Player;

import java.util.Random;

public class ArcherClass extends Player {

    public ArcherClass(String name, int hp, int damage, double ultCharge) {
        super(name, hp, damage+5, ultCharge);
        System.out.println("Du bist nun ein Bogenschütze.");
    }

    @Override
    public void ultimate() {
        System.out.println("***ULT: DU SCHIEßT EINEN STARKEN MAGISCHEN PFEIL!***");
    }
}
