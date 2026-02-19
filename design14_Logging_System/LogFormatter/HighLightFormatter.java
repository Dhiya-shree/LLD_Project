package src.design14_Logging_System.LogFormatter;

import src.design14_Logging_System.LogLevel;

public class HighLightFormatter implements LogFormatter{

    public String format(LogLevel ll, String message){
        return (">>>>>>>>>>========================"+ll+"================================= \n ----->>>>> "+message+
                " \n=========================================================<<<<<<<<<<<");
    }
}