package pong;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.event.*;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.animation.*;
import javafx.util.*;


import java.awt.event.KeyListener;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import javafx.event.EventHandler;


/**
 *
 * @author danappel
 */
public class GUI_Archive extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    private Ball ball;
    private Paddle leftPaddle;
    private Paddle rightPaddle;
    
    private double xVel = 3;
    private double yVel = 3;
    private double radius = 20;
    
    
    final public static int WIDTH = 600;
    final public static int HEIGHT = 500;
    
    @Override public void start(final Stage primaryStage) {
        Group root = new Group();
        
        //Create game components
        RadialGradient g = new RadialGradient(
                0, 0,
                0.35, 0.35,
                0.5,
                true,
                CycleMethod.NO_CYCLE,
                new Stop(0.0, Color.WHITE),
                new Stop(1.0, Color.BLACK));
        
        //Create game components
        
        ball = new Ball(radius, g, 3 );
        leftPaddle = new Paddle(true, 50, 20, true);
        rightPaddle = new Paddle(false, 50, 20, true);
        

        //Add components to game
        root.getChildren().addAll(ball.getPiece());
        root.getChildren().addAll(leftPaddle.getPiece());
        root.getChildren().addAll(rightPaddle.getPiece());
        
        
        //Create scene & Stage
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        
        //Set Key Hanlders
        setKeys(scene);
        
        primaryStage.setTitle("Bouncing Ball");
        primaryStage.setScene(scene);
        
        primaryStage.show();
        
        //Draw Handler--Main Animation Logic
        KeyFrame k = new KeyFrame(Duration.millis(10), e ->
        {
            //Update Ball Position
            ball.update();
            
            //Update paddles
            leftPaddle.update();
            rightPaddle.update();
            
        });
        
        Timeline t = new Timeline(k);
        t.setCycleCount(Timeline.INDEFINITE);
        t.play();
        
    }
    
    public void setKeys(Scene sc) {
        //Key Down Handler
        sc.setOnKeyPressed(new EventHandler<KeyEvent>() {
               @Override
               public void handle(KeyEvent event) {
                   
                   leftPaddle.update(event, true);
                   rightPaddle.update(event, true);
               }
        });
        
        //Key Up Handler
        sc.setOnKeyReleased(new EventHandler<KeyEvent>() {
               @Override
               public void handle(KeyEvent event) {
                   leftPaddle.update(event, false);
                   rightPaddle.update(event, false);
               }
        });
        
    }
    
 
   
    
    
    
    
}
