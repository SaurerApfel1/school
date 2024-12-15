package Games.OwnGame.inputs;

import Games.OwnGame.main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class inputKeyListener implements KeyListener {

    public GamePanel gamePanel;
    public inputKeyListener(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyChar()){
            case 'w': gamePanel.changeYPosition(-5);break;
            case 'a': gamePanel.changeXPosition(-5);break;
            case 's': gamePanel.changeYPosition(+5);break;
            case 'd': gamePanel.changeXPosition(+5);break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
