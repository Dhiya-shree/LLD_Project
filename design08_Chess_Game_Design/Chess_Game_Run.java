package src.design08_Chess_Game_Design;

import src.design08_Chess_Game_Design.Board.Piece.Color;
import src.design08_Chess_Game_Design.Game.GameController;
import src.design08_Chess_Game_Design.Game.Player;

public class Chess_Game_Run {
    public static void main(String[] args) {
        GameController gc=new GameController();
        Player winner=gc.start(new Player("shree", Color.BLACK),new Player("diya",Color.WHITE));
        System.out.println(" Winner is "+winner.getName()+" of "+winner.getColor());
    }
}
