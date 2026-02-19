package src.design09_Snake_N_Ladder_Game.Board;

import src.design09_Snake_N_Ladder_Game.Board.Jumper.Jumper;
import src.design09_Snake_N_Ladder_Game.Board.Jumper.JumperType;
import src.design09_Snake_N_Ladder_Game.Board.Jumper.Jumper_SL;

import java.util.HashMap;
import java.util.List;

public class Board {
    HashMap<Player,Integer> board;
    Dice dice;
    Jumper_SL jumper;
    int size;

    public Board(List<Player> playerList, Jumper_SL jumper,int s) {
        this.board = new HashMap<>();
        for(Player p:playerList){
            board.put(p,0);
        }
        this.dice = new Dice();
        this.jumper = jumper;
        this.size=s;
    }


    public void RollDice(Player p){
        int d=dice.getValue();

        System.out.println(" Dice value is "+d);
        int currVal=board.get(p)+d;
        if(currVal>this.size){
            System.out.println(" Not possible wait for next turn ....");
            return;
        }


        Jumper j=jumper.checkJumper(currVal);
        if(j==null){
            board.put(p,currVal);
            p.setPosition(currVal);
            System.out.println(p.getName()+" value updated to "+currVal);
        }
        else if(j.getType()==JumperType.Snake) {
            System.out.println("OOPS!! Got bitten by a snake ..... Move to pos: " + j.getPosition());
            board.put(p, j.getPosition());
            p.setPosition(j.getPosition());
        }
        else{
            System.out.println("Hurray!! Got a ladder ..... Move to pos: " + j.getPosition());
            board.put(p, j.getPosition());
            p.setPosition(j.getPosition());
        }
    }

    public Board(List<Player> playerList,int s) {
        this.board = new HashMap<>();
        for(Player p:playerList){
            board.put(p,0);
        }
        this.dice = new Dice();
        this.jumper = new Jumper_SL(s);
        this.size=s;
        setJumperManual();
    }

    private void setJumperManual() {
        jumper.setJumper(3,30, JumperType.Snake);
        jumper.setJumper(15,4,JumperType.Ladder);
    }

    public void removePlayer(Player currentPlayer) {
        board.remove(currentPlayer);
    }
}
