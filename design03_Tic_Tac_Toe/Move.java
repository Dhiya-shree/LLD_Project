package src.design03_Tic_Tac_Toe;

public class Move {
    //Entity Class
    // Used to share player moves to Game
    // Used for Undo
    // Stack the moves for forward
    // Unstack the moves for Undo
    private final int x,y;
    private final Player player;

    public Move(int x, int y, Player player) {
        this.x = x;
        this.y = y;
        this.player = player;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Player getPlayer() {
        return player;
    }
}
