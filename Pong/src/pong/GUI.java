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
public class GUI extends Application {
    
    public PongGame pongGame;

    final public static int WIDTH = 600;
    final public static int HEIGHT = 500;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    
    
    @Override public void start(final Stage primaryStage) {
        Group root = new Group();
        
        //Create game components
        pongGame = new PongGame();
        
        pongGame.setUpGame(true, true);
        
        //Add components to game
        for(GamePiece p : pongGame.getGamePieces() ) {
            Shape temp = p.getPiece();
            root.getChildren().addAll(temp);
        }
      
        
        //Create scene & Stage
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        
        //Set Key Hanlders
        setKeys(scene);
        
        primaryStage.setTitle("PONG!!");
        primaryStage.setScene(scene);
        
        primaryStage.show();
        
        //Draw Handler--Main Animation Logic
        KeyFrame k = new KeyFrame(Duration.millis(10), e ->
        {
            //All pieces will updated based on their functionality...e.g. ball moves & bounces
            pongGame.update();
            
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
                   for(Player p : pongGame.getPlayers()) {
                       //Get paddle from player
                       p.getPiece().update(event, true);
                   }
       
               }
        });
        
        //Key Up Handler
        sc.setOnKeyReleased(new EventHandler<KeyEvent>() {
               @Override
               public void handle(KeyEvent event) {
                     for(Player p : pongGame.getPlayers()) {
                       //Get paddle from player  
                       p.getPiece().update(event, false);
                   }
               }
        });
        
    }
    

    
}
