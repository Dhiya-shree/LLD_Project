package src.design08_Chess_Game_Design.Board;

import src.design08_Chess_Game_Design.Board.Moves.Coordinate;
import src.design08_Chess_Game_Design.Board.Moves.Move;
import src.design08_Chess_Game_Design.Board.Piece.*;
import src.design08_Chess_Game_Design.Game.Player;

public class Board {

    private static final int size=8;
    private Cell[][] board;

    /*
     | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 |
     ---------------------------------
  0  | P | K | B | K | Q | B | K | P |
     ---------------------------------
  1  | R | R | R | R | R | R | R | R |
     ---------------------------------
  2  |   |   |   |   |   |   |   |   |
     ---------------------------------
  3  |   |   |   |   |   |   |   |   |
     ---------------------------------
  4  |   |   |   |   |   |   |   |   |
     ---------------------------------
  5  |   |   |   |   |   |   |   |   |
     ---------------------------------
  6  | R | R | R | R | R | R | R | R |
     ---------------------------------
  7  | P | K | B | K | Q | B | K | P |
     ---------------------------------

     */

    public Board(Player a, Player b) {
        this.board=new Cell[size][size];
        //Initialize board
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){

                //Empty positions
                if(i==2||i==3||i==4||i==5){
                    board[i][j]=new Cell();
                }
                // Set up rook
                else if(i==1){
                    board[i][j]=new Cell(new Rook(a.getColor()));
                }
                else if(i==6){
                    board[i][j]=new Cell(new Rook(b.getColor()));
                }
                // King Queen Bishop Pawn and Knight
                else if(i==0){
                    if(j==0||j==7){
                        board[i][j]=new Cell(new Pawn(a.getColor()));
                    }
                    else if(j==1||j==6){
                        board[i][j]=new Cell(new Knight(a.getColor()));
                    }
                    else if(j==2||j==5){
                        board[i][j]=new Cell(new Bishop(a.getColor()));
                    }
                    else if(j==3){
                        board[i][j]=new Cell(new King(a.getColor()));
                    }
                    else if(j==4){
                        board[i][j]=new Cell(new Queen(a.getColor()));
                    }
                }
                else if(i==7){
                    if(j==0||j==7){
                        board[i][j]=new Cell(new Pawn(b.getColor()));
                    }
                    else if(j==1||j==6){
                        board[i][j]=new Cell(new Knight(b.getColor()));
                    }
                    else if(j==2||j==5){
                        board[i][j]=new Cell(new Bishop(b.getColor()));
                    }
                    else if(j==3){
                        board[i][j]=new Cell(new King(b.getColor()));
                    }
                    else if(j==4){
                        board[i][j]=new Cell(new Queen(b.getColor()));
                    }
                }


            }
        }
    }

    public Cell getCell(Coordinate coordinate){
        return board[coordinate.x][coordinate.y];
    }

    public boolean setCell(Move move){
        Coordinate coordinate=move.getStartPos();
        Piece piece=move.getPiece();
        Coordinate endPos=move.getEndPos();
        Cell curr=getCell(coordinate);
        Cell target=getCell(endPos);


        if(target.isFree()){
            board[endPos.x][endPos.y]=new Cell(piece);//set in new pos
            board[coordinate.x][coordinate.y]=null;//move from curr
            return true;
        }
        else if( target.getPiece().getColor()!=piece.getColor()){
            target.getPiece().setKilled(true);
            System.out.println(target.getPiece().getPieceType()+" of color "+target.getPiece().getColor()+" is out of game !!!");
            curr.setPiece(null);
            return true;
        }
        else{
            System.out.println(" Not able to set . ");
           // return false;
        }

        return false;
    }

    public void print(){
        // set length of Each name as 12 // they set 12
        for(int i=0;i<=size;i++) {
            if(i==0){
                System.out.print(rightPadding(" "));
            }
            else {
                System.out.print(rightPadding(Integer.toString(i-1)));
            }
        }
        System.out.println();
        for(int i=0;i<size;i++) {
            for (int j = 0; j < size; j++) {

                if(j==0){
                    System.out.print(i+" | ");
                }
                if(board[i][j].isFree()){
                    System.out.print(rightPadding(""));
                }
                else{
                    System.out.print(rightPadding(
                            board[i][j].getPiece().getPieceType()+"-"+
                            board[i][j].getPiece().getColor()));
                }
            }
            System.out.println();
        }
    }

    public String rightPadding(String s){
        // pad with 15 char
        return s+" ".repeat(15-s.length());
    }


}
