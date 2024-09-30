package Privat.Game;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    final int panelWidth = 800;
    final int panelHeight = 800;

    public GamePanel() {
        this.setBackground(Color.black);
        this.setPreferredSize(new Dimension(panelWidth, panelHeight));
        this.setDoubleBuffered(true);
    }
}
