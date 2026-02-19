package src.design14_Logging_System.LogType;

import src.design14_Logging_System.LogFormatter.HighLightFormatter;
import src.design14_Logging_System.LogFormatter.LoggerLogger;
import src.design14_Logging_System.LogHandler.ConsoleHandler;
import src.design14_Logging_System.LogHandler.FileOutputHandler;
import src.design14_Logging_System.LogLevel;

public class CriticalLog extends LogType{
    public CriticalLog(){
        super();
        this.logformatter=new HighLightFormatter();
        this.logHandler=new FileOutputHandler();
        this.ll= LogLevel.CRITICAL;

    }
}
