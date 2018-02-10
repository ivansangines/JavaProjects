package tennis;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.IOException;

public class Ball {

    private static final int DIAMETER = 20;
    double x = 0;
    double y = 0;
    double xa = 1;
    double ya = 1;
    private GameClass game;

    public Ball(GameClass game) {
        this.game = game;
    }

    void moveBall() throws IOException {
        if (x + xa < 0) {
            xa = game.speed;
        }
        if (x + xa > game.getWidth() - DIAMETER) {
            xa = -game.speed;
        }
        if (y + ya < 0) {
            ya = game.speed;
        }
//        if (y + ya > game.getHeight() - DIAMETER) {
//            ya = -1;
//        }
        if (collision()) {
            ya = -game.speed;
            y = game.rac.getTopY() - DIAMETER;
            game.speed+=0.15;
            game.count++;
        }
        if (y + ya > game.getHeight() - DIAMETER)
			game.gameOver();

        x = x + xa;
        y = y + ya;
    }

    public void paint(Graphics2D g) {
        g.setColor(Color.BLUE);
        g.fillOval((int)x, (int)y, DIAMETER, DIAMETER);
    }

    private boolean collision() {
        return game.rac.getBounds().intersects(getBounds());
    }

    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, DIAMETER, DIAMETER);
    }
}
