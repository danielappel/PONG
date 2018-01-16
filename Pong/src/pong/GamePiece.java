
package pong;

import javafx.scene.input.KeyEvent;
import javafx.scene.shape.*;

public abstract class GamePiece {
    
    public static final int paddleSpeed = 3;
    
    public abstract void update();
    
    //Used for key handlers
    public abstract void update(KeyEvent key, boolean pressed);
    
    public abstract void bounce();
    
    public abstract boolean collide(GamePiece other);
    
    public abstract Shape getPiece();
    
    public abstract double[] getCoordinates();
    
    public abstract double getWidth();
    
    public abstract double getHeight();
        
   
    
}
