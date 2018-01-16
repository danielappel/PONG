
package pong;

import javafx.scene.input.KeyEvent;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
/**
 *
 * @author danappel
 */
public class Ball extends GamePiece {
    private double ballX;
    private double ballY;
    private double radius;
    private double velX;
    private double velY;
    
    Circle piece;
    
    public Ball(double r, RadialGradient g, double vel) {
        //Create a circle for the ball
        piece = new Circle(r, g);
        
        this.radius = r;
        piece.setCenterX(r);
        piece.setCenterY(r);
        //Update center
        ballX = piece.getCenterX();
        ballY = piece.getCenterY();
        
        //Set Velocities
        velX = vel;
        velY = vel;
        
    }
    
    public void update() {
        moveBall();
        bounce();
    }
    
    @Override
    public void update(KeyEvent key, boolean pressed) {
        //Pass
    }
    
    private void moveBall() {
        //Update
        ballX = piece.getCenterX() + velX;
        ballY = piece.getCenterY() + velY;
        
        piece.setCenterX(ballX);
        piece.setCenterY(ballY);
    }
    
    public void bounce() {
        
        if(ballX <= radius || ballX >= GUI.WIDTH - radius) {
            velX *= -1;
        }
        if(ballY <= radius || ballY >= GUI.HEIGHT - radius) {
            velY *= -1;
        }
    }
        
    public boolean collide(GamePiece other) {
        
        
        double[] coords = other.getCoordinates();
        double distanceX = Math.abs(this.ballX - coords[0]);
        double distanceY = Math.abs(this.ballY - coords[1]);
        
        //Look at difference in x positions
        if(distanceX < radius) {
            if(distanceY < other.getHeight()/2) {
                return true;
            }
        }
        return false;
    }
    
    public Shape getPiece() {
        return this.piece;
    }
    
    public double getWidth() {
        return radius*2;
    }
    
    public double getHeight() {
        return radius*2;
    }
    
    public double[] getCoordinates() {
        double[] coord = {ballX, ballY};
        return coord;
    }
        
        
}

