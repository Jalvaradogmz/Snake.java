package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

public class Snake {

    private Bola manzana;
    private LinkedList<Bola> snake;
    private int dir;
    private int Score;

    public Snake() {
        snake = new LinkedList<>();
        config();
        dir = 1;
    }

    private void config() {
        manzana = new Bola(Color.GREEN, 120, 120);
        snake.add(new Bola(Color.red, 600, 400));
        snake.add(new Bola(Color.lightGray, 600, 440));
        snake.add(new Bola(Color.lightGray, 600, 480));
    }

    public void pintar(Graphics g) {
        manzana.pintar(g);
        for (Bola bola : snake) {
            bola.pintar(g);
        }

    }

    public void dibujarMatriz(Graphics g) {
        int x = 80;
        int y = 80;
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 28; j++) {
                g.setColor(Color.blue);
                g.drawRect(x, y, 40, 40);
                x += 40;
            }
            x = 80;
            y += 40;
        }
    }

    public void mover(int ancho, int alto) {
        Bola cabAnt = snake.getFirst();
        Rectangle r = new Rectangle();
        r.x = 120;
        r.y = 120;
        r.height = alto;
        r.width = ancho;
        Rectangle r2 = new Rectangle();
        r2.x = 40;
        r2.y = 40;
        r2.height = alto;
        r2.width = ancho;
        //if (cabAnt.getX() == manzana.getX() && cabAnt.getY() == manzana.getY()) {
        for (Bola bola : snake) {
            if (cabAnt.getBounds().intersects(bola.getBounds()) && bola != snake.get(0)) {
                snake.clear();
                Score = 0;
                config();
                dir = 1;
            }
        }
        if (cabAnt.getBounds().intersects(manzana.getBounds())) {
            int nX = ancho / cabAnt.TAM - 1;
            int nY = alto / cabAnt.TAM - 1;
            manzana.setX(((int) (Math.random() * 28) + 2) * 40);
            manzana.setY(((int) (Math.random() * 13) + 2) * 40);
            Score += 10;
        } else if (dir > 0) {
            snake.removeLast();
        }

        if (dir == 1) {
            if (!cabAnt.getBounds().intersects(r.getBounds())) {
                Bola nue = new Bola(Color.red, ancho + 40, cabAnt.getY());
                snake.getFirst().setColor(Color.LIGHT_GRAY);
                snake.addFirst(nue);
            } else {
                Bola nue = new Bola(Color.red, cabAnt.getX() - cabAnt.TAM, cabAnt.getY());
                snake.getFirst().setColor(Color.LIGHT_GRAY);
                snake.addFirst(nue);
            }
        } else if (dir == 2) {
            if (!cabAnt.getBounds().intersects(r.getBounds())) {
                Bola nue = new Bola(Color.red, cabAnt.getX(), alto + 40);
                snake.getFirst().setColor(Color.LIGHT_GRAY);
                snake.addFirst(nue);
            } else {
                Bola nue = new Bola(Color.red, cabAnt.getX(), cabAnt.getY() - cabAnt.TAM);
                snake.getFirst().setColor(Color.LIGHT_GRAY);
                snake.addFirst(nue);
            }
        } else if (dir == 3) {
            if (!cabAnt.getBounds().intersects(r2.getBounds())) {
                Bola nue = new Bola(Color.red, 80, cabAnt.getY());
                snake.getFirst().setColor(Color.LIGHT_GRAY);
                snake.addFirst(nue);
            } else {
                Bola nue = new Bola(Color.red, cabAnt.getX() + cabAnt.TAM, cabAnt.getY());
                snake.getFirst().setColor(Color.LIGHT_GRAY);
                snake.addFirst(nue);
            }
        } else if (dir == 4) {
            if (!cabAnt.getBounds().intersects(r2.getBounds())) {
                Bola nue = new Bola(Color.red, cabAnt.getX(), 80);
                snake.getFirst().setColor(Color.LIGHT_GRAY);
                snake.addFirst(nue);
            } else {
                Bola nue = new Bola(Color.red, cabAnt.getX(), cabAnt.getY() + cabAnt.TAM);
                snake.getFirst().setColor(Color.LIGHT_GRAY);
                snake.addFirst(nue);
            }
        }
    }

    public void cambioDir(int keyCode) {
        if (keyCode > 36 && keyCode < 41) {
            int d = keyCode - 36;

            if (d - 2 == dir) {

            } else if (d + 2 == dir) {

            } else {
                dir = keyCode - 36;
            }

        }
    }

    public int getScore() {
        return Score;
    }
}
