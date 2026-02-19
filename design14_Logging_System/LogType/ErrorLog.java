package src.design14_Logging_System.LogType;

import src.design14_Logging_System.LogFormatter.SimpleFormatter;
import src.design14_Logging_System.LogHandler.FileOutputHandler;
import src.design14_Logging_System.LogLevel;

public class ErrorLog  extends LogType{

    public ErrorLog(){
        super();
        this.logformatter=new SimpleFormatter();
        this.logHandler=new FileOutputHandler();
        this.ll= LogLevel.ERROR;

    }
}
