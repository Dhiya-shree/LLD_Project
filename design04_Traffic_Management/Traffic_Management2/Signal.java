package src.design04_Traffic_Management.Traffic_Management2;
import src.design04_Traffic_Management.Traffic_Management2.Light.Color.RedLight;
import src.design04_Traffic_Management.Traffic_Management2.Light.Direction;
import src.design04_Traffic_Management.Traffic_Management2.Light.Light;

import java.util.ArrayList;
import java.util.List;


public class Signal {
    //Each signal has 3 light
    private List<Light> lights;
    private final Light straight;
    private final Light left;
    private final Light right;
    private final Light pedestrian;
    private final int name;
    Signal(int name){
        this.name=name;
        straight=new Light(Direction.STRAIGHT);
        left=new Light(Direction.LEFT);
        right=new Light(Direction.RIGHT);
        pedestrian=new Light(Direction.WALK);
        lights=new ArrayList<Light>();
        lights.add(left);lights.add(straight);lights.add(right);
        lights.add(pedestrian);
    }

    void turnOff(){
        for(Light light:lights){
            light.changeColorExtends();
        }
    }

    public void turnOn() {
        for(Light light:lights){
            System.out.println(" Light "+light.getColor()+" at "+light.getDirection());
        }

        try {
            Thread.sleep(5000);

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            for(Light light:lights){
                light.changeColorExtends();
            }
        }
    }

    public void resetRed() {
        for(Light light: lights){
            light.setRed();
        }
    }
    public void resetYellow() {
        for(Light light: lights){
            light.setYellow();
        }
    }

    public void resetGreen() {
        for(Light light: lights){
            light.setGreen();
        }
    }

    public Light getPedestrian() {
        return pedestrian;
    }

    public Light getStraight() {
        return straight;
    }

    public Light getLeft() {
        return left;
    }

    public Light getRight() {
        return right;
    }

    public int getName() {
        return name;
    }

    public List<Light> getLights() {
        return lights;
    }

    public void setLights(List<Light> lights) {
        this.lights = lights;
    }

    public void LeftRight(){
        left.changeColor();
        right.changeColor();
    }

    public void StraightPedestrian(){
        straight.changeColor();
        right.changeColor();
    }

    public void printAll() {
        for(Light light: lights){
            System.out.print(light.getDirection()+" "+light.getColor());
            light.getPiece();
        }
    }
}
