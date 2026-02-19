package src.design14_Logging_System.LogHandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileOutputHandler  implements LogHandler{
    @Override
    public void handle(String message) {
        try{
          //  BufferedReader br=new BufferedReader(new FileWriter(path));
            //br.write()
            //br.close()
            Path path= Path.of("D:/Repos/Projcets LLD/LLD Projects/src/design14_Logging_System/LogHandler/Log_Output.txt");
            Files.writeString(path,message);
        }
        catch (Exception e){
            System.out.println(" Error "+e);
        }
    }
}
