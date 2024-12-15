package Games.OwnGame.main;

import Games.OwnGame.inputs.inputKeyListener;
import Games.OwnGame.inputs.inputMouseListener;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GamePanel extends JPanel {

    public int xDelta = 100, yDelta = 100, yVel = 3, xVel = 3;
    public int frames = 0;
    public long lastFpsCheck = 0;
    public Color color = Color.red;

    public GamePanel(){

        inputMouseListener mouseListener = new inputMouseListener(this);
        addKeyListener(new inputKeyListener(this));
        addMouseListener(mouseListener);
        addMouseMotionListener(mouseListener);


    }

    public void changeXPosition(int value){
         this.xDelta+=value;
    }

    public void changeYPosition(int value){
        this.yDelta+=value;
    }

    public void setRectPosition(int x, int y){
        this.yDelta = y;
        this.xDelta = x;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(color);
        g.fillRect(xDelta, yDelta, 50, 100);

        updateRect();

        frames++;
        if (System.currentTimeMillis() - lastFpsCheck >= 1000){
            lastFpsCheck = System.currentTimeMillis();
            System.out.println("FPS: "+frames);
            frames=0;
        }

        repaint();
    }

    public void updateRect(){
        xDelta+=xVel;
        yDelta+=yVel;
        if (xDelta>=400 || xDelta<=0){
            xVel *= -1;
            color = getRndColor();

        }
        if (yDelta>=400 || yDelta<=0){
            yVel *= -1;
            color = getRndColor();
        }
    }

    public Color getRndColor(){
        Random random = new Random();
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);

        return new Color(r,g,b);
    }


}
