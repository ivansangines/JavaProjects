package tennis;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.io.*;
import java.util.Scanner;

public class GameClass extends JPanel {

    Ball ball = new Ball(this);
    Racquet rac = new Racquet(this);
    double speed = 1;
    int count = 0;

    public int getScore() {
        return count;
    }

    void moveBall() throws IOException {
        ball.moveBall();
        rac.moveRacquet();

    }

    public GameClass() {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                rac.keyReleased(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                rac.keyPressed(e);
            }
        });
        setFocusable(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        ball.paint(g2d);
        rac.paint(g2d);

        g2d.setColor(Color.BLACK); //Score top right
        g2d.setFont(new Font("Verdana", Font.BOLD, 30));
        g2d.drawString(String.valueOf(getScore()), 10, 30);
    }

    public void gameOver() throws IOException {
//        File file=new File("Score");
        FileReader read = new FileReader("Score");
        Scanner in = new Scanner(read);
        int record = in.nextInt();

        if (record < count) {
            JOptionPane.showMessageDialog(this, "New Record TIO: " + getScore() + " Good job!! " + JOptionPane.YES_NO_OPTION);
            
            FileWriter score = new FileWriter("Score");
            score.write(new Integer(count).toString());
            score.close();

        } else {
            JOptionPane.showMessageDialog(this, "your score is: " + getScore() + " Game Over " + JOptionPane.YES_NO_OPTION);
        }
        System.exit(ABORT);
    }

}
