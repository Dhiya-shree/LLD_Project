package src.design03_Tic_Tac_Toe;

import java.util.UUID;

public class User {
    private final UUID uuid;
    private final String name;
    private int wins;
    private int matches;

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    private int draw;

    public User(String name) {
        this.name = name;
        this.uuid=UUID.randomUUID();
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getMatches() {
        return matches;
    }

    public void setMatches(int matches) {
        this.matches = matches;
    }
}
