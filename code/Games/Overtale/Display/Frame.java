package Games.Overtale.Display;

import Games.Overtale.Entities.Enemy;
import Games.Overtale.Entities.Player;
import Games.Overtale.Game;
import Games.Overtale.Gameplay.Buff;
import Games.Overtale.Gameplay.ButtonListenerAction;
import Games.Overtale.Gameplay.ButtonListenerSingleEvent;
import Games.Overtale.Gameplay.SoundEffect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame implements ActionListener {

    public Button startButton, action1, action2, action3, action4, winButton, rewardButton1, rewardButton2, rewardButton3;
    public Player player;
    public Enemy enemy;
    public Font
            textFont = new Font("Arial Black", Font.ITALIC, 25), titleFont = new Font("Arial Black", Font.BOLD, 75),
            rewardFont = new Font("Arial Black", Font.BOLD, 50),
            buffFont = new Font("Arial Black", Font.ITALIC, 20);
    public Panel buttonPanel, gamePanel, textPanel, titlePanel, rewardPanel1, rewardPanel2, rewardPanel3;
    public JLabel titleLabel, rewardLabel1, rewardLabel2, rewardLabel3;
    public JProgressBar playerHpBar, enemyHpBar, playerStamBar;
    public JTextArea textArea;
    public Game game;
    public String fightSongPath = "resource\\sounds\\Fight-Banger.wav";
    public SoundEffect fightSong = new SoundEffect();
    public JTextArea buffArea1, buffArea2, buffArea3;
    public static Buff CHOSEN_BUFF;
    public JLabel
            buff1_RarityLabel,
            buff2_RarityLabel,
            buff3_RarityLabel;

    public Frame(Player player, Enemy enemy,Game game){
        this.player = player;
        this.enemy = enemy;
        this.game = game;

        playerHpBar = player.createHpBar(this);
        playerHpBar.setBounds(100, 50, 250, 45);
        player.hpBar = playerHpBar;

        enemy.hpBar = enemyHpBar;

        playerStamBar = player.stamBar;
        buttonPanel = new Panel(Color.BLACK,50, 600, 900, 100);
        buttonPanel.setLayout(new GridLayout(1, 4, 40, 10));
        //gamePanel = new Panel(Color.BLACK,0, 0, 1000, 350);
        textPanel = new Panel(Color.BLACK,150, 350, 650, 200);
        textPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 10));

        initRewardComponents();

        titlePanel = new Panel(Color.BLACK, 230, 300, 500, 150);
        titleLabel = new JLabel("OVERTALE");
        titleLabel.setBorder(BorderFactory.createLineBorder(Color.RED, 10));
        titleLabel.setForeground(Color.RED);
        titleLabel.setFont(titleFont);
        titlePanel.add(titleLabel);


        textArea = new JTextArea();
        textArea.setBounds(180, 350, 630, 200);
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.WHITE);
        textArea.setFont(textFont);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textPanel.add(textArea);

        ButtonListenerSingleEvent listenerSingleEvent = new ButtonListenerSingleEvent(this);
        ButtonListenerAction listenerChoice = new ButtonListenerAction(game, player, enemy);

        startButton = Button.createButton("start Game");
        startButton.setActionCommand("start");
        startButton.setBounds(350, 500, 250, 100);
        startButton.addActionListener(listenerSingleEvent);

        winButton = Button.createButton("rewards");
        winButton.setActionCommand("rewards");
        winButton.setBounds(400, 600 , 200, 100);
        winButton.addActionListener(listenerSingleEvent);
        winButton.setVisible(false);


        action1 = Button.createButton("Attack");
        action1.setActionCommand("attack");
        action1.addActionListener(listenerChoice);
        action2 = Button.createButton("Defend");
        action2.setActionCommand("defend");
        action2.addActionListener(listenerChoice);
        action3 = Button.createButton("Item");
        action3.setActionCommand("item");
        action3.addActionListener(listenerChoice);
        action4 = Button.createButton("Stat");
        action4.setActionCommand("stat");
        action4.addActionListener(listenerChoice);
        buttonPanel.add(action1);
        buttonPanel.add(action2);
        buttonPanel.add(action3);
        buttonPanel.add(action4);

        buttonPanel.setVisible(false);
        //gamePanel.setVisible(false);
        textPanel.setVisible(false);
        playerHpBar.setVisible(false);
        playerStamBar.setVisible(false);

        player.updStamBar(playerStamBar);
        player.updateHpBar(playerHpBar);

        addComponents();


        this.setSize(1000, 750);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.BLACK);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(null);
        this.setVisible(true);
    }

    public void addComponents(){
        this.add(rewardPanel1);
        this.add(rewardPanel2);
        this.add(rewardPanel3);

        this.add(playerHpBar);
        this.add(playerStamBar);
        this.add(titlePanel);
        this.add(startButton);
        this.add(winButton);
        this.add(buttonPanel);
        //this.add(gamePanel);
        this.add(textPanel);
    }

    public void createGameScreen(){
        enemyHpBar = enemy.createHpBar(this);
        enemyHpBar.setBounds(500, 50, 250, 45);
        enemy.hpBar = enemyHpBar;

        startButton.setVisible(false);
        titlePanel.setVisible(false);
        game.powerButtons(true);

        Game.playSound(fightSongPath, fightSong);

        buttonPanel.setVisible(true);
        //gamePanel.setVisible(true);
        textPanel.setVisible(true);
        playerHpBar.setVisible(true);
        playerStamBar.setVisible(true);
        enemyHpBar.setVisible(true);

        rewardPanel1.setVisible(false);
        rewardPanel2.setVisible(false);
        rewardPanel3.setVisible(false);



        this.textArea.setText("Du triffst auf \""+enemy.getName()+"\"!");
    }

    public void createEnemyDefeatedScreen(){
        Timer timer = new Timer(2500, e -> {
            buttonPanel.setVisible(false);
            playerHpBar.setVisible(false);
            playerStamBar.setVisible(false);

            winButton.setVisible(true);

            this.textArea.setText("Du hast den Kampf gewonnen!");
        });
        timer.setRepeats(false); // Nur einmal ausführen
        timer.start();
    }

    public void createRewardScreen(){
        fightSong.clip.close();
        enemyHpBar.setVisible(false);
        winButton.setVisible(false);
        textPanel.setVisible(false);

        rewardPanel1.setVisible(true);
        rewardPanel2.setVisible(true);
        rewardPanel3.setVisible(true);


    }

    public void showBuffCardsDetail(Buff buff1, Buff buff2, Buff buff3){
        System.out.println(buff1.getBuffType() + buff1.getRarity());
        System.out.println(buff2.getBuffType() + buff2.getRarity());
        System.out.println(buff3.getBuffType() + buff3.getRarity());

        rewardLabel1.setText(buff1.getBuffType());
        rewardLabel2.setText(buff2.getBuffType());
        rewardLabel3.setText(buff3.getBuffType());

        buff1_RarityLabel = new JLabel(buff1.getRarity());
        buff2_RarityLabel = new JLabel(buff2.getRarity());
        buff3_RarityLabel = new JLabel(buff3.getRarity());
        buff1_RarityLabel.setFont(textFont);
        buff2_RarityLabel.setFont(textFont);
        buff3_RarityLabel.setFont(textFont);
        Color buff1_LabelColor = getBuffColor(buff1);
        Color buff2_LabelColor = getBuffColor(buff2);
        Color buff3_LabelColor = getBuffColor(buff3);
        buff1_RarityLabel.setForeground(buff1_LabelColor);
        buff2_RarityLabel.setForeground(buff2_LabelColor);
        buff3_RarityLabel.setForeground(buff3_LabelColor);

        buff1_RarityLabel.setBounds(20, 60, 200, 50);
        buff2_RarityLabel.setBounds(20, 60, 200, 50);
        buff3_RarityLabel.setBounds(20, 60, 200, 50);

        setRewardPanelColor(buff1, rewardPanel1);
        setRewardPanelColor(buff2, rewardPanel2);
        setRewardPanelColor(buff3, rewardPanel3);

        buffArea1.setBackground(rewardPanel1.getBackground());
        buffArea2.setBackground(rewardPanel2.getBackground());
        buffArea3.setBackground(rewardPanel3.getBackground());

        Buff.displayBuffs(buff1, buffArea1);
        Buff.displayBuffs(buff2, buffArea2);
        Buff.displayBuffs(buff3, buffArea3);

        rewardPanel1.setLayout(null);
        rewardPanel2.setLayout(null);
        rewardPanel3.setLayout(null);

        rewardButton1.setForeground(getBuffColor(buff1));
        rewardButton2.setForeground(getBuffColor(buff2));
        rewardButton3.setForeground(getBuffColor(buff3));

        rewardPanel1.add(buff1_RarityLabel);
        rewardPanel2.add(buff2_RarityLabel);
        rewardPanel3.add(buff3_RarityLabel);
        //rewardPanel1.setLayout(new BoxLayout(rewardPanel1, BoxLayout.Y_AXIS));
    }

    public void initRewardComponents(){
        rewardPanel1 = new Panel(Color.BLACK, 20, 100, 300, 500);
        rewardPanel2 = new Panel(Color.BLACK, 345, 100, 300, 500);
        rewardPanel3 = new Panel(Color.BLACK, 670, 100, 300, 500);
        rewardPanel1.setLayout(new BorderLayout(50, 50));
        rewardPanel2.setLayout(new BorderLayout(50, 50));
        rewardPanel3.setLayout(new BorderLayout(50, 50));
        rewardPanel1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 10));
        rewardPanel2.setBorder(BorderFactory.createLineBorder(Color.WHITE, 10));
        rewardPanel3.setBorder(BorderFactory.createLineBorder(Color.WHITE, 10));
        rewardPanel1.setVisible(false);
        rewardPanel2.setVisible(false);
        rewardPanel3.setVisible(false);

        rewardButton1 = Button.createButton("Pick");
        rewardButton2 = Button.createButton("Pick");
        rewardButton3 = Button.createButton("Pick");
        rewardButton1.setForeground(Color.BLUE);
        rewardButton2.setForeground(Color.RED);
        rewardButton3.setForeground(Color.GREEN);
        rewardLabel1 = new JLabel("Life");
        rewardLabel2 = new JLabel("Attack");
        rewardLabel3 = new JLabel("Stamina");
        rewardLabel1.setFont(rewardFont);
        rewardLabel2.setFont(rewardFont);
        rewardLabel3.setFont(rewardFont);
        rewardLabel1.setForeground(Color.WHITE);
        rewardLabel2.setForeground(Color.WHITE);
        rewardLabel3.setForeground(Color.WHITE);

        rewardPanel1.add(rewardLabel1, BorderLayout.NORTH);
        rewardPanel2.add(rewardLabel2, BorderLayout.NORTH);
        rewardPanel3.add(rewardLabel3, BorderLayout.NORTH);

        buffArea1 = createRewardTxtArea(rewardPanel1);
        buffArea1.setLocation(20, 100);
        buffArea1.setBackground(rewardPanel1.getBackground());
        buffArea2 = createRewardTxtArea(rewardPanel2);
        buffArea1.setLocation(20, 100);
        buffArea2.setBackground(rewardPanel2.getBackground());
        buffArea3 = createRewardTxtArea(rewardPanel3);
        buffArea3.setBackground(rewardPanel3.getBackground());
        buffArea1.setLocation(20, 100);

        rewardButton1.addActionListener(this);
        rewardButton2.addActionListener(this);
        rewardButton3.addActionListener(this);

        rewardPanel1.add(rewardButton1, BorderLayout.SOUTH);
        rewardPanel2.add(rewardButton2, BorderLayout.SOUTH);
        rewardPanel3.add(rewardButton3, BorderLayout.SOUTH);


    }

    public JTextArea createRewardTxtArea(Panel rewardPanel){
        JTextArea rewardTextArea = new JTextArea();
        rewardTextArea.setLineWrap(true);
        rewardTextArea.setFont(buffFont);
        rewardTextArea.setForeground(Color.WHITE);
        rewardTextArea.setEditable(false);
        rewardPanel.add(rewardTextArea);
        rewardTextArea.setText("ARSCH");
        return rewardTextArea;
    }

    public Color getBuffColor(Buff buff){
        return switch (buff.getRarity()) {
            case "Epic" -> Color.MAGENTA;
            case "Rare" -> Color.BLUE;
            case "Common" -> Color.LIGHT_GRAY;
            default -> null;
        };
    }

    public void setRewardPanelColor(Buff buff, Panel panel){
         switch (buff.getBuffType()){
            case "Health" -> panel.setBackground(Color.GREEN);
            case "Stamina" -> panel.setBackground(Color.YELLOW);
            case "Damage" -> panel.setBackground(Color.RED);
            case "Crit" -> panel.setBackground(Color.ORANGE);
        }
    }

    public void updateEnemy(Enemy newEnemy){
        this.enemy = newEnemy;
    }

    public void updateEnemyDetails(Enemy enemy){
        System.out.println(enemy.getHp());
        enemyHpBar.setMaximum(enemy.getHp());
        enemyHpBar.setValue(enemy.getHp());
        enemy.updateHpBar(enemyHpBar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==rewardButton1){
            CHOSEN_BUFF = game.buff1;powerRarityLabels(false); Game.applyBuffs(CHOSEN_BUFF, player);createGameScreen();
        }
        else if (e.getSource()==rewardButton2){
            CHOSEN_BUFF = game.buff2;powerRarityLabels(false); Game.applyBuffs(CHOSEN_BUFF, player);createGameScreen();
        }
        else if (e.getSource()==rewardButton3){
            CHOSEN_BUFF = game.buff3;powerRarityLabels(false); Game.applyBuffs(CHOSEN_BUFF, player);createGameScreen();
        }
    }

    public void powerRarityLabels(boolean onOff){
        buff1_RarityLabel.setVisible(onOff);
        buff2_RarityLabel.setVisible(onOff);
        buff3_RarityLabel.setVisible(onOff);
    }
}
