package src.design04_Traffic_Management.Traffic_Management2.Light.Color;

public class GreenLight implements iColor {

    /**
     *
//state design pattern extends
    public void changeColorExtends(){
        this.color=new RedLight();
    }
*/
    @Override
    public iColor changeiColor() {
        return new RedLight();
    }

    @Override
    public void getPiece() {
        System.out.print(new String(Character.toString((int)0x1F49A)));
    }

    @Override
    public ColorList getColor() {
        return ColorList.GREEN;
    }
}
