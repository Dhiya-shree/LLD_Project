package src.design08_Chess_Game_Design.Board.Piece;
import src.design08_Chess_Game_Design.Board.Moves.Move;

public abstract class Piece {
    Color color;
    private boolean isKilled;

    public Piece(Color color) {
        this.color = color;
        this.isKilled=false;
    }

    public Color getColor() {
        return color;
    }

    public boolean isKilled() {
        return isKilled;
    }

    public void setKilled(boolean killed) {
        isKilled = killed;
    }

    public abstract boolean isValidMove(Move move);

    public abstract PieceType getPieceType();
}
