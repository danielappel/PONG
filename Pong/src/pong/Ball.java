
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
        piece.setCenterY(GUI.HEIGHT/2); //Center of the screen
        //Update center
        ballX = piece.getCenterX();
        ballY = piece.getCenterY();
        
        //Set Velocities
        velX = vel;
        velY = 0; //Debug with no vertical velocity
        
    }
    
    public void update() {
        moveBall();
        bounce();
    }
    
    @Override
    public void update(KeyEvent key, boolean pressed) {
        //Pass--Not relevant for ball game piece
    }
    
    private void moveBall() {
        //Update
        ballX = piece.getCenterX() + velX;
        ballY = piece.getCenterY() + velY;
        
        piece.setCenterX(ballX);
        piece.setCenterY(ballY);
    }
    
    public void bounce() {
        
        //Bounce off vertial walls
       
        
        if(ballX <= 0 || ballX >= GUI.WIDTH) {
            //Rest to center
            ballX = GUI.WIDTH/2;
            velX *= -1;
        }
        
               
        //Bounce off of horizontal walls
        if(ballY <= radius || ballY >= GUI.HEIGHT - radius) {
            velY *= -1;
        }
    }
        
    public boolean collide(GamePiece other) {
        
        //Get coordinates from other piece in game (e.g paddles)
        double[] coords = other.getCoordinates();
        double distanceX = Math.abs(this.ballX - coords[0]);
        double distanceY = Math.abs(this.ballY - coords[1]);
        
        //Look at difference in x positions
        //System.out.println("Distance X: " + distanceX + "\nDistance Y: " + distanceY + "\n\n");
        
        if(distanceX < 2*radius) {
            System.out.println("X in range");
            System.out.println("The other height is: " + other.getHeight()/2);
            if(distanceY < other.getHeight()/2) {
                //There will be a collision--bounce the ball!
                System.out.println("BOUNCE!!");
                return true;
            }
        }
        return false;
    }
    
    public void changeXVelocity() {
        this.velX *= -1;
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

