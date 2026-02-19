package src.design08_Chess_Game_Design.Board.Piece;

import src.design08_Chess_Game_Design.Board.Moves.Move;

public class Bishop extends Piece{

    public Bishop(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(Move move) {
        return true;
    }

    @Override
    public PieceType getPieceType() {
        return PieceType.BISHOP;
    }
}
