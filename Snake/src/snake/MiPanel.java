/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/**
 *
 * @author junio
 */
public class MiPanel extends JPanel implements KeyListener {

    private Snake culebra;
    private int ms;

    public MiPanel() {
        culebra = new Snake();
        setFocusable(true);
        addKeyListener(this);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        ms = 200;
        g.setColor(Color.ORANGE);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.BLACK);
        g.fillRect(80, 80, 1120, 560);
        g.setFont(new Font("Arial Black", Font.BOLD, 20));
        g.drawString("Score: " + culebra.getScore(), 20, 30);

        culebra.mover(1120, 560);
        culebra.pintar(g);

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1300, 700);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        culebra.cambioDir(ke.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
}
