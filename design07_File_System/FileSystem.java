package src.design07_File_System;

public abstract class  FileSystem {

    String name;
    public String getName() {
        return this.name;
    }

    abstract public boolean isDirectory();

}
