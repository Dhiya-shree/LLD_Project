package src.design09_Snake_N_Ladder_Game.Board.Jumper;

public class Jumper {
    private int position;
    private JumperType type;

    public Jumper(int position, JumperType type) {
        this.position = position;
        this.type = type;
    }

    public int getPosition() {
        return position;
    }

    public JumperType getType() {
        return type;
    }
}
