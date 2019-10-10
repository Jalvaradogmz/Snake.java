/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author junio
 */
public class Bola {

    private Color color;
    private int x;
    private int y;
    public final int TAM = 40;

    public Bola(Color color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x,y,TAM,TAM);
    }

    public void pintar(Graphics g){
        g.setColor(color);
        g.fillOval(x,y,TAM,TAM);
    }
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
