package src.design09_Snake_N_Ladder_Game.Board.Jumper;

import java.util.HashMap;
import java.util.HashSet;

public class Jumper_SL {
    HashSet<Integer> positionUsed;
    HashMap<Integer,Jumper> jumpers;
    private int size;

    public Jumper_SL(int s) {
        this.positionUsed = new HashSet<>();
        this.jumpers = new HashMap<>();
        this.size=s;
    }

    public void setJumper(int startPos, int endPos, JumperType jumperType){
        // Jumper pos condt
        if(endPos>=size||startPos>=size||endPos<0||startPos<0||endPos==startPos){
            System.out.println(" Invalid jumper"+startPos+" "+endPos+" "+size);
        }
        //To avoid jumper collision
        else if(positionUsed.contains(startPos)){
            System.out.println(" Start pos already in use ");

        }
        //To avoid jumper collision
        else if(positionUsed.contains(endPos)){
            System.out.println(" End pos already in use ");
        }
        else{
            jumpers.put(startPos,new Jumper(endPos,jumperType));
            positionUsed.add(startPos);
            positionUsed.add(endPos);
        }
    }

    public Jumper checkJumper(int startPos){
        if(jumpers.containsKey(startPos)){
            return jumpers.get(startPos);
        }
        return null;
    }

}
