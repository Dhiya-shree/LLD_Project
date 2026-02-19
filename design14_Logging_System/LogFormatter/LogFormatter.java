package src.design14_Logging_System.LogFormatter;

import src.design14_Logging_System.LogLevel;

public interface LogFormatter {

      String format(LogLevel ll,String message);
}
