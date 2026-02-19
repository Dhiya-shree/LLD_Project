package src.design08_Chess_Game_Design.Game;

import src.design08_Chess_Game_Design.Board.Board;


public class Game {
    private final Player playerA;
    private final Player playerB;

    private Player playerTurn;

    private Board board;

    public Game(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
        this.playerTurn=(((Math.random()*10))>5?playerA:playerB);
        board=new Board(playerA,playerB);
    }

    public Board getBoard() {
        return board;
    }

    public void setPlayerTurn(Player playerTurn) {
        this.playerTurn = playerTurn;
    }

    public Player getPlayerB() {
        return playerB;
    }

    public Player getPlayerA() {
        return playerA;
    }

    public Player getPlayerTurn() {
        return playerTurn;
    }
}
