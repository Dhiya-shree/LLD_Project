package src.design14_Logging_System.LogFormatter;

import src.design14_Logging_System.LogLevel;

public class SimpleFormatter implements LogFormatter{

    public  String format(LogLevel ll, String message){
        return (ll+": ......>>>>>  "+message);
    }
}
