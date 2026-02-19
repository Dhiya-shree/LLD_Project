package src.design14_Logging_System.LogType;

import src.design14_Logging_System.LogFormatter.LogFormatter;
import src.design14_Logging_System.LogHandler.LogHandler;
import src.design14_Logging_System.LogLevel;

public class LogType implements LogFormatter,LogHandler{
    LogFormatter logformatter;
    LogHandler logHandler;
    LogLevel ll;

    public void log(String message){
        String s=format(ll,message);
        handle(s);
    }

    public String format(String message) {
      return format(this.ll,message);
    }

    @Override
    public String format(LogLevel ll, String message) {
        return this.logformatter.format(ll,message);
    }


    @Override
    public void handle(String message) {
        this.logHandler.handle(message);
    }
}
