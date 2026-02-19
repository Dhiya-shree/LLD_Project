package src.design14_Logging_System.LogHandler;

public class ConsoleHandler implements LogHandler{
    @Override
    public void handle(String message) {
        System.out.println(message);
    }
}
