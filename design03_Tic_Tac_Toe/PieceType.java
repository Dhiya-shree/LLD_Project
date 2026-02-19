package src.design03_Tic_Tac_Toe;

public class PieceType {

    private final int value;
    private final String codePoint;

    public PieceType(int value, int piece) {
        int codePoint1 = 0x1F47E;

        this.value = value;
        switch (piece){
            case 0->{ codePoint1 =0x25C7;}
            case 1-> {
                codePoint1 = 0x1F921;
            }
            case 2-> {
                codePoint1 = 0x1F47E;
            }
            case 3->{ codePoint1 =0X2764;}

            case 4->{codePoint1 =0x1F499;}
            case 5->{ codePoint1 =0X1F49A;}
            case 6->{ codePoint1 =0x1F90D;}
        }
        this.codePoint = new String(Character.toChars(codePoint1));
    }

    public PieceType(int value) {
        this.codePoint = new String(Character.toChars(0x1F49C));
        this.value = value;
    }

    public String getCodePoint() {
        return codePoint;
    }

    public int getValue() {
        return value;
    }
}
