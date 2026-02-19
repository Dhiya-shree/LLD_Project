package src.design04_Traffic_Management.Traffic_Management2;

import src.design04_Traffic_Management.Traffic_Management2.Light.Traffic;

public class TrafficManagement_Main {

    public static void main(String[] args) {

        int timer=1;
        TrafficController controller=new TrafficController(new Traffic(20),timer);
        controller.start();
    }
}
