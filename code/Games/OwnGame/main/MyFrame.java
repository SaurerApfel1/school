package Games.OwnGame.main;

import javax.swing.*;

public class MyFrame extends JFrame {

    public MyFrame(GamePanel gamePanel){

        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        frame.add(gamePanel);
        frame.setVisible(true);
    }
}
