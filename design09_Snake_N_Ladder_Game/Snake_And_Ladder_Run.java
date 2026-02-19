package src.design09_Snake_N_Ladder_Game;

import src.design09_Snake_N_Ladder_Game.Board.Player;

import java.util.ArrayList;
import java.util.List;

public class Snake_And_Ladder_Run {
    public static void main(String[] args) {
        Player p1=new Player("A","A");
        Player p2=new Player("B","B");
        Player p3=new Player("C","C");
        Player p4=new Player("D","D");
        List<Player> players=new ArrayList<>();
        players.add(p1);players.add(p2);players.add(p3);players.add(p4);

        GameContoller game=new GameContoller(players);
        Player win=game.startGame();
        System.out.println(" Winner is "+win.getIcon()+" "+win.getName());
        System.out.println(" Replay ");
        game.mementoCareTaker.showMementoList();
    }
}
