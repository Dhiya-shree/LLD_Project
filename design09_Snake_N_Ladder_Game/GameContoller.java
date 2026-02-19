package src.design09_Snake_N_Ladder_Game;
import src.design09_Snake_N_Ladder_Game.Board.Board;
import src.design09_Snake_N_Ladder_Game.Board.Player;
import src.design09_Snake_N_Ladder_Game.Memento.Memento;
import src.design09_Snake_N_Ladder_Game.Memento.MementoCareTaker;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class GameContoller {
    private Queue<Player> players;
    private Board board;
    private int toWin=100;
    MementoCareTaker mementoCareTaker;

    public GameContoller(List<Player> playerList) {
        this.players = new ArrayDeque<>(playerList);
        this.board=new Board(playerList,toWin);

        this.mementoCareTaker=new MementoCareTaker();
        init();
    }

    public void init(){
        //shuffle players
        for(int i=0;i<10;i++){
            for(int j=0;j<((int)(Math.random()*3));j++){
                Player p=players.poll();
                players.add(p);
            //    mementoCareTaker.add(new Memento(p));
            }
        }
    }

    public Player startGame(){


        while(true){
            Player currentPlayer=players.poll();
            System.out.println(" Current Player "+currentPlayer.getUuid()+" NAME: " +
                    currentPlayer.getName()+ " Icon "+currentPlayer.getIcon());
            System.out.println(" Press 1 to remove from game ");
          //  Scanner sc=new Scanner(System.in);
            int c=0;//sc.nextInt();
            if(c==1){
                board.removePlayer(currentPlayer);
                if(players.isEmpty()){
                    return currentPlayer;
                }
                continue;
            }


            board.RollDice(currentPlayer);
            mementoCareTaker.add(new Memento(currentPlayer));
            if(currentPlayer.getPosition()==toWin){
                System.out.println(" Winner found !!!");
                return currentPlayer;
            }
            players.add(currentPlayer);

        }

    }

}
