
package hang;

import java.io.FileNotFoundException;


public class HangMan {
    
    public static void main(String []args) throws FileNotFoundException{
        Hang game=new Hang();
        game.read();
        game.setUp();
    }
    
}
