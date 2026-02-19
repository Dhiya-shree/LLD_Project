package src.design08_Chess_Game_Design.Board;
import src.design08_Chess_Game_Design.Board.Piece.Piece;

public class Cell {
    private Piece piece;

    public boolean isFree(){
        return (piece==null);
    }

    public Cell(Piece p) {
        this.piece = p;
    }

    public Cell() {
        this.piece=null;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece p) {
        this.piece = p;
    }
}
