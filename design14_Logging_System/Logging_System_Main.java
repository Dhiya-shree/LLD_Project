package src.design14_Logging_System;

import src.design14_Logging_System.LogHandler.ConsoleHandler;
import src.design14_Logging_System.LogHandler.FileOutputHandler;

public class Logging_System_Main {
    public static void main(String[] args) {

        Logger logger=Logger.getInstance();
        logger.log(LogLevel.WARNING,"Hey warning ");
        logger.log(LogLevel.INFO,"Hey INFO ");
        logger.log(LogLevel.CRITICAL,"Hey CRITICAL ");
        logger.log(LogLevel.DEBUG,"Hey DEBUG ");
        logger.log(LogLevel.ERROR,"Hey ERROR ");

        logger.setLogHandlers(new FileOutputHandler());
        logger.log(LogLevel.WARNING,"Hey warning  fo");
        logger.log(LogLevel.INFO,"Hey INFO  fo");
        logger.log(LogLevel.CRITICAL,"Hey CRITICAL fo");
        logger.log(LogLevel.DEBUG,"Hey DEBUG  fo");
        logger.log(LogLevel.ERROR,"Hey ERROR fo");

        logger.resetLogHandlers();
        logger.setLogHandlers(new ConsoleHandler());
        logger.log(LogLevel.WARNING,"Hey warning co");
        logger.log(LogLevel.INFO,"Hey INFO co");
        logger.log(LogLevel.CRITICAL,"Hey CRITICAL co");
        logger.log(LogLevel.DEBUG,"Hey DEBUG co ");
        logger.log(LogLevel.ERROR,"Hey ERROR co");




    }
}
