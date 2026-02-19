package src.design14_Logging_System.LogType;

import src.design14_Logging_System.LogFormatter.LogFormatter;
import src.design14_Logging_System.LogFormatter.LoggerLogger;
import src.design14_Logging_System.LogHandler.ConsoleHandler;
import src.design14_Logging_System.LogLevel;

public class WarningLog extends LogType{
    public WarningLog(){
        super();
        this.logformatter=new LoggerLogger();
        this.logHandler=new ConsoleHandler();
        this.ll= LogLevel.WARNING;

    }

}
