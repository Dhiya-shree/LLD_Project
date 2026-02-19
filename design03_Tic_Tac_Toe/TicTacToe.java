package src.design03_Tic_Tac_Toe;

import java.util.ArrayDeque;
import java.util.Deque;

public class TicTacToe {
    public static void main(String[] args) {
      Player p1=new Player("Shree",4);
      Player p2=new Player("Diya",1,5);
      int size=3;
      Board board=new Board(size);
      Deque<Player> playerQ=new ArrayDeque<Player>(size-1);
      // Provide random assignment
      playerQ.add(p1);
      playerQ.add(p2);
      Game game=new Game(board,playerQ);
      Player winner=game.startGame();
      System.out.println(" WINNER IS ....");
      winner.print();
      game.leaderBoard();
    }
}

