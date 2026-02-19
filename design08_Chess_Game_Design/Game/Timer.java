package src.design08_Chess_Game_Design.Game;

import java.util.Date;

public class Timer {
    long startTime;
    int round;
    int warning;

    public Timer() {
        this.startTime = System.currentTimeMillis();
    }

    public void TimerStart(){
        startTime=System.currentTimeMillis();
    }

    public void setTime(int r,int w){
        round=r*60*100;
        warning=w*60*100;
    }

    public boolean CheckTime(){
        long curr=System.currentTimeMillis();
       int diff= (int) (curr-startTime);
       if(diff>round){
           return false;
       }
       else if(diff>=warning){
           System.out.println(" Last warning ... ");
       }
       return true;


    }
}
