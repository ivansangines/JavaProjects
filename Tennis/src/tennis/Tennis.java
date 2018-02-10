package tennis;

import java.io.IOException;
import javax.swing.JFrame;


public class Tennis {

    public static void main(String[] args) throws InterruptedException, IOException {
        
        JFrame frame = new JFrame("Mini Tennis");
        GameClass game = new GameClass();
//                KeyboarListener keyboard=new KeyboarListener();
//                frame.add(keyboard);
        frame.add(game);
        frame.setSize(300, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            game.moveBall();
            game.repaint();
            Thread.sleep(10);
        }
        
        
    }

}
