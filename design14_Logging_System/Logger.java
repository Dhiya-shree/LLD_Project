package src.design14_Logging_System;

import src.design14_Logging_System.LogHandler.LogHandler;
import src.design14_Logging_System.LogType.*;

import java.util.ArrayList;

public class Logger {

     ArrayList<LogHandler> logHandlers;

     void setLogHandlers(LogHandler lh){
         logHandlers.add(lh);
     }

    void resetLogHandlers(){
        logHandlers=new ArrayList<>();
    }


     void log(LogLevel ll,String message){

         LogType logType=createLogType(ll);
         if(logHandlers.isEmpty()){
             logType.log(message);
         }
         else{
             String formatted=logType.format(message);
             for(LogHandler l:logHandlers){
                 l.handle(formatted);
             }
         }

     }

     // new class for factory needed
    private LogType createLogType(LogLevel ll) {

         switch(ll){
             case DEBUG:return new DebugLog();
             case INFO:return new InfoLog();
             case ERROR:return new ErrorLog();
             case CRITICAL:return new CriticalLog();
             default:return new WarningLog();
         }
    }

    //SingleTon
    private static Logger instance;
    private Logger(){
        System.out.println(" New instance created ");
        this.logHandlers=new ArrayList<>();
    }
    public static Logger getInstance(){
        if(instance==null){

            synchronized (Logger.class){
                if(instance==null){
                    instance=new Logger();
                }
            }
        }
        return instance;
    }
}
