package tennis;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Racquet {

    private static final int Y = 330;
    private static final int WIDTH = 60;
    private static final int HEIGHT = 10;
    double x = 0;
    double xa = 0;
    private GameClass game;

    public Racquet(GameClass game) {
        this.game = game;
    }

    public void moveRacquet() {
        if (x + xa > 0 && x + xa < game.getWidth() - 60) {
            x = x + xa;
        }
    }

    public void paint(Graphics2D g) {
        g.setColor(Color.RED);
        g.fillRect((int) x, Y, WIDTH, HEIGHT);
    }

    public void keyReleased(KeyEvent e) {
        xa = 0;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            xa = -game.speed;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            xa = game.speed;
        }
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, Y, WIDTH, HEIGHT);
    }

    public int getTopY() {
        return Y;
    }
}
