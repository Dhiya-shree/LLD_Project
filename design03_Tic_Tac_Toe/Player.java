package src.design03_Tic_Tac_Toe;

public class Player {
    private final User user;
    private final PieceType pieceType;

    public Player(String userName, int value,int codePoint) {
        this.user = new User(userName);
        this.pieceType = new PieceType(value,codePoint);
    }

    public void print(){
        System.out.println(getName()+" with "+getPieceType().getCodePoint());
    }

    public Player(String userName, int value){
        this.user = new User(userName);
        this.pieceType = new PieceType(value);
    }


    public User getUser() {
        return user;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public String getName(){
        return this.user.getName();
    }

    public Integer getValue() {
        return this.pieceType.getValue();
    }

}
