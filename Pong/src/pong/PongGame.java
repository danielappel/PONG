
package pong;

import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import java.util.ArrayList;


public class PongGame extends Game {
    
    Ball pongBall;
    Player playerLeft;
    Player playerRight;
    
    ArrayList<GamePiece> pieces = new ArrayList<GamePiece>();
    
    
    public void setUpGame(boolean hum1, boolean hum2) {
        
        createBall();
        
        Paddle[] paddles = createPaddles();
        
        playerLeft = new Player(hum1,  paddles[0]);
        playerRight = new Player(hum2, paddles[1]);
        
        pieces.add(pongBall);
        pieces.add(playerLeft.getPiece());
        pieces.add(playerRight.getPiece());
    }
    
    public ArrayList<GamePiece> getGamePieces() {
        return this.pieces;
    }
   
    public Paddle[] createPaddles() {
         Paddle leftPaddle = new Paddle(true, 50, 20);
         Paddle rightPaddle = new Paddle(false, 50, 20);
         
         Paddle[] paddles = {leftPaddle, rightPaddle};
         return paddles;
    }
    
    public void createBall() {
            double velocity = 3;
            double radius = 20;
    
        
        RadialGradient g = new RadialGradient(
                0, 0,
                0.35, 0.35,
                0.5,
                true,
                CycleMethod.NO_CYCLE,
                new Stop(0.0, Color.WHITE),
                new Stop(1.0, Color.BLACK));
        
        
        pongBall = new Ball(radius, g, velocity);
        
    }
    
   
    
    public Player[] getPlayers() {
        Player[] gamePlayers= {playerLeft, playerRight};
        return gamePlayers;
    }
    
   
    @Override
    public void update() {
        
        for(GamePiece p: pieces) {
            
            p.update();
        }
        
    }
    
}
