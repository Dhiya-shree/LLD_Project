package src.design04_Traffic_Management.Traffic_Management2.Light.Color;

public class RedLight implements iColor {

    //state design pattern extends
  /**
   * extends Light ..
   public void changeColorExtends(){
        this.color=new YelloLight();
    }
*/
    @Override
    public iColor changeiColor() {
        return new YelloLight();
    }

    @Override
    public void getPiece() {
        System.out.print(new String(Character.toString(0x1F534)));
    }

    @Override
    public ColorList getColor() {
       return ColorList.RED;
    }
}
