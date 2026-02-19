package src.design08_Chess_Game_Design.Board.Piece;

import src.design08_Chess_Game_Design.Board.Moves.Move;

public class Queen extends Piece{

    public Queen(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(Move move) {
        return true;
    }

    @Override
    public PieceType getPieceType() {
        return PieceType.QUEEN;
    }
}
