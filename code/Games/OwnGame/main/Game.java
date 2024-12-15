package Games.OwnGame.main;

public class Game{

    public GamePanel gamePanel;
    public MyFrame frame;

    public Game(){
        gamePanel = new GamePanel();
        frame = new MyFrame(gamePanel);
        gamePanel.requestFocus();

    }
}
