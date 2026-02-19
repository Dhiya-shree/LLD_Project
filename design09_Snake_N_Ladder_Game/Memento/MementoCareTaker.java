package src.design09_Snake_N_Ladder_Game.Memento;

import java.util.ArrayList;
import java.util.List;

public class MementoCareTaker {

    List<Memento> mementoList;
    public MementoCareTaker(){
        mementoList=new ArrayList<>();
    }

    public void add(Memento m){
        this.mementoList.add(m);
    }

    public void showMementoList() {
        for(Memento m:mementoList){
            System.out.println(" Player "+m.player.getName()+" pos "+m.player.getPosition());
        }
    }
}
