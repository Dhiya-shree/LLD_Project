package src.design04_Traffic_Management.Traffic_Management2.Light.Color;

public class YelloLight implements iColor {

   /** //state design pattern extends
    public void changeColorExtends(){
        this.color=new GreenLight();
    }
*/
   @Override
   public void getPiece() {
       System.out.println(new String(Character.toString((int)0x1F49B)));
   }
    @Override
    public iColor changeiColor() {
       return new GreenLight();
    }

    @Override
    public ColorList getColor() {
        return ColorList.YELLOW;
    }
}
