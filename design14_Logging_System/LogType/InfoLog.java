package src.design14_Logging_System.LogType;

import src.design14_Logging_System.LogFormatter.SimpleFormatter;
import src.design14_Logging_System.LogHandler.ConsoleHandler;
import src.design14_Logging_System.LogHandler.FileOutputHandler;
import src.design14_Logging_System.LogLevel;

public class InfoLog extends LogType {

    public InfoLog() {
        super();
        this.logformatter = new SimpleFormatter();
        this.logHandler = new ConsoleHandler();
        this.ll = LogLevel.INFO;

    }

}