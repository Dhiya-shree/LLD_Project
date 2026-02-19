package src.design08_Chess_Game_Design.Board.Moves;

import src.design08_Chess_Game_Design.Board.Piece.Piece;

public class Move {
    Coordinate startPos;
    Coordinate endPos;
    Piece piece;

    public Move(Coordinate startPos, Coordinate endPos, Piece piece) {
        this.startPos = startPos;
        this.endPos = endPos;
        this.piece = piece;
    }

    public Coordinate getStartPos() {
        return startPos;
    }

    public Coordinate getEndPos() {
        return endPos;
    }

    public Piece getPiece() {
        return piece;
    }
}
