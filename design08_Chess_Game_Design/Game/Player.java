package src.design08_Chess_Game_Design.Game;

import src.design08_Chess_Game_Design.Board.Piece.Color;

public class Player {
    private String name;
    private Color color;


    public Player(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }
}
