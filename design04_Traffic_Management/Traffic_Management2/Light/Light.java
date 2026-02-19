package src.design04_Traffic_Management.Traffic_Management2.Light;

import src.design04_Traffic_Management.Traffic_Management2.Light.Color.*;

public class Light {
    public iColor color;
    Direction direction;
    String piece;

    public void getPiece() {
        color.getPiece();
        //  System.out.println(" Piece +");
    }

    public Light(Direction direction){
        this.color= new RedLight();
        this.direction=direction;
        piece=new String(Character.toChars(0x21BC));
    }

    public Light(){
        this.color= new RedLight();
        this.direction=Direction.STRAIGHT;
    }

    public void changeColorExtends(){
        System.out.println(" Changes color by abstract ");
    }

    public void changeColor(){
       this.color=color.changeiColor();
    }

    public ColorList getColor(){
        return color.getColor();
    }

    public Direction getDirection(){
        return direction;
    }

    public void setRed() {
        color=new RedLight();
    }

    public void setYellow() {
        color=new YelloLight();
    }

    public void setGreen() {
        color=new GreenLight();
    }
}
