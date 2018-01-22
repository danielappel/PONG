
package pong;


public class Player {
    public GamePiece piece;
    public boolean human;
    public int score;
    
    public Player(boolean hum, GamePiece p) {
        this.human = hum;
        this.piece = p;
    }
    
    public boolean getHuman() {
        return this.human;
    }
    
    public GamePiece getPiece() {
        return this.piece;
    }
    
}
