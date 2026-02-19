package src.design09_Snake_N_Ladder_Game.Memento;

import src.design09_Snake_N_Ladder_Game.Board.Player;

public class Memento {
    Player player;

    public Memento(Player player) {
        this.player = new Player(player.getName(),player.getIcon());
        this.player.setPosition(player.getPosition());
    }
}
