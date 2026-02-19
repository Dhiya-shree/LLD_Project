package src.design14_Logging_System.LogType;

import src.design14_Logging_System.LogFormatter.HighLightFormatter;
import src.design14_Logging_System.LogHandler.FileOutputHandler;
import src.design14_Logging_System.LogLevel;

public class DebugLog extends LogType{


    public DebugLog() {
        super();
        this.logformatter = new HighLightFormatter();
        this.logHandler = new FileOutputHandler();
        this.ll = LogLevel.DEBUG;

    }

            }