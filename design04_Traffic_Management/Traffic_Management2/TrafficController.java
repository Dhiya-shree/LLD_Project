package src.design04_Traffic_Management.Traffic_Management2;

import src.design04_Traffic_Management.Traffic_Management2.Light.Light;
import src.design04_Traffic_Management.Traffic_Management2.Light.Traffic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TrafficController {
    List<Signal> signals;
    List<Traffic> trafficList;
    List<Traffic> pedestrians;
    String data[][]=new String[9][9];
     int totalPedestrian;
     int totalTraffic;
    int timer=10;
    // List
    // 0 1st lane , 1 2nd lane .....

    TrafficController(Traffic traffic){
        signals=new ArrayList<>();
        trafficList=new ArrayList<>();
        pedestrians=new ArrayList<>();
        totalPedestrian=traffic.getVehicle()*4;
        totalTraffic=traffic.getVehicle()*4;
        for(int i=0;i<4;i++){
            signals.add(new Signal(i+1));
            trafficList.add(traffic);
            pedestrians.add(traffic);
        }
        Create();
    }

    TrafficController(Traffic traffic,int time){
        signals=new ArrayList<>();
        trafficList=new ArrayList<>();
        pedestrians=new ArrayList<>();
        totalPedestrian=traffic.getVehicle()*4;
        totalTraffic=traffic.getVehicle()*4;
        this.timer=time;
        for(int i=0;i<4;i++){
            signals.add(new Signal(i+1));
            trafficList.add(traffic);
            pedestrians.add(traffic);
        }
        Create();
    }

    private void Create() {
        for(int i=0;i<9;i++){
            for(int j=0;i<9;i++){
                data[i][j]=new String((Character.toChars(0x25A00)));
            }
        }
        for(int i=3;i<6;i++){
            for(int j=0;i<9;i++){
                data[i][j]=new String((Character.toChars(0x25A00)));
            }
        }
        for(int i=0;i<9;i++){
            for(int j=3;i<6;i++){
                data[i][j]=new String((Character.toChars(0x21BC)));
            }
        }
    }


    public void addVehicleTraffic(int lane,int vehicle){
        trafficList.set(lane,new Traffic((trafficList.get(lane).getVehicle()+vehicle)));
    }

    public void addPedestrianTraffic(int lane,int pedestrian){
        pedestrians.set(lane,new Traffic((pedestrians.get(lane).getVehicle()+pedestrian)));
    }

    public void start(){
        long start=System.currentTimeMillis();
        Scanner sc=new Scanner(System.in);
        int step=0;
        while(true){
            System.out.println(" Press 1 for continue , 0 for adding traffic ");
            int x=sc.nextInt();
            if(x==0){
                System.out.println(" Put lane ");
                int l=sc.nextInt();
                System.out.println(" Put vehicles ");
                int v=sc.nextInt();
                System.out.println(" Put people ");
                int p=sc.nextInt();
                trafficList.set(l,new Traffic(trafficList.get(l).getVehicle()+v));
                totalTraffic=totalTraffic+v;
                pedestrians.set(l,new Traffic(pedestrians.get(l).getVehicle()+p));
                totalPedestrian=totalPedestrian+p;

            }
            else if(totalPedestrian==0 && totalTraffic==0){
                System.out.println(" Traffic cleared !!!!!");
                break;
            }
            else{

                try{
                    Thread.sleep(timer*1000);
                }
                catch(Exception e){
                    System.out.println(" Exception... "+e.getMessage());
                }
                finally{
                    Print(data);
                    SwitchLanes(step);
                    ReduceTraffic(step);
                    step=(step+1)%4;
                }

            }

        }
    }

    private void Print(String[][] data) {

        for(int i=0;i<4;i++){
            System.out.println("Lane "+(i+1)+" Signals ");
            signals.get(i).printAll();
            System.out.println(i+" Traffic "+trafficList.get(i).getVehicle()+" People:"+pedestrians.get(i).getVehicle());
        }
      /*  for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(data[i][j]);
            }
            System.out.println();
        }*/
    }

    private void ReduceTraffic(int step) {

        totalTraffic=Math.max(0,(totalTraffic-(2*timer*10)));
        switch(step) {
            case 0-> {
                trafficList.set(0, new Traffic(Math.max(0,trafficList.get(0).getVehicle() - timer*10)));
                trafficList.set(3, new Traffic(Math.max(0,trafficList.get(3).getVehicle() - timer*10)));
            }
            case 1-> {

                totalPedestrian=Math.max(0,(totalPedestrian-(2*timer*15)));
                trafficList.set(0, new Traffic(Math.max(0,trafficList.get(0).getVehicle() - timer*10)));
                trafficList.set(3, new Traffic(Math.max(0,trafficList.get(3).getVehicle() - timer*10)));
                pedestrians.set(1, new Traffic(Math.max(0,pedestrians.get(1).getVehicle() - timer*15)));
                pedestrians.set(2, new Traffic(Math.max(0,pedestrians.get(2).getVehicle() - timer*15)));
            }
            case 2-> {
                trafficList.set(1, new Traffic(Math.max(0,trafficList.get(1).getVehicle() - timer*10)));
                trafficList.set(2, new Traffic(Math.max(0,trafficList.get(2).getVehicle() - timer*10)));
            }
            case 3-> {
                totalPedestrian=Math.max(0,(totalPedestrian-(2*timer*20)));
                trafficList.set(2, new Traffic(Math.max(0,trafficList.get(2).getVehicle() - timer*10)));
                trafficList.set(1, new Traffic(Math.max(0,trafficList.get(1).getVehicle() - timer*10)));
                pedestrians.set(0, new Traffic(Math.max(0,pedestrians.get(0).getVehicle() - timer*20)));
                pedestrians.set(3, new Traffic(Math.max(0,pedestrians.get(3).getVehicle() - timer*20)));
            }

        }
    }

    private void SwitchLanes(int step) {
        List<Signal> setSignal=new ArrayList<Signal>();
        switch (step){
            case 0->{
                for(Signal signal:signals) {
                    signal.resetRed();
                }
                signals.get(0).LeftRight();//green
                signals.get(0).StraightPedestrian();
                signals.get(0).StraightPedestrian();//yellow
                signals.get(3).LeftRight();//green
                signals.get(3).StraightPedestrian();
                signals.get(3).StraightPedestrian();//yellow
            }
            case 1->{
                signals.get(0).LeftRight();//green-> red
               signals.get(0).StraightPedestrian();//yellow ->green
                signals.get(3).LeftRight();//green->red
                signals.get(3).StraightPedestrian();//yellow ->green


                signals.get(1).LeftRight();//red-yellow
                signals.get(2).LeftRight();//red-yellow
            }
            case 2->{
                signals.get(0).StraightPedestrian();//yellow ->green->red
                signals.get(3).StraightPedestrian();//yellow ->green ->red

                signals.get(1).LeftRight();//red-yellow->green
                signals.get(2).LeftRight();//red-yellow ->green

                signals.get(1).StraightPedestrian();//red-yellow
                signals.get(2).StraightPedestrian();//red-yellow
            }
            case 3->{
                signals.get(1).LeftRight();//red-yellow->green->red
                signals.get(2).LeftRight();//red-yellow ->green->red

                signals.get(1).StraightPedestrian();//red-yellow-> Green
                signals.get(2).StraightPedestrian();//red-yellow->gREEN

                signals.get(0).LeftRight();//red-ye
                signals.get(3).LeftRight();//red-y
            }
        }
    }

    public void startClass(){
        Signal prev=null;
        int i=0;
        while(true){
            Signal newSignal=signals.get(i);
            i=(i+1)%4;// update and less than 4
            if(prev!=null){
                prev.turnOff();
            }
            newSignal.turnOn();
            prev=newSignal;
        }
    }

}
