package src.design14_Logging_System.LogFormatter;

import src.design14_Logging_System.LogLevel;

import java.time.Instant;
import java.util.Date;

public class LoggerLogger  implements LogFormatter {

    public String format(LogLevel ll, String message) {
        return (ll+"------>>>>>" + Date.from(Instant.now()) + " <<<<<---------- \n ......>>>>>  " + message + " \n");
    }

}