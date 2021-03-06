
package pong;

import javafx.scene.shape.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Paddle extends GamePiece {
    
    double velocity;
    double paddleCenter;
    double paddleX;
    double paddleY;
    double paddleHeight;
    double paddleWidth;
    
    //Determines which keys stand for up and down (e.g. arrows or WASD)
    KeyCode up;
    KeyCode down;
    
    
    //Graphical representation of paddle
    Line piece;
    
    public Paddle(boolean left, double ht, double width) {
     
        this.paddleWidth = width;
        this.velocity = 0;
        this.paddleHeight = ht;
        this.paddleY = GUI.HEIGHT/2;
        
        this.piece = new Line();
        piece.setStrokeWidth(paddleWidth);

        if(left) {
            piece.setStartX(paddleWidth/2);
            piece.setEndX(paddleWidth/2);
            updatePaddleCenter();
            
            //Set key handlers (up/down)
            up = KeyCode.W;
            down = KeyCode.S;
            
        }
        else {
            piece.setStartX(GUI.WIDTH - paddleWidth/2);
            piece.setEndX(GUI.WIDTH - paddleWidth/2);
            updatePaddleCenter();
            
            //Set key handlers (up/down)
            up = KeyCode.UP;
            down = KeyCode.DOWN;
        }

    }
   
    @Override
    public void update() {
            //Stick Paddles on Screen
            
            paddleY += velocity*GamePiece.paddleSpeed;
            updatePaddleCenter();
        }
    
    public void updatePaddleCenter() {
        //paddleY is the center of the paddle.  This creates a line with a center point
         piece.setStartY(paddleY - paddleHeight);
         piece.setEndY(paddleY + paddleHeight);
    }
    
    
    public void update(KeyEvent key, boolean pressed) {
        
        if(pressed) {
            //Determine if up event (e.g. arrow up or W key)
            if (key.getCode() == up) {
                velocity = -1;
            }
            //Determine if down event (e.g. arrow down or S key)
            else if (key.getCode() == down) {
                velocity = 1;
            }
        }
        else {
            if (key.getCode() == up) {
                velocity = 0;
            }
            else if (key.getCode() == down) {
                velocity = 0;
            }
        }
        
        
    }
    
    public double getHeight() {
        return paddleHeight;
    }
    
    public double getWidth() {
        return paddleWidth;
    }
    
    @Override
    public void bounce() {
        
    }
    
    @Override
    public boolean collide(GamePiece other) {
        return false;
    }
    
    public double[] getCoordinates() {
        double[] coord = {paddleX, paddleY};
        return coord;
    }
    
    @Override
    public Shape getPiece() {
        return this.piece;
    }
}
