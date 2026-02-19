package src.design09_Snake_N_Ladder_Game.Board;

import java.util.UUID;

public class Player {
    final private UUID uuid;
    private final String name;
    private final String icon;
    private  int position;

    public void setPosition(int position) {
        this.position = position;
    }

    public Player(String name, String icon) {
        this.name = name;
        this.icon = icon;
        this.position=0;
        this.uuid=UUID.randomUUID();
    }

    public String getIcon() {
        return icon;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public UUID getUuid() {
        return uuid;
    }
}
