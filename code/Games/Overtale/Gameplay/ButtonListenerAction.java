package Games.Overtale.Gameplay;

import Games.Overtale.Entities.Enemy;
import Games.Overtale.Entities.Player;
import Games.Overtale.Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListenerAction implements ActionListener {

    public Game game;
    public Player player;
    public Enemy enemy;

    public ButtonListenerAction(Game game, Player player, Enemy enemy){
        this.game = game;
        this.player = player;
        this.enemy = enemy;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String choice = e.getActionCommand();
        boolean fighting = true;

        System.out.println("ActionCommand: " + choice);
        try {
            game.fightLoop(choice, enemy);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

    }
}
