package Games.Overtale.Gameplay;

import Games.Overtale.Display.Frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListenerSingleEvent implements ActionListener {

    public Frame frame;
    public int actionCount = 1;

    public ButtonListenerSingleEvent(Frame frame){
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        switch (actionCommand){
            case "start": frame.createGameScreen();break;
            case "rewards": frame.createRewardScreen(); break;
        }

        }
}
